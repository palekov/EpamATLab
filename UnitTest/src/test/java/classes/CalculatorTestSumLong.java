package classes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestSumLong extends CalculatorTest {

    @Test
    public void sumLongTest() {
        assertEquals(10L, calc.sum(8L, 2L));
    }

    }
