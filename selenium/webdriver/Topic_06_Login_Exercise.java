package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_Login_Exercise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Login_Empty_Email_PassWord() {

        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title = 'My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.xpath("//button[@title='Login']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div#advice-required-entry-email")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).isDisplayed());


    }

    @Test
    public void TC_02_Login_Invalid_Email() {

        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title = 'My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input#email")).sendKeys("123@123.1334");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");

        driver.findElement(By.xpath("//button[@title='Login']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");

    }

    @Test
    public void TC_03_Login_Password_less_6Character() {

        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title = 'My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input#email")).sendKeys("alohaptit@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("1234");

        driver.findElement(By.xpath("//button[@title='Login']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");


    }


    @Test
    public void TC_04_Login_Incorrect_Email_Password() {

        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title = 'My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input#email")).sendKeys("alohaptit@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("1234566");

        driver.findElement(By.xpath("//button[@title='Login']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class= 'error-msg']//span")).getText(),"Invalid login or password.");


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
