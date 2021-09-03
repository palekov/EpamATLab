package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends AbstractPage {

    private final String BASE_URL = "https://yahoo.com/";

    private final Logger logger = LogManager.getRootLogger();

    By enterButtonLocator = By.id("ybarMailLink");
    By searchInputLocator = By.id("ybar-sbq");

    @Override
    public HomePage openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.warn("Opening Home page...");
        return this;
    }

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public HomePage searchAnything(String keyword) throws InterruptedException {
        logger.info("Searching anything...");
        this.waitForElementPresent(searchInputLocator);
        WebElement searchInput = driver.findElement(searchInputLocator);
        new Actions(driver).sendKeys(searchInput, keyword).sendKeys(searchInput, Keys.RETURN).build().perform();
        return this;
    }

    public MailPage enterToMail() {
        logger.info("Entering to the mail...");
        this.waitForElementPresent(enterButtonLocator);
        WebElement postBtn = driver.findElement(enterButtonLocator);
        postBtn.click();
        return new MailPage(driver);
    }
}