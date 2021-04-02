package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestTg extends CalculatorTest {

    @Test
    public void tg0Test() {
        assertEquals(calc.tg(Math.toRadians(0)), 0.0d); }

    @Test
    public void tg30Test() {
        assertEquals(calc.tg(Math.toRadians(30)), 0.577d); }

    @Test
    public void tg60Test() {
        assertEquals(calc.tg(Math.toRadians(60)), 1.732d); }

    @Test
    public void tg90Test() {
        assertTrue(Double.isInfinite(calc.tg(Math.toRadians(90))));
    }
}
