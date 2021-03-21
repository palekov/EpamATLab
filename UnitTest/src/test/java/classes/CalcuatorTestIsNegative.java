package classes;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class CalcuatorTestIsNegative extends CalculatorTest {

    @Test
    public void testIsNegative() {
        assertTrue(calc.isNegative(-45L));
    }
}
