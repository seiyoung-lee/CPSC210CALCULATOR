package functions;


import exceptions.CannotDivideByZero;
import exceptions.ForgotToWrite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ComplexFunc implements FindFunc {
    private HashMap<Character, ArrayList<Integer>> parenthesisall;
    private String paranthesis;
    private ComplexSimpleFunc csf;
    private String operation;

    public ComplexFunc(String operation) throws ForgotToWrite, CannotDivideByZero,
            IOException {
        this.operation = operation;
        parenthesisall = new HashMap<>();
        find();
        findtheoperation();
    }

//modifies: this
// effect: separates the operation and calculates in parts

    @Override
    public void findtheoperation() throws ForgotToWrite, IOException, CannotDivideByZero {
        paranthesis = operation;
        if (parenthesisall.keySet().isEmpty()) {
            paranthesis = operation;
        } else if (parenthesisall.get('(').size() > 0) {
            for (int i = 0; i < parenthesisall.get('(').size();i++) {
                String subcomplexplusparan = operation.substring(parenthesisall.get('(').get(i),
                        parenthesisall.get(')').get(i) + 1);
                String subcomplex = operation.substring(parenthesisall.get('(').get(i) + 1,
                        parenthesisall.get(')').get(i));
                csf = new ComplexSimpleFunc(subcomplex);
                String newsub = String.valueOf(csf.functionequals());
                paranthesis = paranthesis.replace(subcomplexplusparan, newsub);
            }
        }
    }

//modifies:this
//effect: finds paranthesis location and put them in the hashcode

    @Override
    public void find()  {
        ArrayList first = new ArrayList<>();
        ArrayList second =  new ArrayList<>();
        for (int i = 0; i < operation.length(); i++) {
            if (String.valueOf(operation.charAt(i)).equals("(")) {
                first = putparan('(', i);
            } else if (String.valueOf(operation.charAt(i)).equals(")")) {
                second = putparan(')', i);
            }
        }
        assert (first.size() == second.size());
    }

    private ArrayList putparan(Character operand, int i) {
        ArrayList<Integer> paran;
        if (!(parenthesisall.containsKey(operand))) {
            paran = new ArrayList<>();
            paran.add(i);
            parenthesisall.put(operand, paran);
        } else {
            paran = parenthesisall.get(operand);
            paran.add(i);
        }
        return paran;
    }

    public Integer sizeparanthesis1() {
        return parenthesisall.get('(').size();
    }

    public Integer sizeparanthesis2() {
        return parenthesisall.get(')').size();
    }

    public String getParanthesis() {
        return paranthesis;
    }

    //effect: returns calculted value

    @Override
    public double functionequals() throws IOException, CannotDivideByZero, ForgotToWrite {
        csf = new ComplexSimpleFunc(paranthesis);
        return csf.functionequals();
    }
}
