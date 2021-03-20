import com.epam.tat.module4.Calculator;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;

import static java.lang.Math.round;
import static junit.framework.TestCase.assertEquals;

public class CalculatorTrigonometryTest {
    private Calculator calc;

    public void checkTime() {
        Date date = new Date();
        System.out.println("Current time: " + date);
    }

    @BeforeClass
    public void init() { calc = new Calculator(); }

    @AfterClass
    public void tearDown() { calc = null; }

    @Test
    public void sin0Test() {
        checkTime();
        assertEquals(0.0d, calc.sin(Math.toRadians(0)));
    }

    @Test
    public void sin30Test() {
        checkTime();
        double result = calc.sin(Math.toRadians(30));
        assertEquals(0.5d, result);
    }

    @Test
    public void sin90Test() {
        checkTime();
        assertEquals(1.0d , calc.sin(Math.toRadians(90)));
    }

    @Test
    public void cos0Test() {
        checkTime();
        assertEquals(1.0d, calc.cos(Math.toRadians(0)));
    }

    @Test
    public void cos30Test() {
        checkTime();
        assertEquals(0.866d, calc.cos(Math.toRadians(30)));
    }

    @Test
    public void cos90Test() {
        checkTime();
        assertEquals(0.0d , calc.cos(Math.toRadians(90)));
    }
}
