package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_10_Loop {
    WebDriver driver;
    String fistName="Automation", lastName = "Test"
            , company = "ABC"
            , email
            , passWord ="12345678", confirmPassword = "12345678"
            ,date ="20", month = "July", year = "1991"
            ,projectPath = System.getProperty("user.dir");
    Properties prop = new Properties();
    String path = projectPath +"\\dataTest\\user.properties";
    FileOutputStream fr;




    @BeforeClass
    public void beforeClass() throws FileNotFoundException {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:8086/");
        fr = new FileOutputStream(path);
    }
    @Test(invocationCount = 5)
    public void TC_01_Register() throws IOException {
        email= getEmailRandom();


        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.cssSelector("input#gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys(fistName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);



        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Company")).sendKeys(company);
        driver.findElement(By.id("Password")).sendKeys(passWord);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);

        driver.findElement(By.cssSelector("button#register-button")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");
        System.out.println(email);
        System.out.println(passWord);

        driver.findElement(By.cssSelector("a.ico-logout")).click();
        // Set the properties values
        prop.setProperty("email", email);
        prop.setProperty("password", passWord);

        // Save properties with a comment
        prop.store(fr, null);
        System.out.println("Config saved.");

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
