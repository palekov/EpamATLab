package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailPage extends AbstractPage {

    private final String BASE_URL = "https://mail.yahoo.com/";

    private static final By LOGIN_BUTTON_LOCATOR = By.cssSelector("a.fuji-button-link.fuji-button-text");

    @Override
    public MailPage openPage() {
            driver.navigate().to(BASE_URL);
            return this;
        }

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public String getMailPageTitle() {
        return driver.getTitle();
    }

    public LoginPage loginToMail() {
        WebElement enterBtn = driver.findElement(LOGIN_BUTTON_LOCATOR);
        enterBtn.click();
        return new LoginPage(driver);
    }
}
