package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static driver.DriverSingleton.driver;
import static org.testng.Assert.assertEquals;
import static steps.Constants.*;

public class CheckGetAllTableStepDefinitions {
    String routeTextExpected;

    @Given("^I am on the main Dummy sample rest api web page$")
    public void i_am_on_the_main_Dummy_sample_rest_api_web_page() throws Throwable {
        driver.manage().window().maximize();
        driver.navigate().to(MAIL_BASE_URL);
        assertEquals(driver.getTitle(), HOME_PAGE_TITLE);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");
        List<WebElement> tableRows = driver.findElements(rowsLocator);
        System.out.println("\nNumber of rows found:" + tableRows.size());
        WebElement cell = tableRows.get(0).findElement(By.tagName("td"));
        routeTextExpected = cell.getText();
    }

    @When("^I click on Details link in 'Details' column on 'Get all employee data' row$")
    public void i_click_on_Details_link_in_Details_column_on_Get_all_employee_data_row() {
        waitForElementPresent(getAllDetailsLink);
        driver.findElement(getAllDetailsLink).click();
    }

    @Then("^the text in Route column equals to Route column text in main table$")
    public void the_text_in_Route_column_equals_to_Route_column_text_in_main_table() {
        WebElement routeCell = driver.findElement(routeLocator);
        String routeCellText = routeCell.getText();
        assertEquals(routeCellText, routeTextExpected);
    }
}
