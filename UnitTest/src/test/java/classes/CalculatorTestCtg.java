package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestCtg extends CalculatorTest {

    @Test
    public void сtg90Test() {
        assertEquals(0.0d , calc.ctg(Math.toRadians(90)));
    }
}
