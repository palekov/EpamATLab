package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestSqrt extends CalculatorTest {

    @Test
    public void sqrt16Test() {
        assertEquals(calc.sqrt(16d), 4d);
    }

    @Test
    public void sqrtNullTest() {
        assertEquals(calc.sqrt(0d), 0d);
    }

    @Test
    public void sqrtNegativeTest() {
        assertEquals(calc.sqrt(-16d), Double.NaN);

    }
}
