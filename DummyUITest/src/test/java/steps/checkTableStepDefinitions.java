package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static driver.DriverSingleton.driver;
import static org.testng.Assert.*;

public class checkTableStepDefinitions {

    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected final String MAIL_BASE_URL = "http://dummy.restapiexample.com/";
    public static final String HOME_PAGE_TITLE = "Dummy sample rest api - dummy.restapiexample.com";
    public static final By tableLocator = By.className("table");
    public static final By theadLocator = By.xpath("//thead/tr/th");
    public static final By rowsLocator = By.xpath("//tbody/tr");

    public static final String methods = "GET, POST, PUT, DELETE";

    public void waitForElementPresent(By locator) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    @Given("^I am on the Dummy sample rest api web page$")
    public void openDummyMainPage() {
        driver.navigate().to(MAIL_BASE_URL);
        assertEquals(driver.getTitle(), HOME_PAGE_TITLE);
    }

    @When("^the table with request examples is present$")
    public void the_table_with_request_examples_is_present() {
        this.waitForElementPresent(tableLocator);
        assertFalse(driver.findElements(tableLocator).isEmpty());
    }

    @Then("^the table have a specified columns with names$")
    public void the_table_have_a_specified_columns_with_names(List<String> columnNames) {
        List<WebElement> tableColumns = driver.findElements(theadLocator);
        System.out.println("Number of columns found:" + tableColumns.size());
        String columnName = "";
        for (int i = 0; i < tableColumns.size(); i++) {
            columnName = tableColumns.get(i).getText();
            System.out.println("Column title:" + columnName);
            assertEquals(columnName, columnNames.get(i));
        }
    }

    @And("the contents of the columns are correct")
    public void checkColumnsContent() {
        List<WebElement> tableRows = driver.findElements(rowsLocator);
        System.out.println("\nNumber of rows found:" + tableRows.size());
        for (WebElement row: tableRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() < 2) throw new ArithmeticException("Incorrect number of columns!");
            // asserting column with header "Method"
            String methodColumnCell = cells.get(1).getText();
            assertTrue(methods.contains(methodColumnCell));
            // asserting column with header "Type"
            String typeColumnCell = cells.get(2).getText();
            assertEquals(typeColumnCell, "JSON");
        }
    }
}