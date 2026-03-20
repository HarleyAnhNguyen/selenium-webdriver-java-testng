package webdriver;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_33_Fluent {
    WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
//    @Test
//    public void TC_01_() {
//        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
//        findElement(10,100, By.id("email"));
//
//    }

    @Test
    public void TC_02_Dynamic_Loading() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        findElement(30,100,By.cssSelector("div#start button")).click();
        Assert.assertEquals(getElementText(By.cssSelector("div#finish h4")),"Hello World!");

    }

    @Test
    public void TC_03_CountDown() {
        driver.get("https://automationfc.github.io/fluent-wait/");
        WebElement countDownTime = findElement(10, 100,By.id("javascript_countdown_time"));
        Assert.assertTrue(isSecondMatching(countDownTime));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    //Viết 1 hàm để tìm element cs timeout/polling tự set
    // Điều kiện của hàm là find Element: kiểu trả về của hàm apply
    // findElement thì ần có driver : tham số của hàm apply

    public WebElement findElement(long timeout, long polling, By by){
        FluentWait<WebDriver> driverFluentWait = new FluentWait<>(driver);
        driverFluentWait.withTimeout(Duration.ofSeconds(timeout));
        driverFluentWait.pollingEvery(Duration.ofMillis(polling));
        driverFluentWait.ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, WebElement>() {
            /**
             * @param input the function argument
             * @return
             */
            @Override
            public WebElement apply(WebDriver input) {
                return driver.findElement(by);
            }
        });
    }

    public boolean isElementDisplayed(WebElement element){
        FluentWait<WebElement> driverFluentWait = new FluentWait<>(element);
        driverFluentWait.withTimeout(Duration.ofSeconds(30));
        driverFluentWait.pollingEvery(Duration.ofMillis(100));
        driverFluentWait.ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebElement, Boolean>() {
            /**
             * @param input the function argument
             * @return
             */
            @Override
            public Boolean apply(WebElement element) {
                return element.isDisplayed();
            }
        });
    }

    public String getElementText(By by){
        FluentWait<WebDriver> driverFluentWait = new FluentWait<>(driver);
        driverFluentWait.withTimeout(Duration.ofSeconds(30));
        driverFluentWait.pollingEvery(Duration.ofMillis(100));
        driverFluentWait.ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, String>() {
            /**
             * @param input the function argument
             * @return
             */
            @Override
            public String apply(WebDriver driver) {
                return driver.findElement(by).getText();
            }
        });
    }

    public boolean isSecondMatching(WebElement element){
        FluentWait<WebElement> driverFluentWait = new FluentWait<>(element);
        driverFluentWait.withTimeout(Duration.ofSeconds(12));
        driverFluentWait.pollingEvery(Duration.ofMillis(200));
        driverFluentWait.ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebElement, Boolean>() {
            /**
             * @param input the function argument
             * @return
             */
            @Override
            public Boolean apply(WebElement element) {

                return element.getText().endsWith("00");
            }
        });
    }

}
