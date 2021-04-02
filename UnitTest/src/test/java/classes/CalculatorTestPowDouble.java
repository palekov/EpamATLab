package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestPowDouble extends CalculatorTest {

    @Test
    public void powDoubleTest() {
        assertEquals(calc.pow(5d, 3d), 125d);
    }
}
