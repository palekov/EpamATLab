package test;

import cucumber.api.java.en.*;
import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.Constants;

import static org.testng.Assert.assertEquals;

//        @Given User have open the browser
//        @When user navigates to yahoo mail page
//        @And click login button
//        @And enters user credentials
//        @Then yahoo mail page is displayed

public class CucumberMailTestSteps extends Constants {

    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected final int WAIT_TITLE_TIMEOUT = 4000;

    public void waitForElementPresent(By locator) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    @Given("^User have open the browser$")
    public void open_the_browser() {
        driver = DriverSingleton.getDriver();
    }

    @When("^user navigates to yahoo mail page$")
    public void navigate_to_home_page() {
        driver.navigate().to(MAIL_BASE_URL);
    }

    @And("^click login button$")
    public void click_login_button() {
        this.waitForElementPresent(loginButtonLocator);
        WebElement loginBtn = driver.findElement(loginButtonLocator);
        loginBtn.click();
    }

    @And("^enters user credentials$")
    public void enter_user_credentials() {
        WebElement loginInput = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(usernameLocator));
        loginInput.sendKeys(USER_NAME);

        WebElement nextBtn = driver.findElement(nextButtonLocator);
        nextBtn.click();

        WebElement passwordInput = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(passwordLocator));
        passwordInput.sendKeys(USER_PASSWORD);

        //driver.findElement(nextButtonLocator);
        nextBtn.click();
    }

    @Then("^yahoo mail home page is displayed$")
    public void mail_home_page_is_displayed() throws InterruptedException {
        Thread.sleep(WAIT_TITLE_TIMEOUT);
        assertEquals(driver.getTitle(), FOLDERS_PAGE_TITLE);
        DriverSingleton.closeDriver();
    }

}
