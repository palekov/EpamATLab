package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected abstract AbstractPage openPage();

    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected final int WAIT_TITLE_TIMEOUT = 4000;

    protected static final String MAIL_SUBJECT_NAME = "Alexander";
    protected static final String MAIL_SUBJECT_ADDRESS = "palekov-2011@mail.ru";
    protected static final String MAIL_LINK_LOCATOR = "//a[@aria-label=\"palekov-2011@mail.ru\'s email\"]";

    By draftButtonLocator = By.xpath("//div/*[@data-test-folder-name='Draft']");

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    public void waitForElementPresent(By locator) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public String getPageTitle() throws InterruptedException {
        Thread.sleep(WAIT_TITLE_TIMEOUT);
        return driver.getTitle();
    }

}



