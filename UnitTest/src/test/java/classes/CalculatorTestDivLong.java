package classes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestDivLong extends CalculatorTest {

    @Test
    public void divLongTest() {  assertEquals(10L, calc.div(50L, 5L));   }
}
