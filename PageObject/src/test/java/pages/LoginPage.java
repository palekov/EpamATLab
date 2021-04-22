package pages;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    private final String BASE_URL = "https://login.yahoo.com/";

    @FindBy(id = "login-username")
    private WebElement usernameInput;

    @FindBy(className = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-signin")
    private WebElement nextButton;

    @Override
    public LoginPage openPage() {
            driver.navigate().to(BASE_URL);
            return this;
        }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage typeUsername(String username) {
        System.out.println("Typing user name...");
        usernameInput.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) throws InterruptedException {
        System.out.println("Typing password...");
        Thread.sleep(3000);
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage submitUsernameInput() {
        System.out.println("Submitting username...");
        nextButton.click();
        return this;
    }

    public LoginPage submitPasswordInput() {
        System.out.println("Submitting password...");
        nextButton.click();
        return this;
    }

    public FoldersPage login(User user) throws InterruptedException {
            this.typeUsername(user.getUsername()).submitUsernameInput()
                .typePassword(user.getPassword()).submitPasswordInput();
        return new FoldersPage(driver);
        }

}