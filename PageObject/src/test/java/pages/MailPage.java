package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailPage extends AbstractPage {

    private final String BASE_URL = "https://mail.yahoo.com/";

    private final Logger logger = LogManager.getRootLogger();

    //By loginButtonLocator = By.id("login-username");

    By loginButtonLocator = By.cssSelector("a.fuji-button-link.fuji-button-text");

    @Override
    public MailPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.warn("Opening Mail page...");
        return this;
    }

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage loginToMail() {
        logger.info("Entering to the mail login page...");
        this.waitForElementPresent(loginButtonLocator);
        WebElement enterBtn = driver.findElement(loginButtonLocator);
        enterBtn.click();
        return new LoginPage(driver);
    }
}
