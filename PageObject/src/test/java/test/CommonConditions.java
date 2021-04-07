package test;

import org.openqa.selenium.WebDriver;

public class CommonConditions {

    protected WebDriver driver;
    protected static final String USER_NAME = "palekovnet";
    protected static final String USER_PASSWORD = "w3b-driwen43";

    public static final String MAIL_LINK = "//a[@aria-label=\"palekov-2011@mail.ru\'s email\"]";
    public static final String MAIL_TEXT = "This is a test message from Selenium WebDriver testing scenario!!!";

    protected static final String MAIL_PAGE_TITLE = "Yahoo Почта";
    protected static final String FOLDERS_PAGE_TITLE = "palekovnet@yahoo.com - Yahoo Mail";


}
