package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComposePage extends AbstractPage {

    private final String BASE_URL = "";

    private final int AUTOSAVE_TIMEOUT = 25000;
    private final String MAIL_TEXT = "This is a test message from Selenium WebDriver testing scenario!!!";

    public ComposePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ComposePage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public SendPage composeMail() throws InterruptedException {

        WebElement messagetoInput = driver.findElement(By.id("message-to-field"));
        messagetoInput.sendKeys("palekov-2011@mail.ru");

        WebElement subjectInput = driver.findElement(By.xpath("//input[@data-test-id='compose-subject']"));
        subjectInput.sendKeys("Alexander");

        WebElement messageTextInput = driver.findElement(By.xpath("//div/*[@aria-label='Message body']"));
        messageTextInput.sendKeys(MAIL_TEXT);

        //  waiting for autosave the mail in to drafts folder
        Thread.sleep(AUTOSAVE_TIMEOUT);

        return new SendPage(driver);
    }
}
