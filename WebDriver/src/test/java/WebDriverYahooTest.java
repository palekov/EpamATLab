import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverYahooTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

      //  driver.manage().timeouts().pageLoadTimeout(17, TimeUnit.SECONDS);

        driver.get("https://yahoo.com");

        WebElement postBtn = driver.findElement(By.id("ybarMailLink"));
        postBtn.click();

        Thread.sleep(5000);

        WebElement enterBtn = driver.findElement(By.cssSelector("a.fuji-button-link.fuji-button-text"));
        enterBtn.click();

        WebElement loginInput = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("login-username")));

        loginInput.sendKeys("palekovnet");

        WebElement signinBtn1 = driver.findElement(By.id("login-signin"));
        signinBtn1.click();

        WebElement passwordInput = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("password")));
        passwordInput.sendKeys("w3b-driwen43");

        WebElement signinBtn2 = driver.findElement(By.id("login-signin"));
        signinBtn2.click();

        WebElement composeBtn = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/*[@data-test-id='compose-button']")));
        composeBtn.click();

        //  create a new mail
        WebElement messagetoInput = driver.findElement(By.id("message-to-field"));
        messagetoInput.sendKeys("palekov-2011@mail.ru");

        WebElement subjectInput = driver.findElement(By.xpath("//input[@data-test-id='compose-subject']"));
        subjectInput.sendKeys("Alexander");

        WebElement messageTextInput = driver.findElement(By.xpath("//div/*[@aria-label='Message body']"));
        messageTextInput.sendKeys("This is a test message from Selenium WebDriver testing scenario!!!");

        //  waiting for autosave in drafts folder
        Thread.sleep(5000);

        //  verify that the mail presents in drafts folder
        WebElement draftBtn = driver.findElement(By.xpath("//div/*[@data-test-folder-name='Draft']"));
        draftBtn.click();

        WebElement draftmailLink = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label=\"palekov-2011@mail.ru\'s email\"]")));
        draftmailLink.click();
        Thread.sleep(5000);
        //  verify the draft content

        //  send the mail
        WebElement sendBtn = driver.findElement(By.xpath("//button[@data-test-id='compose-send-button']"));
        sendBtn.click();
        Thread.sleep(5000);
        //  verify that the mail disappeared from drafts folder

        //  verify that the mail is in sent folder
        WebElement sentFolderBtn = driver.findElement(By.xpath("//a[@data-test-folder-name='Sent']"));
        sentFolderBtn.click();
        Thread.sleep(5000);

        //  log off
        WebElement accountMenu = driver.findElement(By.id("ybarAccountMenu"));
        new Actions(driver).moveToElement(accountMenu).build().perform();

        WebElement signoutBtn = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-soa='Sign out all']")));
        signoutBtn.click();

        driver.quit();
    }
}
