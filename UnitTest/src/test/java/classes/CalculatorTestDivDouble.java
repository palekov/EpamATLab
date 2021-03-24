package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestDivDouble extends CalculatorTest {

    @Test
    public void divDoubleTest() {
        assertEquals(10d, calc.div(50d, 5d));
    }
}
