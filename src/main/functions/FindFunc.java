package functions;

import exceptions.CannotDivideByZero;
import exceptions.ForgotToWrite;
import exceptions.ForgotToWriteOperation;
import exceptions.ForgotToWriteNum;

import java.io.IOException;

public interface FindFunc {

    void findtheoperation() throws  IOException, CannotDivideByZero, ForgotToWrite;

    void find() throws IOException, ForgotToWriteNum, CannotDivideByZero, ForgotToWriteOperation;

    double functionequals() throws IOException, CannotDivideByZero, ForgotToWrite;

}
