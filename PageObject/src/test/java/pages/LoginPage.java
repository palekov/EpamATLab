package pages;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    private final String BASE_URL = "https://login.yahoo.com/";

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "login-username")
    private WebElement usernameInput;

    @FindBy(className = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-signin")
    private WebElement nextButton;

    @Override
    public LoginPage openPage() {
            driver.navigate().to(BASE_URL);
            logger.warn("Opening Login page...");
            return this;
        }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage typeUsername(String username) {
        logger.info("Typing user name...");
        usernameInput.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) throws InterruptedException {
        logger.info("Typing password...");
        Thread.sleep(3000);
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage submitUsernameInput() {
        logger.info("Submitting username...");
        nextButton.click();
        return this;
    }

    public LoginPage submitPasswordInput() {
        logger.info("Submitting password...");
        nextButton.click();
        return this;
    }

    public FoldersPage login(User user) throws InterruptedException {
            this.typeUsername(user.getUsername()).submitUsernameInput()
                .typePassword(user.getPassword()).submitPasswordInput();
        return new FoldersPage(driver);
        }

}