package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static test.CommonConditions.MAIL_LINK;

public class SendPage extends AbstractPage {

    private final String BASE_URL = "";

    @Override
    protected AbstractPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public SendPage(WebDriver driver) {
        super(driver);
    }

    public void sendMail() throws InterruptedException {

            //  send the mail
            WebElement sendBtn = driver.findElement(By.xpath("//button[@data-test-id='compose-send-button']"));
            sendBtn.click();
            Thread.sleep(5000);

            //  verify that the mail disappeared from drafts folder
            List<WebElement> draftMailLink = driver.findElements(By.xpath(MAIL_LINK));
            assertTrue(draftMailLink.isEmpty());

            //  verify that the mail is in sent folder
            WebElement sentFolderBtn = driver.findElement(By.xpath("//a[@data-test-folder-name='Sent']"));
            sentFolderBtn.click();

            List<WebElement> sentMailLink = driver.findElements(By.xpath(MAIL_LINK));

            assertFalse(sentMailLink.isEmpty());

            Thread.sleep(5000);
        }
    }

