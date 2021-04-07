package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

    private final String BASE_URL = "https://login.yahoo.com/";

    By usernameLocator = By.id("login-username");
    By passwordLocator = By.className("password");
    By nextButtonLocator = By.id("login-signin");

    @Override
    public LoginPage openPage() {
            driver.navigate().to(BASE_URL);
            return this;
        }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeUsername(String username) {
        WebElement loginInput = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(usernameLocator));
        loginInput.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        WebElement passwordInput = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(passwordLocator));
        passwordInput.sendKeys(password);
        return this;
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public LoginPage submitUsernameInput() {
        WebElement nextBtn = driver.findElement(nextButtonLocator);
        nextBtn.click();
        return this;
    }

    public FoldersPage submitPasswordInput() {
        WebElement nextBtn = driver.findElement(nextButtonLocator);
        nextBtn.click();
        return new FoldersPage(driver);
    }
}