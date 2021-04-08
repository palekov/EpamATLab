package test;

import driver.DriverSingleton;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.*;

public class SendMailTest extends CommonConditions {

    @BeforeMethod
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
        //driver.get("https://yahoo.com");
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }

    @Test
    public void sendTest() throws InterruptedException {

        String mailPageTitle = new HomePage(driver).openPage()
                .enterToMail().getMailPageTitle();
        assertEquals(mailPageTitle, MAIL_PAGE_TITLE);

        String loginPageTitle = new MailPage(driver).loginToMail().getLoginPageTitle();
        assertEquals(loginPageTitle, LOGIN_PAGE_TITLE);

        String foldersPageTitle = new LoginPage(driver).typeUsername(USER_NAME).submitUsernameInput()
                .typePassword(USER_PASSWORD).submitPasswordInput()
                .getFoldersPageTitle();
        assertEquals(foldersPageTitle, FOLDERS_PAGE_TITLE);

        ComposePage composePage = new FoldersPage(driver).enterToComposeMailFolder();

        composePage.composeMail();

        DraftPage draftPage = new FoldersPage(driver).enterToDraftsFolder();

        assertTrue(draftPage.verifyDraftPresent(MAIL_LINK));

        assertTrue(draftPage.verifyDraftContent(MAIL_USER_NAME, MAIL_TEXT));

        draftPage.sendMail();

        Thread.sleep(5000);

        SentPage sendPage = new SentPage(driver).openPage();

        assertTrue(sendPage.verifyMailWasSent(MAIL_LINK));

        String homePageTitle = new FoldersPage(driver).openPage().logOut().getHomePageTitle();
        assertEquals(homePageTitle, HOME_PAGE_TITLE);
    }
}
