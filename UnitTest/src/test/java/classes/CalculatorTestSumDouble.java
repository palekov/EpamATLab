package classes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestSumDouble extends CalculatorTest {

    @Test
    public void sumDoubleTest() {
        assertEquals(10.0d, calc.sum(2.75d, 7.25d));
    }

}

