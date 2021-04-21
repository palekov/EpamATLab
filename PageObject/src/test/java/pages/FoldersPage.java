package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FoldersPage extends AbstractPage {

    private final String BASE_URL = "https://mail.yahoo.com/d/";

    By composeButtonLocator = By.xpath("//div/*[@data-test-id='compose-button']");

    @Override
    public FoldersPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public FoldersPage(WebDriver driver) {
        super(driver);
    }

    public ComposePage enterToComposeMailFolder() {
        System.out.println("Entering to compose folder...");
        WebElement composeBtn = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(composeButtonLocator));
        composeBtn.click();
        return new ComposePage(driver);
    }

}
