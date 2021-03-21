package classes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestSubDouble extends CalculatorTest {

    @Test
    public void subDoubleTest() {
        assertEquals(0d, calc.sub(1d, 1d));
    }
}
