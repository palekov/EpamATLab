package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SentPage extends AbstractPage {

    private final String BASE_URL = "https://mail.yahoo.com/d/folders/2/";

    By accountMenuLocator = By.id("ybarAccountMenu");
    By signOutButtonLocator = By.xpath("//a[@data-soa='Sign out all']");

    @Override
    public SentPage openPage() {
        driver.navigate().to(BASE_URL);
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
        } catch (
                UnhandledAlertException ex) {
            System.out.println("Alert is present: " + ex.getAlert());
        }
        return !sentMailLink.isEmpty();
    }

    public DraftPage enterToDraftsFolder() {
        System.out.println("Entering to drafts folder...");
        this.waitForElementPresent(draftButtonLocator);
        WebElement draftBtn = driver.findElement(draftButtonLocator);
        draftBtn.click();
        return new DraftPage(driver);
    }

    public HomePage logOut() throws InterruptedException {
        System.out.println("Logging out...");
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


