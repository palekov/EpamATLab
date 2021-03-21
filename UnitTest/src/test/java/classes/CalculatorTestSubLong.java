package classes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestSubLong extends CalculatorTest {

    @Test
    public void subLongTest() {
        assertEquals(0L, calc.sub(1L, 1L));
    }
}
