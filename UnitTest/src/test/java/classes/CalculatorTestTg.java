package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestTg extends CalculatorTest {

    @Test
    public void tg0Test() {
        assertEquals(0.0d, calc.tg(Math.toRadians(0))); }

    @Test
    public void tg30Test() {
        assertEquals(0.577d, calc.tg(Math.toRadians(30))); }

    @Test
    public void tg60Test() {
        assertEquals(1.732d, calc.tg(Math.toRadians(60))); }

    @Test
    public void tg90Test() {
        assertTrue(Double.isInfinite(calc.tg(Math.toRadians(90))));
    }
}
