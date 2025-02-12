package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_15_JS_Alert {
    WebDriver driver;
    WebDriverWait explicitWait;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Accept_Alert() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text() = 'Click for JS Alert']")).click();
        Thread.sleep(1000);
// dung nhieu lan thi khai bao bien
        Alert alert = driver.switchTo().alert();
       /* alert.accept();
        alert.dismiss();
        alert.getText();
        alert.sendKeys("");*/

// dung 1 lan thi goi ham truc tiep
        //Accept alert
       // driver.switchTo().alert().accept();

        //Cancel alert
        //driver.switchTo().alert().dismiss();

        //Get text ben trong Alert
       // String text = driver.switchTo().alert().getText();

        //Enter text vao Alert
        //driver.switchTo().alert().sendKeys("");
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked an alert successfully");


    }

    @Test
    public void TC_02_Confirm_Alert()  {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text() = 'Click for JS Confirm']")).click();

        //vua wait alert present va switch qua
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());


        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked: Cancel");

    }

    @Test
    public void TC_03_Prompt() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text() = 'Click for JS Prompt']")).click();

        //vua wait alert present va switch qua
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());


        Assert.assertEquals(alert.getText(),"I am a JS prompt");
        String value = "Automation Test";
        alert.sendKeys(value);
        alert.accept();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You entered: "+value);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
