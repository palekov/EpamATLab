package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestCos extends CalculatorTest {

    @Test
    public void cos0Test() {
        assertEquals(1.0d , calc.cos(Math.toRadians(0)));
    }

    @Test
    public void cos30Test() {
        assertEquals(0.866d , calc.cos(Math.toRadians(30)));
    }

    @Test
    public void cos60Test() {
        assertEquals(0.5d , calc.cos(Math.toRadians(60)));
    }

    @Test
    public void cos90Test() {
        assertEquals(0.0d , calc.cos(Math.toRadians(90)));
    }
}
