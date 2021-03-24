package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestSumLong extends CalculatorTest {

    @Test
    public void sumLongTest() {
        assertEquals(10L, calc.sum(8L, 2L));
    }

    }
