package observerTest;

import observer.AbstractObserver;
import observer.FunctionString;
import observer.Result;
import observer.Results;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObserverTest {
    private Results rs;

    @BeforeEach
    void beforeeach() {
        rs = new Results();
    }

    @Test
    void testResults() {
        assertEquals(0, rs.size());
        AbstractObserver r = new Result(1);
        rs.add(r);
        assertEquals(1, rs.size());
        r = new FunctionString("x+2");
        rs.add(r);
        assertEquals(2, rs.size());
    }
}
