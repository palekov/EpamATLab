package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    By usernameLocator = By.id("login-username");
    By passwordLocator = By.className("password");
    By nextButtonLocator = By.id("login-signin");

//    WebElement loginInput = new WebDriverWait(driver, 10)
//            .until(ExpectedConditions.presenceOfElementLocated(use)));
//
//        loginInput.sendKeys("palekovnet");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage typeUsername(String username) {
        WebElement loginInput = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(usernameLocator));
        loginInput.sendKeys(username);      //  ("palekovnet");

        return this;
    }

    public LoginPage typePassword(String password) {
        WebElement passwordInput = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(passwordLocator));
        passwordInput.sendKeys(password);     //("w3b-driwen43");

        return this;
    }

    public MailPage submitInput() {
        WebElement nextBtn = driver.findElement(nextButtonLocator);
        nextBtn.click();
        return new MailPage(driver);
    }

//    public LoginPage submitLoginExpectingFailure() {
//        driver.findElement(loginButtonLocator).submit();
//        return new LoginPage(driver);
//    }
//
//    public HomePage loginAs(String username, String password) {
//        typeUsername(username);
//        typePassword(password);
//        return submitLogin();
//    }

}