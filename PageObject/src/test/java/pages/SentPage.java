package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SentPage extends AbstractPage {

    private final String BASE_URL = "https://mail.yahoo.com/d/folders/2/";

    By sendFolderButtonLocator = By.xpath("//a[@data-test-folder-name='Sent']");

    @Override
    public SentPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public SentPage(WebDriver driver) {
        super(driver);
    }

    public String getSendPageTitle() throws InterruptedException {
        Thread.sleep(WAIT_TITLE_TIMEOUT);
        return driver.getTitle();
    }

    public boolean verifyMailWasSent(String mailLink) {
        List<WebElement> sentMailLink = null;
        try {
            this.waitForElementPresent(By.xpath(mailLink));
            sentMailLink = driver.findElements(By.xpath(mailLink));
        } catch (
                UnhandledAlertException ex) {
            System.out.println("Alert is present: " + ex.getAlert());
        }
        return !sentMailLink.isEmpty();
    }

}


