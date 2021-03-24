package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestSubDouble extends CalculatorTest {

    @Test
    public void subDoubleTest() {
        assertEquals(0d, calc.sub(1d, 1d));
    }
}
