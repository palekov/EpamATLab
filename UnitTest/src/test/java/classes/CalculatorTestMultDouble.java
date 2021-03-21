package classes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestMultDouble extends CalculatorTest {

    @Test
    public void multDoubleTest() {
        assertEquals(6.30d, calc.mult(3.15d, 2d));
    }
}
