package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestSin extends CalculatorTest {

    @Test
    public void sin0Test() {
        assertEquals(1.0d , calc.sin(Math.toRadians(0)));
    }

    @Test
    public void sin30Test() {
        assertEquals(0.5d , calc.sin(Math.toRadians(30)));
    }

    @Test
    public void sin60Test() {
        assertEquals(0.866d , calc.sin(Math.toRadians(60)));
    }

    @Test
    public void sin90Test() {
        assertEquals(1.0d , calc.sin(Math.toRadians(90)));
    }
}
