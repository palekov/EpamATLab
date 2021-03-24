package classes;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CalculatorTest {

    public Calculator calc;

//    double d = Math.sqrt(-4);

    @BeforeClass
    public void init() { calc = new Calculator(); }

    @AfterClass
    public void tearDown() { calc = null; }

//    public static void main(String[] args) {
//        CalculatorTest test = new CalculatorTest();
//        System.out.println(test.d);
//    }

}
