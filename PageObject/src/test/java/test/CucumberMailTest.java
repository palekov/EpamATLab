package test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(strict = true, plugin = {"json:target/cucumber-report.json"},
              features = "src/test/resources/cucumber/yahoo-mail-test.feature",
                glue = "steps")

public class CucumberMailTest extends AbstractTestNGCucumberTests {

}
