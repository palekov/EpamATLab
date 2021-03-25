package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestDivDouble extends CalculatorTest {

    @Test
    public void divDoubleNumbers() {
        assertEquals(10d, calc.div(50d, 5d));
    }

    @Test
    public void divDoubleNull() {
        assertTrue(Double.isInfinite(calc.div(155d, 0d)));
    }
}
