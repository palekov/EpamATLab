package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestDivLong extends CalculatorTest {

    @Test
    public void divLongNumbers() {  assertEquals(10_000_000L, calc.div(50_000_000L, 5L));   }

    @Test(expectedExceptions = NumberFormatException.class)
    public void divLongNull() {
        long res = calc.div(1_000_000L, 0L);
    }
}
