package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DraftPage extends AbstractPage {

    private final String BASE_URL = "https://mail.yahoo.com/d/folders/3";

    By draftButtonLocator = By.xpath("//div/*[@data-test-folder-name='Draft']");
    By subjectInputLocator = By.xpath("//input[@data-test-id='compose-subject']");
    By textInputLocator = By.cssSelector("#editor-container > div.rte.em_N.ir_0.iy_A.iz_h.N_6Fd5 > div > div");
    By sendButtonLocator = By.xpath("//button[@data-test-id='compose-send-button']");

    public DraftPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public DraftPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public boolean verifyDraftPresent(String draftMailLink) {
        //  verify that the mail presents in drafts folder
        System.out.println("Verifying the draft is present...");
        this.waitForElementPresent(draftButtonLocator);
        WebElement draftBtn = driver.findElement(draftButtonLocator);
        draftBtn.click();

        this.waitForElementPresent(By.xpath(draftMailLink));
        List<WebElement> draftMails = driver.findElements(By.xpath(draftMailLink));
        draftMails.get(0).click();

        return !draftMails.isEmpty();
    }

    public boolean verifyDraftContent(String mailSubject, String mailText) {
        System.out.println("Verifying the draft content...");
        this.waitForElementPresent(subjectInputLocator);
        WebElement subjectInput = driver.findElement(subjectInputLocator);
        String mailUserName = subjectInput.getAttribute("value");

        WebElement textInput = driver.findElement(textInputLocator);
        String mailTextInput = textInput.getText();

        return (mailUserName.equals(mailSubject)) && (mailTextInput.equals(mailText));
    }

    public void sendMail() {
        System.out.println("Sending the mail...");
        this.waitForElementPresent(sendButtonLocator);
        WebElement sendBtn = driver.findElement(sendButtonLocator);
        sendBtn.click();
    }
}
