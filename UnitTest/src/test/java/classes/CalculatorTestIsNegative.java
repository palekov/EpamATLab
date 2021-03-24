package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CalculatorTestIsNegative extends CalculatorTest {

    @Test
    public void testMinusOne() {
        assertTrue(calc.isNegative(-1L));
    }

    @Test
    public void testZero() {
        assertFalse(calc.isNegative(0));
    }

    @Test
    public void testPlusOne() {
        assertFalse(calc.isNegative(1L));
    }

}
