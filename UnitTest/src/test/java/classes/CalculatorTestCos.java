package classes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestCos extends CalculatorTest {

    @Test
    public void cos90Test() {
        assertEquals(0.0d , calc.cos(Math.toRadians(90)));
    }
}
