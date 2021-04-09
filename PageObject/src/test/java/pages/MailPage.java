package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailPage extends AbstractPage {

    private final String BASE_URL = "https://mail.yahoo.com/";

    By loginButtonLocator = By.cssSelector("a.fuji-button-link.fuji-button-text");

    @Override
    public MailPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage loginToMail() {
        System.out.println("Logging to mail account...");
        this.waitForElementPresent(loginButtonLocator);
        WebElement enterBtn = driver.findElement(loginButtonLocator);
        enterBtn.click();
        return new LoginPage(driver);
    }
}
