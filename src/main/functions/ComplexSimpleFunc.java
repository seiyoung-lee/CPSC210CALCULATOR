package functions;

import exceptions.CannotDivideByZero;
import exceptions.ForgotToWrite;
import exceptions.ForgotToWriteOperation;
import exceptions.ForgotToWriteNum;

import java.io.IOException;
import java.util.ArrayList;

public class ComplexSimpleFunc implements FindFunc {
    private ArrayList<String> numbers = new ArrayList<>();
    private ArrayList<String> operations = new ArrayList<>();
    private ArrayList<Integer> operationlocation = new ArrayList<>();
    private String operation;
    private double result;
    private int num = 0;
    private int previouslocation = 0;
    private Simplefunc sf;


    public ComplexSimpleFunc(String longfunc) throws ForgotToWrite, IOException,
            CannotDivideByZero {
        operation = longfunc;
        bydirections();
        findtheoperation();
        find();
    }

    // requires: operationlocation is not empty
//modifies: this
// effect: finds the numbers in respect to the location of the operation


    @Override
    public void find() throws ForgotToWriteNum, IOException, CannotDivideByZero {
        int currentlocation = operationlocation.get(num);
        while (true) {
            double number;
            number = makenumber(previouslocation, currentlocation);
            if (numbers.size() >= operations.size()) {
                putnumber(number);
                break;
            } else if (num >= operationlocation.size() - 1) {
                currentlocation = puteverything(number, currentlocation, operation.length(), operation.length());
            } else {
                currentlocation = puteverything(number, currentlocation, num + 1, operation.length());
            }
        }
    }

    private double makenumber(int loc, int numb) throws IOException, CannotDivideByZero,
                                                                                                ForgotToWriteNum {
        double goback;
        if (operation.charAt(loc) == 'l') {
            sf = new Simplefuncload();
            sf.setsecondnum(0);
            sf.setTheoperation("+");
            goback = sf.functionequals();
        } else if (isNotNumeric(operation.substring(loc,numb))) {
            throw new ForgotToWriteNum();
        } else {
            goback = Double.parseDouble(operation.substring(loc, numb));
        }
        return goback;
    }

    private void bydirections() throws IOException, ForgotToWrite, CannotDivideByZero {
        ComplexFunc cf = new ComplexFunc(operation);
        operation = cf.getParanthesis() + "+0";
    }

    private static boolean isNotNumeric(String strNum) {
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return true;
        }
        return false;
    }

    private void putnumber(double number) {
        String stringnumber = String.valueOf(number);
        numbers.add(stringnumber);
    }


    private int puteverything(double number, int currentlocation, int length, int reallength) {
        int i;
        putnumber(number);
        previouslocation = currentlocation + 1;
        if (length == reallength) {
            i = reallength;
            num++;
        } else {
            i = operationlocation.get(length);
            num++;
        }
        return i;
    }


//modifies: this
// effect: finds the operations

    @Override
    public void findtheoperation() throws ForgotToWriteOperation {
        int i = 0;
        assert (operation.length() > 0);
        while (i < operation.length()) {
            if (String.valueOf(operation.charAt(i)).equals("+")
                    || String.valueOf(operation.charAt(i)).equals("-")
                    || String.valueOf(operation.charAt(i)).equals("*")
                    || String.valueOf(operation.charAt(i)).equals("/")
                    || String.valueOf(operation.charAt(i)).equals("^")) {
                operations.add(String.valueOf(operation.charAt(i)));
                operationlocation.add(i);
            }
            i++;
        }
        if (operations.size() == 0) {
            throw new ForgotToWriteOperation();
        }
    }

    private void pemdas() throws IOException, CannotDivideByZero {
        if (operations.contains("^")) {
            allForOperation("^", "none");
        } else if (operations.contains("*") || operations.contains("/")) {
            allForOperation("*", "/");
        } else if (operations.contains("+") || operations.contains("-")) {
            allForOperation("+", "-");
        }
    }

    private void allForOperation(String operand, String operand2) throws IOException, CannotDivideByZero {
        for (int i = 0; i < operations.size(); i++) {
            String oper = operations.get(i);
            if (oper.eqals(operand)) {
                theoperation(operand, i);
                i--;
            } else if (oper.equals(operand2)) {
                theoperation(operand2, i);
                i--;
            }
        }
    }

    private void theoperation(String operand, int i) throws IOException, CannotDivideByZero {
        double result = 0;
        sf = new SimplefuncOrigi();
        sf.setTheoperation(operand);
        sf.setfirstnum(Double.parseDouble(numbers.get(i)));
        sf.setsecondnum(Double.parseDouble(numbers.get(i + 1)));
        result = sf.functionequals();
        operations.remove(i);
        numbers.set(i, String.valueOf(result));
        numbers.remove(i + 1);
    }

//effect: returns the calculations
    @Override
    public double functionequals() throws IOException, CannotDivideByZero {
        for (int i = 0; i <= operations.size() + 1; i++) {
            pemdas();
            if (operations.isEmpty()) {
                result = Double.parseDouble(numbers.get(0));
            }
        }
        return result;
    }
}
