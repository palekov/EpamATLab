package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestSin extends CalculatorTest {

    @Test
    public void sin90Test() {
        assertEquals(1.0d , calc.sin(Math.toRadians(90)));
    }
}
