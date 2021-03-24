package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestPowDouble extends CalculatorTest {

    @Test
    public void powDoubleTest() {
        assertEquals(125d, calc.pow(5d, 3d));
    }
}
