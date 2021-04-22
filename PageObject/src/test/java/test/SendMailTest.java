package test;

import driver.DriverSingleton;
import model.User;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import service.UserCreator;

import static org.testng.Assert.*;

public class SendMailTest extends Constants {

    @BeforeMethod
    public void setUp()  {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }

    @Test
    public void sendTest() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        User testUser = UserCreator.withNameAndPassword();

        HomePage homePage = new HomePage(driver).openPage();
        assertEquals(homePage.getPageTitle(), HOME_PAGE_TITLE);

        String url = js.executeScript("return document.URL;").toString();
        System.out.println("URL of the site = "+url);

        MailPage mailPage = homePage.openPage().enterToMail();

        Thread.sleep(4500);

        String loginPageTitle = new MailPage(driver).loginToMail().getPageTitle();

        FoldersPage foldersPage = new LoginPage(driver).login(testUser);

        assertEquals(foldersPage.getPageTitle(), FOLDERS_PAGE_TITLE);

        DraftPage draftPage = foldersPage.enterToComposeMailFolder().composeMail().enterToDraftsFolder();

        assertTrue(draftPage.isDraftPresent());

        assertTrue(draftPage.isDraftContentCorrect(MAIL_USER_NAME, MAIL_TEXT));

        draftPage.sendMail();

        Thread.sleep(5000);

        SentPage sendPage = new SentPage(driver).openPage();

        assertTrue(sendPage.isMailWasSent());

        sendPage.clearSentMails();

        sendPage.logOut();

        assertEquals(homePage.getPageTitle(), HOME_PAGE_TITLE);
    }
}
