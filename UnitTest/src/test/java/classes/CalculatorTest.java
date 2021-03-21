package classes;

import com.epam.tat.module4.Calculator;
import org.junit.After;
import org.junit.Before;

public class CalculatorTest {

    public Calculator calc;

    @Before
    public void init() { calc = new Calculator(); }

    @After
    public void tearDown() { calc = null; }

}
