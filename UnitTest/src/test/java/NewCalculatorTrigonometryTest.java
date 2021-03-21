import com.epam.tat.module4.Calculator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class NewCalculatorTrigonometryTest {

    private NewCalculator calc = new NewCalculator();

    @Test
    public void sin0Test() {
        assertEquals(0.0d, calc.sin(Math.toRadians(0)));
    }

    @Test
    public void sin30Test() {
        assertEquals(0.5d, calc.sin(Math.toRadians(30)));
    }

    @Test
    public void sin60Test() {
        assertEquals(0.8660254038d, calc.sin(Math.toRadians(60)));
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
        assertEquals(0.8660254038d, calc.cos(Math.toRadians(30)));
    }

    @Test
    public void cos60Test() {
        assertEquals(0.5d, calc.cos(Math.toRadians(60)));
    }

    @Test
    public void cos90Test() { assertEquals(0.0d , calc.cos(Math.toRadians(90)));
    }

    @Test
    public void tg0Test() {
        assertEquals(0.0d, calc.tg(Math.toRadians(0)));
    }

    @Test
    public void tg30Test() {
        assertEquals(0.5773502692d, calc.tg(Math.toRadians(30)));
    }

    @Test
    public void tg60Test() {
        assertEquals(1.7320508076d, calc.tg(Math.toRadians(60)));
    }

    @Test
    public void tg90Test() {
        assertEquals(Double.POSITIVE_INFINITY , calc.tg(Math.toRadians(90)));
    }

    @Test
    public void сtg0Test() {
        assertEquals(Double.POSITIVE_INFINITY, calc.ctg(Math.toRadians(0)));
    }

    @Test
    public void сtg30Test() {
        assertEquals(1.7320508076d, calc.ctg(Math.toRadians(30)));
    }

    @Test
    public void сtg60Test() {
        assertEquals(0.5773502692d, calc.ctg(Math.toRadians(60)));
    }

    @Test
    public void сtg90Test() {
        assertEquals(0.0d , calc.ctg(Math.toRadians(90)));
    }

}