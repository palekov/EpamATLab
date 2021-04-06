package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {

    protected WebDriver driver;
    protected static final String USER_NAME = "palekovnet";
    protected static final String USER_PASSWORD = "w3b-driwen43";
    public static final String MAIL_LINK = "//a[@aria-label=\"palekov-2011@mail.ru\'s email\"]";
    public static final String MAIL_TEXT = "This is a test message from Selenium WebDriver testing scenario!!!";

    //    public boolean isElementPresent(By by) {
//        try {
//            driver.findElement(by);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }

    @BeforeMethod
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
