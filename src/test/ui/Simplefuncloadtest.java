package ui;

import functions.Simplefuncload;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Simplefuncloadtest {
    private Simplefuncload ld;


    @Test
    void testsimplefunload() {
        try {
            ld = new Simplefuncload();
            ld.setsecondnum(30);
            ld.setTheoperation("+");
            assertEquals(ld.load()+30, ld.functionequals());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void testsimplefuncmulti() {
        try {
            ld = new Simplefuncload();
            ld.setsecondnum(30);
            ld.setTheoperation("*");
            assertEquals(ld.load()*30, ld.functionequals());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void testsimplefuncdivi() {
        try {
            ld = new Simplefuncload();
            ld.setsecondnum(30);
            ld.setTheoperation("/");
            assertEquals(ld.load()/30, ld.functionequals());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void testsimplefuncsub() {
        try {
            ld = new Simplefuncload();
            ld.setsecondnum(30);
            ld.setTheoperation("-");
            assertEquals(ld.load()-30, ld.functionequals());
        } catch (Exception e) {
            fail();
        }
    }


}
