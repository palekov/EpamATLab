package test;

import driver.DriverSingleton;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MailPage;
import pages.HomePage;
import pages.FoldersPage;

import static org.testng.Assert.assertEquals;

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
    public void userLoginTest() throws InterruptedException {
        String mailPageTitle = new HomePage(driver).openPage().enterToMail().getMailPageTitle();
        assertEquals(mailPageTitle, MAIL_PAGE_TITLE);

        String loginPageTitle = new MailPage(driver).openPage().loginToMail().getLoginPageTitle();
        //System.out.println(loginPageTitle);
        assertEquals(loginPageTitle, MAIL_PAGE_TITLE);

        String foldersPageTitle = new LoginPage(driver).typeUsername(USER_NAME).submitUsernameInput()
                .typePassword(USER_PASSWORD).submitPasswordInput().getFoldersPageTitle();
        assertEquals(foldersPageTitle, FOLDERS_PAGE_TITLE);

    }
}
