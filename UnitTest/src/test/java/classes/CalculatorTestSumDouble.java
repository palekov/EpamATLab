package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestSumDouble extends CalculatorTest {

    @Test
    public void sumDoubleTest() {
        assertEquals(10.0d, calc.sum(2.75d, 7.25d));
    }

}

