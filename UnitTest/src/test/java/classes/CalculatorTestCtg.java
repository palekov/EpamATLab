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
        assertEquals(1.732d , calc.ctg(Math.toRadians(30)));
    }

    @Test
    public void сtg60Test() {
        assertEquals(0.577d , calc.ctg(Math.toRadians(60)));
    }

    @Test
    public void сtg90Test() {
        assertEquals(0.0d , calc.ctg(Math.toRadians(90)));
    }
}
