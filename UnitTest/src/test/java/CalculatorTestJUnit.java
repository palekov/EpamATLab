import com.epam.tat.module4.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CalculatorTestJUnit {
    private Calculator calc;

    @Before
    public void init() { calc = new Calculator(); }

    @After
    public void tearDown() { calc = null; }

    @Test
    public void sumLongTest() {
        assertEquals(5L, calc.sum(3L, 2L));
    }

    @Test
    public void sumDoubleTest() {
        assertEquals(5d, calc.sum(3d, 2d));
    }

    @Test
    public void subLongTest() {
        assertEquals(0L, calc.sub(1L, 1L));
    }

    @Test
    public void subDoubleTest() {
        assertEquals(0d, calc.sub(1d, 1d));
    }

    @Test
    public void multLongTest() {
        assertEquals(200L, calc.mult(100L, 2L));
    }

    @Test
    public void multDoubleTest() {
        assertEquals(6.30d, calc.mult(3.15d, 2d));
    }

    @Test
    public void divLongTest() {  assertEquals(10L, calc.div(50L, 5L));   }

    @Test
    public void divDoubleTest() {
        assertEquals(10d, calc.div(50d, 5d));
    }

    @Test
    public void powDoubleTest() {
        assertEquals(125d, calc.pow(5d, 3d));
    }

    @Test
    public void sqrt16Test() {
        assertEquals(4d, calc.sqrt(16d));
    }

    @Test
    public void sqrt_16Test() {
        assertEquals(4d, calc.sqrt(-16d));
    }


    @Test
    public void tg0Test() {
        assertEquals(0.0d, calc.tg(Math.toRadians(0)));
    }

    @Test
    public void tg30Test() {
        assertEquals(0.577d, calc.tg(Math.toRadians(30)));
    }

    @Test
    public void tg90Test() {
        assertEquals(Double.POSITIVE_INFINITY , calc.tg(Math.toRadians(90)));
    }

    @Test
    public void сtg0Test() {
        assertEquals(Double.POSITIVE_INFINITY, calc.ctg(Math.toRadians(0)));
    }
    //  wow! its using non-ascii character 'c' in method signature and hyperbolic tangent 'tanh'!!!

    @Test
    public void сtg30Test() {
        assertEquals(1.732d, calc.ctg(Math.toRadians(30)));
    }

    @Test
    public void сtg90Test() {
        assertEquals(0.0d , calc.ctg(Math.toRadians(90)));
    }

    @Test
    public void sin0Test() {
        assertEquals(0.0d, calc.sin(Math.toRadians(0)));
    }

    @Test
    public void sin30Test() {
        assertEquals(0.5d, calc.sin(Math.toRadians(30)));
    }

    @Test
    public void sin90Test() {
        assertEquals(1.0d , calc.sin(Math.toRadians(90)));
    }

    @Test
    public void cos0Test() {
        assertEquals(1.0d, calc.cos(Math.toRadians(0)));
    }

    @Test
    public void cos30Test() {
        assertEquals(0.866d, calc.cos(Math.toRadians(30)));
    }

    @Test
    public void cos90Test() {
        assertEquals(0.0d , calc.cos(Math.toRadians(90)));
    }

    @Test
    public void testIsPositive() {
        assertTrue(calc.isPositive(7L));
    }

    @Test
    public void testIsNegative() {
        assertTrue(calc.isNegative(-17L));
    }

}
