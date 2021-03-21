package classes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestMultLong extends CalculatorTest {

    @Test
    public void multLongTest() {
        assertEquals(200L, calc.mult(100L, 2L));
    }
}
