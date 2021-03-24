package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestCos extends CalculatorTest {

    @Test
    public void cos90Test() {
        assertEquals(0.0d , calc.cos(Math.toRadians(90)));
    }
}
