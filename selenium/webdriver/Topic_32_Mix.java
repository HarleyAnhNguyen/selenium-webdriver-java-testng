package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_32_Mix {
    WebDriver driver;
    Actions action;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        action = new Actions(driver);
        action.moveByOffset(0,0).perform();
    }
    @Test
    public void TC_01_Element_Found() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        //Wait với explicit
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

        //Wait với implicit
        driver.findElement(By.cssSelector("input#email"));
    }

    @Test
    public void TC_02_Element_Not_Found_Only_Implicit() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        //Wait với implicit
        driver.findElement(By.cssSelector("input#automation"));
    }

    @Test
    public void TC_03_Element_Not_Found_Only_Explicit_By() {

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        //Wait với explicit
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#automation")));


    }

    @Test
    public void TC_03_Element_Not_Found_Only_Explicit_WebElement() {

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        //Wait với explicit
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#automation"))));


    }

    @Test
    public void TC_04_Element_Not_Found_Mix_Implicit_Explicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(1));


        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        //Wait với explicit
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#automation"))));


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
