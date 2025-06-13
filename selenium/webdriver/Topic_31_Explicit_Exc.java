package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class Topic_31_Explicit_Exc {
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
    public void TC_01_Less_Than(){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.xpath("//button[text() ='Start']")).click();

        //Điều kiện wait
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }

    @Test
    public void TC_02_Equal(){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.xpath("//button[text() ='Start']")).click();

        //Điều kiện wait
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }

    @Test
    public void TC_03_More_Than(){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.xpath("//button[text() ='Start']")).click();

        //Điều kiện wait
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }

    @Test
    public void TC_04() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.xpath("//button[text() ='Start']")).click();

        //Visible (dành cho 1 element sau được xuất hiện)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));

        //Invisible (dành cho 1 element sắp biến mất/ kì vọng biến mất đi)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));

        //Text
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div#finish>h4"),"Hello World!"));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }

    @Test
    public void TC_04_Calendar() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        //Wait and verify Calendar element is display
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1"))).isDisplayed());

        //Wait and verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"No Selected Dates to display.")));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
