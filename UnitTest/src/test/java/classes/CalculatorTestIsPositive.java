package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CalculatorTestIsPositive extends CalculatorTest {

    @Test
    public void testMinusOne() {
        assertFalse(calc.isPositive(-1L));
    }

    @Test
    public void testZero() {
        assertFalse(calc.isPositive(0));
    }

    @Test
    public void testPlusOne() {
        assertTrue(calc.isPositive(1L));
    }
}
