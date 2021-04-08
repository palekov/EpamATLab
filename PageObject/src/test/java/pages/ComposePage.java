package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComposePage extends AbstractPage {

    private final String BASE_URL = "";

    private final int AUTOSAVE_TIMEOUT = 25000;
    private final String MAIL_TEXT = "This is a test message from Selenium WebDriver testing scenario!!!";

    By messagetoInputLocator = By.id("message-to-field");
    By subjectInputLocator = By.xpath("//input[@data-test-id='compose-subject']");
    By textInputLocator = By.xpath("//div/*[@aria-label='Message body']");

    public ComposePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ComposePage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String getComposePageTitle() throws InterruptedException {
        Thread.sleep(WAIT_TITLE_TIMEOUT);
        return driver.getTitle();
    }

    public SentPage composeMail() throws InterruptedException {
        System.out.println("Composing the mail...");
        WebElement messagetoInput = driver.findElement(messagetoInputLocator);
        messagetoInput.sendKeys("palekov-2011@mail.ru");

        WebElement subjectInput = driver.findElement(subjectInputLocator);
        subjectInput.sendKeys("Alexander");

        WebElement messageTextInput = driver.findElement(textInputLocator);
        messageTextInput.sendKeys(MAIL_TEXT);

        //  waiting for autosave the mail in to drafts folder
        Thread.sleep(AUTOSAVE_TIMEOUT);

        return new SentPage(driver);
    }
}
