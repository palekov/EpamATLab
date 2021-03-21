package classes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestCtg extends CalculatorTest {

    @Test
    public void сtg90Test() {
        assertEquals(0.0d , calc.ctg(Math.toRadians(90)));
    }
}
