package test;

import driver.DriverSingleton;
import model.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FoldersPage;
import pages.LoginPage;
import service.UserCreator;

import static org.testng.AssertJUnit.assertTrue;

public class UserAccessTest extends AbstractTest {

    @BeforeMethod
    public void setUp()  {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }

    @Test
    public void userCanLogin() throws InterruptedException {

        User testUser = UserCreator.withNameAndPassword();

        FoldersPage foldersPage = new LoginPage(driver)
                .openPage()
                .login(testUser);
        String loggedInPageTitle = foldersPage.getPageTitle();
        String userName = testUser.getUsername();

        assertTrue(loggedInPageTitle.contains(userName));
    }
}