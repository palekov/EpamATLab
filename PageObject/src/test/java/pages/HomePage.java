package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private static final By ENTER_BUTTON_LOCATOR = By.id("ybarMailLink");

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public EnterPage enterToMail() {
        WebElement postBtn = driver.findElement(ENTER_BUTTON_LOCATOR);
        postBtn.click();
        return new EnterPage(driver);
    }
}