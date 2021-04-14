package test;

import driver.DriverSingleton;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.net.MalformedURLException;

import static org.testng.Assert.*;

public class SendMailTest extends Constants {

    @BeforeMethod
    public void setUp() throws MalformedURLException { driver = DriverSingleton.getDriver();  }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }

    @Test
    public void sendTest() throws InterruptedException {

        HomePage homePage = new HomePage(driver).openPage();
        assertEquals(homePage.getPageTitle(), HOME_PAGE_TITLE);

        MailPage mailPage = homePage.enterToMail();
        Thread.sleep(4500);

        assertEquals(mailPage.getPageTitle(), MAIL_PAGE_TITLE);

        String loginPageTitle = new MailPage(driver).loginToMail().getPageTitle();
        assertEquals(loginPageTitle, LOGIN_PAGE_TITLE);

        FoldersPage foldersPage = new LoginPage(driver).typeUsername(USER_NAME).submitUsernameInput()
                .typePassword(USER_PASSWORD).submitPasswordInput();

        assertEquals(foldersPage.getPageTitle(), FOLDERS_PAGE_TITLE);

        DraftPage draftPage = foldersPage.enterToComposeMailFolder().composeMail().enterToDraftsFolder();

        assertTrue(draftPage.isDraftPresent());

        assertTrue(draftPage.isDraftContentCorrect(MAIL_USER_NAME, MAIL_TEXT));

        draftPage.sendMail();

        Thread.sleep(5000);

        SentPage sendPage = new SentPage(driver).openPage();

        assertTrue(sendPage.isMailWasSent());

        sendPage.logOut();

        assertEquals(homePage.getPageTitle(), HOME_PAGE_TITLE);
    }
}
