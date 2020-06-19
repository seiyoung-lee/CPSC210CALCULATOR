package ui;

import exceptions.CannotDivideByZero;
import exceptions.ForgotToWrite;
import functions.ComplexFunc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ComplexFuncTest {
    private ComplexFunc cf;
    @BeforeEach
    void beforeeach() throws IOException, CannotDivideByZero, ForgotToWrite {
             cf = new ComplexFunc("3+4+(4+3*2)*2^3+4^(1/2)");
    }

    @Test
    void testparanthesisnumber() {
        assertEquals(2,cf.sizeparanthesis1());
        assertEquals(2, cf.sizeparanthesis2());
    }

    @Test
    void testparenthesis() {
        assertEquals("3+4+10.0*2^3+4^0.5", cf.getParanthesis());
    }

    @Test
    void testFunctionEquals() {
        try {
            assertEquals(89, cf.functionequals());
        } catch (Exception e) {
            fail();
        }
    }
}
