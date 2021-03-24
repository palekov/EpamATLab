package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestTg extends CalculatorTest {

    @Test
    public void tg30Test() {
        assertEquals(0.577d, calc.tg(Math.toRadians(30)));
    }
}
