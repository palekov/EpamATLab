package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FoldersPage extends AbstractPage {

    private final String BASE_URL = "https://mail.yahoo.com/d/";

    private final Logger logger = LogManager.getRootLogger();

    By composeButtonLocator = By.xpath("//div/*[@data-test-id='compose-button']");

    @Override
    public FoldersPage openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.warn("Opening Folders page...");
        return this;
    }

    public FoldersPage(WebDriver driver) {
        super(driver);
    }

    public ComposePage enterToComposeMailFolder() {
        logger.info("Entering to compose folder...");
        WebElement composeBtn = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(composeButtonLocator));
        composeBtn.click();
        return new ComposePage(driver);
    }

}
