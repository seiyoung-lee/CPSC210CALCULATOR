package ui;

import exceptions.*;
import functions.ComplexSimpleFunc;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ComplexSimpleFuncTest {
    private ComplexSimpleFunc compsimp;

    @Test
    void testFunctionEqualsallsame() throws IOException {
        try {
            compsimp = new ComplexSimpleFunc("3+16+15");
            assertEquals(34, compsimp.functionequals());
        } catch (ForgotToWrite  e) {
            fail();
        } catch (CannotDivideByZero e) {}
    }

    @Test
    void testFunctionEqualdifferentsame() {
        try {
            compsimp = new ComplexSimpleFunc("3+16-15");
            assertEquals(4, compsimp.functionequals());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void testFunctionEqualdifferentsame1() {
        try {
            compsimp = new ComplexSimpleFunc("3*16-15");
            assertEquals(33, compsimp.functionequals());
        } catch (Exception e) {
        fail();
        }
    }

    @Test
    void testFunctionEqualexponent() {
        try {
            compsimp = new ComplexSimpleFunc("3*4^2-15");
            assertEquals(33, compsimp.functionequals());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void testFunctionEqualdifferentsame2() {
        try {
            compsimp = new ComplexSimpleFunc("3*16/3");
        assertEquals(16, compsimp.functionequals());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void testFunctionEqualdifferentsame3() {
        try{
            compsimp = new ComplexSimpleFunc("3-16");
            assertEquals(-13, compsimp.functionequals());
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    void testFunctionEqualsmorethan3() {
        try {
            compsimp = new ComplexSimpleFunc("3-16+16+3");
            assertEquals(6, compsimp.functionequals());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void testFunctionEqualsmorethan4()  {
       try {
           compsimp = new ComplexSimpleFunc("3-16+16+3+6+5");
            assertEquals(17, compsimp.functionequals());
       } catch (Exception e) {
           fail();
       }
    }

    @Test
    public void testexceptions() throws IOException {
        try {
            compsimp = new ComplexSimpleFunc("4/0");
            compsimp.functionequals();
            fail();
        } catch (CannotDivideByZero e) {
            System.out.println("Caught good exception");
        } catch (ResultCannotBeAboveMillion e) {
            fail("Caught wrong exception");
        } catch (ForgotToWrite forgotToWriteOperation) {
            forgotToWriteOperation.printStackTrace();
        }
    }

    @Test
    public void testexceptionsmillion() throws IOException {
        try {
            compsimp = new ComplexSimpleFunc("10000000+1");
            compsimp.functionequals();
            fail();
        } catch (CannotDivideByZero e) {
            fail("Caught wrong exception");
        } catch (ResultCannotBeAboveMillion e) {
            System.out.println("Caught good exception");
        } catch (ForgotToWrite e) {
            fail();
        }
    }

    @Test
    public void testexceptionsload() throws IOException {
        try {
            compsimp = new ComplexSimpleFunc("1000+l");
            compsimp.functionequals();
        } catch (CannotDivideByZero e) {
            fail("Caught wrong exception");
        } catch (ResultCannotBeAboveMillion | ForgotToWrite e) {
            fail();
        }
    }

    @Test
    public void testexceptionNUM() throws IOException {
        try {
            compsimp = new ComplexSimpleFunc("asdfas+bk");
            compsimp.functionequals();
            fail();
        } catch (ForgotToWriteNum e) {
            System.out.println("GOOD CATCH");
        } catch (Exception e) {
            fail("yo");
        }
    }

    @Test
    public void testexceptionOpe() throws IOException {
        try {
            compsimp = new ComplexSimpleFunc("awesd");
            compsimp.functionequals();
        } catch (ForgotToWriteNum e) {
            System.out.println("GOOD CATCH");
        } catch (Exception e) {
            fail();
        }
    }
}
