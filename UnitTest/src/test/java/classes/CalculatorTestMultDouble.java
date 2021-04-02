package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestMultDouble extends CalculatorTest {

    @Test
    public void multDoubleTest() {
        assertEquals(calc.mult(3.15d, 2d), 6.30d);
    }
}
