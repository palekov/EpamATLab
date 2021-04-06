package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {

    private final WebDriver driver;

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    public ComposePage composeMail() {
        WebElement composeBtn = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/*[@data-test-id='compose-button']")));
        composeBtn.click();

        return new ComposePage(driver);
    }
}
