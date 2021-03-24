import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverMail {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(12, TimeUnit.SECONDS);
        driver.get("http://yandex.by");

        WebElement postBtn = driver.findElement(By.cssSelector(".button.desk-notif-card__login-enter-expanded"));


        postBtn.click();

        Thread.sleep(5000);

        WebElement loginInput = driver.findElement(By.cssSelector(".Field.Field_view_floating-label"));

        // #passp-field-login
        //*[@id="passp-field-login"]

        loginInput.sendKeys("w3b.driver");

        WebElement loginBtn = driver.findElement(By.cssSelector(".passp-sign-in-button"));
        loginBtn.click();

        Thread.sleep(5000);
        driver.quit();

    }
}
