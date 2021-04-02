import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertEquals;

public class CalculatorTestNgDDT {
    private Calculator calc;

    @BeforeClass
    public void init() { calc = new Calculator(); }

    @AfterClass
    public void tearDown() { calc = null; }

    @Test(dataProvider = "sumDataProvider")
    @Parameters({"a", "b", "expected"})
    public void sumLongTest(long a, long b, long expected) {
        assertEquals(expected, calc.sum(a, b));
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void divByZeroTest() {
        long result = calc.div(1, 0);
    }

    @DataProvider(name = "sumDataProvider")
    public Object[][] sumDataProvider() {
        return new Object[][] {
                {1, 1, 2},
                {0, 0, 0},
                {2_400_000, 2_600_000, 5_000_000}
        };
    }
}
