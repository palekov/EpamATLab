package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {

    private final String BASE_URL = "https://yahoo.com/";

    By enterButtonLocator = By.id("ybarMailLink");

    @Override
    public HomePage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public MailPage enterToMail() {
        System.out.println("Entering to the mail...");
        this.waitForElementPresent(enterButtonLocator);
        WebElement postBtn = driver.findElement(enterButtonLocator);
        postBtn.click();
        return new MailPage(driver);
    }
}