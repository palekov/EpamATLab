package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Constants {

    protected WebDriver driver;

    public static final String MAIL_BASE_URL = "https://mail.yahoo.com/";

    public static final By loginButtonLocator = By.cssSelector("a.fuji-button-link.fuji-button-text");
                                                    //By.id("login-username");
    public static final By usernameLocator = By.id("login-username");
    public static final By passwordLocator = By.className("password");
    public static final By nextButtonLocator = By.id("login-signin");

    public static final String USER_NAME = "palekovnet";
    public static final String USER_PASSWORD = "w3b-drinken715";

    public static final String MAIL_USER_NAME = "Alexander";
    public static final String MAIL_TEXT = "This is a test message from Selenium WebDriver testing scenario!!!";

    public static final String HOME_PAGE_TITLE = "Yahoo";
    public static final String MAIL_PAGE_TITLE = "palekovnet@yahoo.com";
    public static final String FOLDERS_PAGE_TITLE = "palekovnet@yahoo.com - Yahoo Mail";

    public static final String MAIL_SUBJECT_NAME = "Alexander";
    public static final String MAIL_SUBJECT_ADDRESS = "palekov-2011@mail.ru";
    public static final String MAIL_LINK_LOCATOR = "//a[@aria-label=\"palekov-2011@mail.ru\'s email\"]";

}
