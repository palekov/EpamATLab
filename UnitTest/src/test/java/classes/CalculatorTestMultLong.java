package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestMultLong extends CalculatorTest {

    @Test
    public void multLongTest() {
        assertEquals(calc.mult(100L, 2L), 200L);
    }
}
