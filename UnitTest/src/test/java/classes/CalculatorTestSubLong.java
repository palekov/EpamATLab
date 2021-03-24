package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestSubLong extends CalculatorTest {

    @Test
    public void subLongTest() {
        assertEquals(0L, calc.sub(1L, 1L));
    }
}
