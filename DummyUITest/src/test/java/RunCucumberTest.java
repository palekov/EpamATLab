
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import driver.DriverSingleton;
import static driver.DriverSingleton.driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(tags = "@checkDummyTable", strict = true, plugin = {"json:target/cucumber-report.json"},
        features = "src/test/features", glue = "steps")

public class RunCucumberTest extends AbstractTestNGCucumberTests {
    @BeforeClass()
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass()
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}