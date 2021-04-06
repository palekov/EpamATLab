package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnterPage {
    private static final By LOGIN_BUTTON_LOCATOR = By.cssSelector("a.fuji-button-link.fuji-button-text");

    private final WebDriver driver;

    public EnterPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginToMail() {
        WebElement enterBtn = driver.findElement(LOGIN_BUTTON_LOCATOR);
        enterBtn.click();
        return new LoginPage(driver);
    }
}
