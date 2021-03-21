package classes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestSqrt extends CalculatorTest {

    @Test
    public void sqrt16Test() {
        assertEquals(4d, calc.sqrt(16d));
    }
}
