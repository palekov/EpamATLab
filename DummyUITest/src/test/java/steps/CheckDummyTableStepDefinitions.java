package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static driver.DriverSingleton.driver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static steps.Constants.HOME_PAGE_TITLE;
import static steps.Constants.MAIL_BASE_URL;
import static steps.Constants.detailsLink;
import static steps.Constants.routeLocator;
import static steps.Constants.rowsLocator;
import static steps.Constants.tableLocator;
import static steps.Constants.theadLocator;
import static steps.Constants.waitForElementPresent;

public class CheckDummyTableStepDefinitions {
    String routeTextExpected;
    List<WebElement> tableRows;
    List<WebElement> tableColumns;
    private Logger log = LogManager.getRootLogger();

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

    @Then("^the contents of the Method column contains a correct data \"([^\"]*)\"$")
    public void the_contents_of_the_Method_column_contains_a_correct_data(List<String> columnData) {
        checkColumnContent(1, columnData);
    }

    @Then("^the contents of the Type column contains a \"([^\"]*)\" text$")
    public void the_contents_of_the_Type_column_contains_a_correct_data(List<String> columnData) {
        checkColumnContent(2, columnData);
    }

    public void checkColumnContent(int columnNumber, List<String> columnData) {
        tableRows = driver.findElements(rowsLocator);
        for (WebElement row : tableRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String methodColumnCell = cells.get(columnNumber).getText();
            assertTrue(columnData.contains(methodColumnCell));
        }
    }

    @Then("^I can see web page with table, contains specified columns \"([^\"]*)\"$")
    public void i_can_see_web_page_with_specified_columns(List<String> columnNames) {
        tableColumns = driver.findElements(theadLocator);
        String columnName = "";
        for (int i = 0; i < tableColumns.size(); i++) {
            columnName = tableColumns.get(i).getText();
            assertEquals(columnName, columnNames.get(i));
        }
    }

    @When("^I click on Details link in 'Details' column on row with some \"([^\"]*)\"$")
    public void i_click_on_Details_link_in_Details_column(String rowDescription) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");
        // находим все строки в таблице
        tableRows = driver.findElements(rowsLocator);
        WebElement row;
        int rowNumber=0;
        WebElement description = null;
        // итерация по строкам таблицы
        while( rowNumber < tableRows.size()) {
            // получаем список ячеек из строки
            row = tableRows.get(rowNumber);
            List<WebElement> cells = row.findElements(By.tagName("td"));
            // получаем текст из ячейки Route для последующего сравнения
            routeTextExpected = cells.get(0).getText();
            // получаем текст из столбца Description
            description = cells.get(4);
            // если нашли строку с нужным Description - выходим из цикла
            if (description.getText().equals(rowDescription))
                break;
            rowNumber++;
        }
        log.info(description.getText());
        // находим все элементы - ссылки
        waitForElementPresent(detailsLink);
        List<WebElement> links = driver.findElements(detailsLink);
        // кликаем на ссылку с определенным номером строки
        links.get(rowNumber).click();
    }

    @Then("^the text in Route column equals to Route column text in main table$")
    public void the_text_in_Route_column_equals_to_Route_column_text_in_main_table() {
        WebElement routeCell = driver.findElement(routeLocator);
        String routeCellText = routeCell.getText();
        assertEquals(routeCellText, routeTextExpected);
    }

}
