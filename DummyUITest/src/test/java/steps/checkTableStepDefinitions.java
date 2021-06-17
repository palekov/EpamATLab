package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class checkTableStepDefinitions {
    protected WebDriver driver;

    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected final String MAIL_BASE_URL = "http://dummy.restapiexample.com/";
    public static final String HOME_PAGE_TITLE = "Dummy sample rest api - dummy.restapiexample.com";
    public static final By tableLocator = By.className("table");
    public static final By columnLocator = By.className("col");

    public void waitForElementPresent(By locator) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    @Given("^I am on the \"([^\"]*)\" web page$")
    public void openDummyMainPage(String pageHeader) {
        driver = DriverSingleton.getDriver();
        driver.navigate().to(MAIL_BASE_URL);
        //System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), HOME_PAGE_TITLE);
    }

    @When("^the table with request examples is present$")
    public void the_table_with_request_examples_is_present() {
        this.waitForElementPresent(tableLocator);
        assertFalse(driver.findElements(tableLocator).isEmpty());
    }

    @Then("^the table have a specified columns with names \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void the_table_have_a_specified_columns_with_names
            (String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) {
        driver.findElements(columnLocator);
    }
}
