package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestSin extends CalculatorTest {

    @Test
    public void sin0Test() {
        assertEquals(calc.sin(Math.toRadians(0)), 1.0d);
    }

    @Test
    public void sin30Test() {
        assertEquals(calc.sin(Math.toRadians(30)), 0.5d);
    }

    @Test
    public void sin60Test() {
        assertEquals(calc.sin(Math.toRadians(60)), 0.866d);
    }

    @Test
    public void sin90Test() {
        assertEquals(calc.sin(Math.toRadians(90)), 1.0d);
    }
}
