package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Constants {

    protected WebDriver driver;
    protected static final String MAIL_BASE_URL = "https://mail.yahoo.com/";

    protected static final By loginButtonLocator = By.id("login-username");
    protected static final By usernameLocator = By.id("login-username");
    protected static final By passwordLocator = By.className("password");
    protected static final By nextButtonLocator = By.id("login-signin");

    protected static final String USER_NAME = "palekovnet";
    protected static final String USER_PASSWORD = "w3b-drinken715";

    protected static final String MAIL_USER_NAME = "Alexander";
    protected static final String MAIL_TEXT = "This is a test message from Selenium WebDriver testing scenario!!!";

    protected static final String HOME_PAGE_TITLE = "Yahoo";
    protected static final String MAIL_PAGE_TITLE = "Yahoo Почта";
    protected static final String FOLDERS_PAGE_TITLE = "palekovnet@yahoo.com - Yahoo Mail";
    protected static final String LOGIN_PAGE_TITLE = "Yahoo";

    public static final String MAIL_SUBJECT_NAME = "Alexander";
    public static final String MAIL_SUBJECT_ADDRESS = "palekov-2011@mail.ru";
    public static final String MAIL_LINK_LOCATOR = "//a[@aria-label=\"palekov-2011@mail.ru\'s email\"]";

}
