package classes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestDivDouble extends CalculatorTest {

    @Test
    public void divDoubleTest() {
        assertEquals(10d, calc.div(50d, 5d));
    }
}
