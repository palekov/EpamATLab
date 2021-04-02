package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestDivDouble extends CalculatorTest {

    @Test
    public void divDoubleNumbers() {
        assertEquals(calc.div(50d, 5d), 10d);
    }

    @Test
    public void divDoubleNull() {
        assertTrue(Double.isInfinite(calc.div(0d, 155d)));
    }
}
