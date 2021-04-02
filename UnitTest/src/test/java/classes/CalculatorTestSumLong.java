package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestSumLong extends CalculatorTest {

    @Test
    public void sumLongTest() {
        assertEquals(calc.sum(8L, 2L), 10L);
    }

    }
