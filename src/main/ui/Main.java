package ui;


import exceptions.*;
import functions.*;
import network.NetworkFile;
import observer.AbstractObserver;
import observer.FunctionString;
import observer.Result;
import observer.Results;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    private static Results results;

    public static void main(String[] args) {
        System.out.println("Welcome to Calculator!");
        Scanner reader = new Scanner(System.in);
        results = new Results();
        while (true) {
            String opera = reader.nextLine();
            if (opera.equals("off")) {
                break;
            } else {
                funcnow(opera);
            }
        }
        printresults();
    }


    private static void funcnow(String opera) {
        if (opera.contains("x")) {
            resultadd(network(opera));
        } else {
            try {
                ComplexSimpleFunc func1 = new ComplexSimpleFunc(opera);
                resultadd(new Result(func1.functionequals()));
            } catch (ResultCannotBeAboveMillion e) {
                System.out.println("TOO LARGE TO COMPUTE");
            } catch (CannotDivideByZero | IOException e) {
                System.out.println("UNDEFINED");
            } catch (ForgotToWrite e) {
                System.out.println("Don't forget to write your number or operation");
            } catch (NullPointerException e) {
                System.out.println("Cannot Compute");
            } finally {
                System.out.println("Continue or press off");
            }
        }
    }

    private static void resultadd(AbstractObserver result) {
        result.print();
        results.add(result);
    }


    private static void printresults() {
        if (results.size() == 0) {
            System.out.println("no results");
        } else if (results.size() == 1) {
            System.out.print("Your results are: ");
            results.notifyall();
        } else {
            System.out.print("Your results are: ");
            results.notifyall();
        }
        System.out.println("");
        System.out.println("Have a great day!");
    }

    private static AbstractObserver network(String o) {
        NetworkFile n = new NetworkFile(o);
        n.derivateProb();
        return new FunctionString(n.getAnswer());
    }

}
