
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(tags = "@checkTable", strict = true, plugin = {"json:target/cucumber-report.json"},
        features = "src/test/features", glue = "steps")

public class RunCucumberTest extends AbstractTestNGCucumberTests {

}