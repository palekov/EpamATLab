package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FoldersPage extends AbstractPage {

    private final String BASE_URL = "https://mail.yahoo.com/d/";

    By composeButtonLocator = By.xpath("//div/*[@data-test-id='compose-button']");
    By draftButtonLocator = By.xpath("//div/*[@data-test-folder-name='Draft']");
    By accountMenuLocator = By.id("ybarAccountMenu");
    By signOutButtonLocator = By.xpath("//a[@data-soa='Sign out all']");

    @Override
    public FoldersPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public FoldersPage(WebDriver driver) {
        super(driver);
    }

    public String getFoldersPageTitle() throws InterruptedException {
        Thread.sleep(WAIT_TITLE_TIMEOUT);
        return driver.getTitle();
    }

    public ComposePage enterToComposeMailFolder() {
        System.out.println("Entering to compose folder...");
        WebElement composeBtn = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(composeButtonLocator));
        composeBtn.click();
        return new ComposePage(driver);
    }

    public DraftPage enterToDraftsFolder() {
        System.out.println("Entering to drafts folder...");
        this.waitForElementPresent(draftButtonLocator);
        WebElement draftBtn = driver.findElement(draftButtonLocator);
        draftBtn.click();
        return new DraftPage(driver);
    }

    public HomePage logOut() {
        System.out.println("Logging out...");
        this.waitForElementPresent(accountMenuLocator);
        WebElement accountMenu = driver.findElement(accountMenuLocator);
        new Actions(driver).moveToElement(accountMenu).build().perform();

        this.waitForElementPresent(signOutButtonLocator);
        WebElement accountMenuSingOut = driver.findElement(signOutButtonLocator);
        new Actions(driver).moveToElement(accountMenuSingOut).click().build().perform();
        return new HomePage(driver);
    }
}
