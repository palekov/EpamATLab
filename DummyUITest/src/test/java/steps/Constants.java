package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.DriverSingleton.driver;

public class Constants {
    public static final int WAIT_TIMEOUT_SECONDS = 10;
    public static final String MAIL_BASE_URL = "http://dummy.restapiexample.com/";
    public static final String HOME_PAGE_TITLE = "Dummy sample rest api - dummy.restapiexample.com";
    public static final By tableLocator = By.className("table");
    public static final By theadLocator = By.xpath("//thead/tr/th");
    public static final By rowsLocator = By.xpath("//tbody/tr");
    public static final By detailsLink = By.cssSelector("a.red-link");
    public static final By routeLocator = By.xpath("//tbody/tr/td[1]");
    public static final By methodLocator = By.xpath("//tbody/tr/td[2]");

    public static void waitForElementPresent(By locator) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}
