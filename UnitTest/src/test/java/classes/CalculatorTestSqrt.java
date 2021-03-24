package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestSqrt extends CalculatorTest {

    @Test
    public void sqrt16Test() {
        assertEquals(4d, calc.sqrt(16d));
    }

    @Test
    public void sqrtNullTest() {
        assertEquals(0d, calc.sqrt(0d));
    }

    @Test
    public void sqrtNegativeTest() {
        assertEquals(Double.NaN, calc.sqrt(-16d));

    }
}
