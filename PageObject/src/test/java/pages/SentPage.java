package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static test.Constants.MAIL_LINK_LOCATOR;

public class SentPage extends AbstractPage {

    private final String BASE_URL = "https://mail.yahoo.com/d/folders/2/";

    private final Logger logger = LogManager.getRootLogger();

    By accountMenuLocator = By.id("ybarAccountMenu");
    By signOutButtonLocator = By.xpath("//a[@data-soa='Sign out all']");
    By clearCheckBoxLocator = By.xpath("//span/*[@type='button' and @data-test-id='checkbox']");
    By deleteButtonLocator = By.xpath("//div/*[@data-test-id='toolbar-delete']");

    @Override
    public SentPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.warn("Opening Sent page...");
        return this;
    }

    public SentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMailWasSent() {
        List<WebElement> sentMailLink = null;
        try {
            this.waitForElementPresent(By.xpath(MAIL_LINK_LOCATOR));
            sentMailLink = driver.findElements(By.xpath(MAIL_LINK_LOCATOR));
        } catch (UnhandledAlertException ex) {
            logger.error("Alert is present: " + ex.getAlert());
        }
        return !sentMailLink.isEmpty();
    }

    public DraftPage enterToDraftsFolder() {
        logger.info("Entering to drafts folder...");
        this.waitForElementPresent(draftButtonLocator);
        WebElement draftBtn = driver.findElement(draftButtonLocator);
        draftBtn.click();
        return new DraftPage(driver);
    }

    public SentPage clearSentMails() {
        logger.info("Clearing sent folder...");
        this.waitForElementPresent(clearCheckBoxLocator);
        WebElement clearCheckBox = driver.findElement(clearCheckBoxLocator);
        clearCheckBox.click();
        this.waitForElementPresent(deleteButtonLocator);
        WebElement deleteButton = driver.findElement(deleteButtonLocator);
        new Actions(driver).moveToElement(deleteButton).click().build().perform();
        return this;
    }

    public HomePage logOut() throws InterruptedException {
        logger.info("Logging out...");
        this.waitForElementPresent(accountMenuLocator);
        WebElement accountMenu = driver.findElement(accountMenuLocator);
        new Actions(driver).moveToElement(accountMenu).build().perform();
        Thread.sleep(3000);
        this.waitForElementPresent(signOutButtonLocator);
        WebElement accountMenuSingOut = driver.findElement(signOutButtonLocator);
        new Actions(driver).moveToElement(accountMenuSingOut).click().build().perform();

        return new HomePage(driver);
    }
}


