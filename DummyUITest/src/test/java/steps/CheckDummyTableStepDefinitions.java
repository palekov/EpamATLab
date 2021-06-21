package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static driver.DriverSingleton.driver;
import static org.testng.Assert.*;
import static steps.Constants.*;

public class CheckDummyTableStepDefinitions {

    @Given("^I am on the Dummy sample rest api web page$")
    public void openDummyMainPage() {
        driver.manage().window().maximize();
        driver.navigate().to(MAIL_BASE_URL);
        assertEquals(driver.getTitle(), HOME_PAGE_TITLE);
    }

    @When("^the table with request examples is present$")
    public void the_table_with_request_examples_is_present() {
        waitForElementPresent(tableLocator);
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

    @Then("^the contents of the Method column contains a correct data$")
    public void the_contents_of_the_Method_column_contains_a_correct_data(List<String> methodData) throws Throwable {
        List<WebElement> tableRows = driver.findElements(rowsLocator);
        for (WebElement row : tableRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() < 2) throw new ArithmeticException("Incorrect number of columns!");
            // asserting column with header "Method"
            String methodColumnCell = cells.get(1).getText();
            assertTrue(methodData.contains(methodColumnCell));
        }
    }

    @Then("^the contents of the Type column contains a correct data$")
    public void the_contents_of_the_Type_column_contains_a_correct_data(List<String> typeData) throws Throwable {
        List<WebElement> tableRows = driver.findElements(rowsLocator);
        for (WebElement row : tableRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() < 2) throw new ArithmeticException("Incorrect number of columns!");
            // asserting column with header "Method"
            String methodColumnCell = cells.get(2).getText();
            assertTrue(typeData.contains(methodColumnCell));
        }
    }

    @Then("^I can see web page with table, contains specified columns$")
    public void i_can_see_web_page_with_specified_columns(List<String> columnNames) {
        List<WebElement> tableColumns = driver.findElements(theadLocator);
        System.out.println("Number of columns found:" + tableColumns.size());
        String columnName = "";
        for (int i = 0; i < tableColumns.size(); i++) {
            columnName = tableColumns.get(i).getText();
            assertEquals(columnName, columnNames.get(i));
        }
    }
}
