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
import static org.testng.Assert.assertTrue;
import static steps.Constants.*;

public class CheckDetailsTableStepDefinitions {
    String routeTextExpected;
    List<String> mainTableRow;

    @Given("^I am on the main Dummy sample rest api web page$")
    public void i_am_on_the_main_Dummy_sample_rest_api_web_page() throws Throwable {
        driver.manage().window().maximize();
        driver.navigate().to(MAIL_BASE_URL);
        assertEquals(driver.getTitle(), HOME_PAGE_TITLE);
    }

    @When("^I click on Details link in 'Details' column on row with some \"([^\"]*)\"$")
    public void i_click_on_Details_link_in_Details_column(String rowDescription) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");
        // находим все строки в таблице
        List<WebElement> tableRows = driver.findElements(rowsLocator);
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
        //System.out.println("Found row number = " + rowNumber + " Descr = " + description.getText());
        System.out.println(description.getText());
        // находим все элементы - ссылки
        waitForElementPresent(detailsLink);
        List<WebElement> links = driver.findElements(detailsLink);
        // кликаем на ссылку с определенным номером строки
        links.get(rowNumber).click();
    }

    @Then("^I can see web page with table which contains specified columns$")
    public void i_can_see_web_page_with_specified_columns(List<String> columnNames) {
        List<WebElement> tableColumns = driver.findElements(theadLocator);
        //System.out.println("Number of columns found:" + tableColumns.size());
        String columnName = "";
        for (int i = 0; i < tableColumns.size(); i++) {
            columnName = tableColumns.get(i).getText();
            assertEquals(columnName, columnNames.get(i));
        }
    }

    @Then("^the text in Route column equals to Route column text in main table$")
    public void the_text_in_Route_column_equals_to_Route_column_text_in_main_table() {
        WebElement routeCell = driver.findElement(routeLocator);
        String routeCellText = routeCell.getText();
        assertEquals(routeCellText, routeTextExpected);
    }
}
