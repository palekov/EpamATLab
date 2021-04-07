package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {

    private final String BASE_URL = "https://yahoo.com/";

    private static final By ENTER_BUTTON_LOCATOR = By.id("ybarMailLink");

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

    public MailPage enterToMail() throws InterruptedException {
        WebElement postBtn = driver.findElement(ENTER_BUTTON_LOCATOR);
        postBtn.click();
        Thread.sleep(5000);
        return new MailPage(driver);
    }
}