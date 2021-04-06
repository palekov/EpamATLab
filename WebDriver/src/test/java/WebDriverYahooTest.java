import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class WebDriverYahooTest {

    private WebDriver driver;
    private final String MAIL_LINK = "//a[@aria-label=\"palekov-2011@mail.ru\'s email\"]";
    private final String MAIL_TEXT = "This is a test message from Selenium WebDriver testing scenario!!!";
    private final int AUTOSAVE_TIMEOUT = 25000;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://yahoo.com");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void threadSleep(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginTest() {
        WebElement postBtn = driver.findElement(By.id("ybarMailLink"));
        postBtn.click();

        threadSleep(5000);

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

        WebElement accountMenu = driver.findElement(By.xpath("//*[@id=\"ybarAccountMenu\"]"));

        assertEquals(accountMenu.getAttribute("aria-label"), "Manage your Yahoo accounts: Alexander (palekovnet)");

    }
    
    @Test
    public void createMailTest() {
        //  create a new mail
        WebElement composeBtn = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/*[@data-test-id='compose-button']")));
        composeBtn.click();

        WebElement messagetoInput = driver.findElement(By.id("message-to-field"));
        messagetoInput.sendKeys("palekov-2011@mail.ru");

        WebElement subjectInput = driver.findElement(By.xpath("//input[@data-test-id='compose-subject']"));
        subjectInput.sendKeys("Alexander");

        WebElement messageTextInput = driver.findElement(By.xpath("//div/*[@aria-label='Message body']"));
        messageTextInput.sendKeys(MAIL_TEXT);

        //  waiting for autosave the mail in to drafts folder
        threadSleep(AUTOSAVE_TIMEOUT);
    }

    @Test
    public void verifyMailPresents() {
        //  verify that the mail presents in drafts folder
        WebElement draftBtn = driver.findElement(By.xpath("//div/*[@data-test-folder-name='Draft']"));
        draftBtn.click();

        List<WebElement> draftMailLink = driver.findElements(By.xpath(MAIL_LINK));

        assertFalse(draftMailLink.isEmpty());

        threadSleep(5000);
    }

    @Test
    public void verifyDraftContent() {
        //  verify the draft content
        WebElement verifySubjectInput = driver.findElement(By.xpath("//input[@data-test-id='compose-subject']"));
        assertEquals("Alexander", verifySubjectInput.getAttribute("value"));

        WebElement verifyTextInput = driver.findElement(By.cssSelector("#editor-container > div.rte.em_N.ir_0.iy_A.iz_h.N_6Fd5 > div > div"));

        assertEquals(MAIL_TEXT, verifyTextInput.getText());
    }

    @Test
    public void sendMailTest() {
        //  send the mail
        WebElement sendBtn = driver.findElement(By.xpath("//button[@data-test-id='compose-send-button']"));
        sendBtn.click();
        threadSleep(5000);

        //  verify that the mail disappeared from drafts folder
        List<WebElement> draftMailLink = driver.findElements(By.xpath(MAIL_LINK));
        assertTrue(draftMailLink.isEmpty());

        //  verify that the mail is in sent folder
        WebElement sentFolderBtn = driver.findElement(By.xpath("//a[@data-test-folder-name='Sent']"));
        sentFolderBtn.click();

        List<WebElement> sentMailLink = driver.findElements(By.xpath(MAIL_LINK));

        assertFalse(sentMailLink.isEmpty());

        threadSleep(5000);
    }

    @Test
    public void logoutTest() {
        //  log off
        WebElement accountMenu = driver.findElement(By.id("ybarAccountMenu"));
        new Actions(driver).moveToElement(accountMenu).build().perform();

        WebElement accountMenuSingOut = driver.findElement(By.xpath("//a[@data-soa='Sign out all']"));
        new Actions(driver).moveToElement(accountMenuSingOut).click().build().perform();
    }
}
