package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
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

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),"This is a required field.");


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

    @Test
    public void TC_05_Login_Successfull() {

        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title = 'My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        String firstName = "Harley",
         lastName ="Nguyen",
         emailAddress =getEmailRandom(),
         passWord = "123456",
         confPassword = "123456";
        String fullName = firstName +" "+lastName;

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(passWord);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(confPassword);
        driver.findElement(By.cssSelector("button[title='Register']")).click();
        sleepInSeconds(2);

        //Login
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello, "+fullName +"!");

        String contactInfo =driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        driver.findElement(By.cssSelector("div.account-cart-wrapper>a")).click();

        driver.findElement(By.cssSelector("a[title = 'Log Out']")).click();
        sleepInSeconds(5);

        driver.findElement(By.xpath("//div[@class='footer']//a[@title = 'My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input#email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#pass")).sendKeys(passWord);
        driver.findElement(By.xpath("//button[@title='Login']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello, " +fullName+ "!");

        contactInfo =driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        //Verify Account

        driver.findElement(By.xpath("//a[text()='Account Information']")).click();
        sleepInSeconds(2);


        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#email")).getAttribute("value"),emailAddress);

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        sleepInSeconds(2);

        driver.findElement(By.xpath("//img[@alt='Samsung Galaxy']")).click();
        sleepInSeconds(2);

        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();
        sleepInSeconds(2);

        driver.findElement(By.xpath("//input[@id ='Quality 1_5']")).click();

        driver.findElement(By.cssSelector("textarea#review_field")).sendKeys("It's good product");

        driver.findElement(By.cssSelector("input#summary_field")).sendKeys("Good");

        driver.findElement(By.cssSelector("input#nickname_field")).clear();
        driver.findElement(By.cssSelector("input#nickname_field")).sendKeys(firstName);

        driver.findElement(By.xpath("//button[@title ='Submit Review']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Your review has been accepted for moderation.");

        driver.findElement(By.cssSelector("div.account-cart-wrapper>a")).click();

        driver.findElement(By.cssSelector("a[title = 'Log Out']")).click();
        sleepInSeconds(6);

        Assert.assertEquals(driver.getTitle(),"Home page");







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

    public String getEmailRandom(){
        Random rand = new Random();
       return  "automation"+rand.nextInt(99999)+"@gmail.com";
    }

}
