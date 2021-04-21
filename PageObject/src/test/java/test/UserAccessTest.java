package test;

import model.User;
import org.testng.annotations.Test;
import pages.LoginPage;
import service.UserCreator;

public class UserAccessTest extends Constants {
    @Test
    public void oneCanLoginGithub()
    {
        User testUser = UserCreator.withNameAndPassword();
//        String loggedInUserName = new LoginPage(driver)
//                .openPage()
//                .login(testUser)
//                .getLoggedInUserName();
//        assertThat(loggedInUserName, is(equalTo(testUser.getUsername())));
    }
}