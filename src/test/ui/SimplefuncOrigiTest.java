package ui;

import exceptions.CannotDivideByZero;
import exceptions.ResultCannotBeAboveMillion;
import functions.Simplefunc;
import functions.SimplefuncOrigi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class SimplefuncOrigiTest {
    private SimplefuncOrigi s;

    @BeforeEach
    void beforeeach() throws IOException {
        s = new SimplefuncOrigi();
        s.setfirstnum(3);
        s.setsecondnum(4);
    }

    @Test
    public void testsum() {
        assertEquals(7 ,s.nowsum());
    }

    @Test
    public void testmultiplication() throws IOException {
       assertEquals(12, s.nowmultiply());
    }

    @Test
    public void testdivide() throws IOException, CannotDivideByZero {
        assertEquals(0.75, s.nowdivide());
    }

    @Test
    public void testdecimals() throws IOException, CannotDivideByZero {
        assertEquals(2.5, s.nowdivide());
    }

    @Test
    public void testsub() throws IOException {
        assertEquals(-1, s.nowsub());
    }

    @Test
    public void testoperations() throws IOException {
        try {
            s = new SimplefuncOrigi();
            s.setfirstnum(5);
            s.setsecondnum(10);
            s.setTheoperation("+");
            assertEquals(15, s.functionequals());
            s.setTheoperation("*");
            assertEquals(50, s.functionequals());
            s.setTheoperation("/");
            assertEquals(0.5, s.functionequals());
            s.setTheoperation("-");
            assertEquals(-5,s.functionequals());
        } catch (CannotDivideByZero e) {
            fail();
        }
    }

    @Test
    public void testgetters() {
        s.setTheoperation("+");
        assertEquals(3,s.getFirstnum());
        assertEquals(4,s.getSecondnumnum());
        assertEquals("+",s.getTheoperation());
    }

    @Test
    public void testexceptions() throws IOException {
        s.setsecondnum(0);
        s.setTheoperation("/");
        try {
            s.functionequals();
            fail();
        } catch (CannotDivideByZero e) {
            System.out.println("Caught good exception");
        } catch (ResultCannotBeAboveMillion e) {
            fail("Caught wrong excpection");
        }
    }

    @Test
    public void testexceptionsmillion() throws IOException {
        s.setfirstnum(1000000000);
        s.setTheoperation("+");
        try {
            s.functionequals();
            fail();
        } catch (CannotDivideByZero e) {
            fail("Caught wrong excpection");
        } catch (ResultCannotBeAboveMillion e) {
            System.out.println("Caught good exception");
        }
    }

}