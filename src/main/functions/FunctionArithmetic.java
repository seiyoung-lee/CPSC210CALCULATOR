package functions;

import exceptions.CannotDivideByZero;

public interface FunctionArithmetic {
    double nowsub();

    double nowsum();

    double nowmultiply();

    double nowdivide() throws CannotDivideByZero;

    double nowpower();
}
