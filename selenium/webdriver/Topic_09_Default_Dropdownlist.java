package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_09_Default_Dropdownlist {
    WebDriver driver;
    String fistName="Automation", lastName = "Test"
            , company = "ABC"
            , email= getEmailRandom()
            , passWord ="12345678", confirmPassword = "12345678"
            ,date ="20", month = "July", year = "1991";
    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
    @Test
    public void TC_01_Register() {

        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.cssSelector("input#gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys(fistName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);

        Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));

        //Chon ngay
        day.selectByVisibleText(date);

        //Verify single
        Assert.assertFalse(day.isMultiple());

        //Verify so luong item
        List<WebElement> dayOption = day.getOptions();
        Assert.assertEquals(dayOption.size(),32);

        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(month);

        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(year);

        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Company")).sendKeys(company);
        driver.findElement(By.id("Password")).sendKeys(passWord);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);

        driver.findElement(By.cssSelector("button#register-button")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");

    }

    @Test
    public void TC_02_Login() {

        driver.findElement(By.cssSelector("a.ico-logout")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("a.ico-login")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input.email")).sendKeys(email);
        driver.findElement(By.cssSelector("input.password")).sendKeys(passWord);
        driver.findElement(By.cssSelector("button.login-button")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("a.ico-account")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"),fistName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"),lastName);

        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(),date);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(),month);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(),year);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"),email);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"),company);



    }

    @Test
    public void TC_03_() {

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
        return  "automationtest"+rand.nextInt(99999)+"@gmail.com";
    }

}
