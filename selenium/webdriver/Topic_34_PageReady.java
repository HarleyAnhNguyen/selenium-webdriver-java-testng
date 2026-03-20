package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_34_PageReady {
    WebDriver driver;

    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));

    }
    @Test
    public void TC_01_PageReady() throws InterruptedException {
        driver.get("http://localhost:8086/login?returnUrl=%2F");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("dam@automationfc.vn");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("dam@automationfc.vn");
        driver.findElement(By.cssSelector("button.login-button")).click();


        driver.findElement(By.cssSelector("a.administration")).click();
        Thread.sleep(1000);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("a.nav-link i.fa-book"))).click();
        Thread.sleep(1000);

//        driver.get("http://localhost:8086/Admin/Product/List");


//        driver.findElement(By.xpath("//i/parent::p[contains(text(),'Catalog')]/parent::a")).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("a.nav-link[href='/Admin/Product/List']"))).click();
//        driver.findElement(By.xpath("//i/parent::p[contains(text(),'Catalog')]/parent::a/following::ul//p[text()=' Products']/parent::a")).click();

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy"))));


    }

    @Test
    public void TC_02_Element_Not_Found_Only_Implicit() {


    }

    @AfterClass
    public void afterClass() {

        driver.quit();
    }

}
