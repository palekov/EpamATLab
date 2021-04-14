package driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {}

    public static WebDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            //driver = new ChromeDriver();
            String nodeURL = "http://192.168.1.104:5566/wd/hub";
//            DesiredCapabilities capability = DesiredCapabilities.firefox();
//            capability.setBrowserName("firefox");
//            capability.setPlatform(Platform.VISTA);
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(new URL(nodeURL), options);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
