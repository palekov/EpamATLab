package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(strict = true, plugin = {"json:target/cucumber-report.json"},
              features = "src/test/resources/cucumber/yahoo-mail-test.feature",
                glue = "src/test/java/steps")

public class CucumberMailTest extends AbstractTestNGCucumberTests {

}
