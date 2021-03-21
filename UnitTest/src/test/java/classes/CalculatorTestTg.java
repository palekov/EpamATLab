package classes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestTg extends CalculatorTest {

    @Test
    public void tg30Test() {
        assertEquals(0.577d, calc.tg(Math.toRadians(30)));
    }
}
