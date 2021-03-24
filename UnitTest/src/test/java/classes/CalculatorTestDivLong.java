package classes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestDivLong extends CalculatorTest {

    @Test
    public void divLongTest() {  assertEquals(10L, calc.div(50L, 5L));   }
}
