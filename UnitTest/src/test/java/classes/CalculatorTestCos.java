package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestCos extends CalculatorTest {

    @Test
    public void cos0Test() {
        assertEquals(calc.cos(Math.toRadians(0)), 1.0d);
    }

    @Test
    public void cos30Test() {
        assertEquals(calc.cos(Math.toRadians(30)), 0.866d);
    }

    @Test
    public void cos60Test() {
        assertEquals(calc.cos(Math.toRadians(60)), 0.5d);
    }

    @Test
    public void cos90Test() {
        assertEquals(calc.cos(Math.toRadians(90)), 0.0d);
    }
}
