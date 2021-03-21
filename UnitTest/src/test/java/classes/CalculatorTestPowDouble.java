package classes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestPowDouble extends CalculatorTest {

    @Test
    public void powDoubleTest() {
        assertEquals(125d, calc.pow(5d, 3d));
    }
}
