package classes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestSin extends CalculatorTest {

    @Test
    public void sin90Test() {
        assertEquals(1.0d , calc.sin(Math.toRadians(90)));
    }
}
