import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class OnlinerTest {

    private WebDriver driver;
    private String browserType, carModel, startPrice, endPrice;

    @BeforeClass
    public void setUp() {
        browserType = System.getProperty("browser");
        if (browserType == null)
            browserType = "chrome";
        carModel = System.getProperty("carmodel");
        if (carModel == null)
            carModel = "BMW";
        startPrice = System.getProperty("startprice");
        if (startPrice == null)
            startPrice = "0";
        endPrice = System.getProperty("endprice");
        if (endPrice == null)
            endPrice = "100000";
        switch (browserType) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void threadSleep(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginTest() {
        driver.get("https://onliner.by");
        threadSleep(5000);
        assertEquals("Onliner", driver.getTitle());
    }

    @Test
    public void enterToCarMarket() {
        System.out.println("Entering to the market...");
        WebElement autoLink = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/*[@class='b-main-navigation__text' and text()='Автобарахолка']/parent::a")));
        autoLink.click();
        threadSleep(5000);
        assertTrue(driver.getTitle().contains("Автобарахолка"));
    }

    @Test
    public void selectModel() {
        System.out.println("Selecting model...");
        driver.manage().window().fullscreen();
        WebElement modelSelector = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/*[@class='input-style__faux' and text()='Марка']/parent::div")));
        modelSelector.click();
        WebElement modelInput = driver.findElement(By.xpath("//div/input[@placeholder='Найти марку']"));
        modelInput.sendKeys(carModel);
        WebElement modelKey = driver.findElement(By.xpath("//div[@class='dropdown-style__checkbox-sign' and text()='" + carModel + "']"));
        modelKey.click();
    }

    @Test
    public void selectPrice() {
        System.out.println("Slecting price...");
        WebElement modelStartPrice = driver.findElement(By.xpath("//input[@placeholder='от']"));
        modelStartPrice.sendKeys(startPrice);
        WebElement modelEndPrice = driver.findElement(By.xpath("//input[@placeholder='до']"));
        modelEndPrice.sendKeys(endPrice,Keys.ENTER);
        threadSleep(5000);
    }

    @Test
    public void checkPriceRange() {
        System.out.println("Searching prices...");
        List<WebElement> allCarPriceDatas = driver.findElements(By.xpath("//div/*[contains(text(),'р.')]"));
        String costString;
        Integer costNumber, startCost, endCost;
        startCost = Integer.parseInt(startPrice.replaceAll("\\D+",""));
        endCost = Integer.parseInt(endPrice.replaceAll("\\D+",""));
        for (int i=0; i<allCarPriceDatas.size();i++){
            costString = allCarPriceDatas.get(i).getText().replaceAll("\\D+","");
            costNumber = Integer.parseInt(costString);
            assertTrue(costNumber >= startCost && costNumber <= endCost);
        }
    }

}
