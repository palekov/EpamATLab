package classes;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class CalculatorTestIsPositive extends CalculatorTest {

    @Test
    public void testIsPositive() {
        assertTrue(calc.isPositive(1L));
    }
}
