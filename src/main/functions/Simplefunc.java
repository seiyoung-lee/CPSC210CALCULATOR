package functions;


import exceptions.CannotDivideByZero;
import exceptions.ResultCannotBeAboveMillion;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public abstract class Simplefunc implements FunctionArithmetic {
    private double firstnum;
    private double secondnum;
    private String theoperation;
    private double result;

//requires: operation cannot have decimals

    Simplefunc() {
    }

    public void setTheoperation(String theoperation) {
        this.theoperation = theoperation;
    }

    public void setfirstnum(double firstnum) {
        this.firstnum = firstnum;
    }

    public void setsecondnum(double number2) {
        this.secondnum = number2;
    }

    public double getFirstnum() {
        return firstnum;
    }

    public double getSecondnumnum() {
        return secondnum;
    }

    public String getTheoperation() {
        return theoperation;
    }
//requires: first num and second num are not null
////// effect: returns the calculation


    @Override
    public double nowsum() {
        result = (firstnum + secondnum);
        if (throwexcept(result)) {
            throw new ResultCannotBeAboveMillion();
        } else {
            return this.result;
        }
    }

    private boolean throwexcept(double result) {
        return result > 999999;
    }
//requires: first num and second num are not null
////// effect: returns the calculation

    @Override
    public double nowmultiply() {
        result = (firstnum * secondnum);
        if (throwexcept(result)) {
            throw new ResultCannotBeAboveMillion();
        } else {
            return this.result;
        }
    }
//requires: first num and second num are not null
////// effect: returns the calculation

    @Override
    public double nowdivide() throws CannotDivideByZero {
        if (secondnum == 0) {
            throw new CannotDivideByZero();
        } else {
            result = (firstnum / secondnum);
            if (throwexcept(result)) {
                throw new ResultCannotBeAboveMillion();
            } else {
                return this.result;
            }
        }
    }
//requires: first num and second num are not null
////// effect: returns the calculation

    @Override
    public double nowsub() {
        result = (firstnum - secondnum);
        if (throwexcept(result)) {
            throw new ResultCannotBeAboveMillion();
        } else {
            return this.result;
        }
    }
//requires: first num and second num are not null
////// effect: returns the calculation

    @Override
    public double nowpower() {
        result = Math.pow(firstnum, secondnum);
        if (throwexcept(result)) {
            throw new ResultCannotBeAboveMillion();
        } else {
            return this.result;
        }
    }
//requires: first num and second num are not null
// effect: returns the calculation and saves the result

    public double functionequals() throws IOException, CannotDivideByZero {
        if (theoperation.equals("+")) {
            nowsum();
        } else if (theoperation.equals("*")) {
            nowmultiply();
        } else if (theoperation.equals("/")) {
            nowdivide();
        } else if (theoperation.equals("-")) {
            nowsub();
        } else if (theoperation.equals("^")) {
            nowpower();
        }
        save(result);
        return result;
    }

    private void save(double result) throws IOException {
        PrintWriter writer = new PrintWriter("calculatorData.txt","UTF-8");
        writer.println(result);
        writer.close();
    }
//effect: loads the saved number

    public double load() throws IOException {
        List<String> numberbefore = Files.readAllLines(Paths.get("calculatorData.txt"));
        String number1 = numberbefore.get(0);
        double number = Double.parseDouble(number1);
        return number;
    }

}
