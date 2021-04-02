package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestCtg extends CalculatorTest {

    @Test
    public void сtg0Test() {
        assertTrue(Double.isInfinite(calc.ctg(Math.toRadians(0))));
    }

    @Test
    public void сtg30Test() {
        assertEquals(calc.ctg(Math.toRadians(30)), 1.732d);
    }

    @Test
    public void сtg60Test() {
        assertEquals(calc.ctg(Math.toRadians(60)), 0.577d);
    }

    @Test
    public void сtg90Test() {
        assertEquals(calc.ctg(Math.toRadians(90)), 0.0d);
    }
}
