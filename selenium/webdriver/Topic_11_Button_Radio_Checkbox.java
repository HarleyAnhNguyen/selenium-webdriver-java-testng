package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Topic_11_Button_Radio_Checkbox {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Egov_Button() {

        driver.get("https://egov.danang.gov.vn/reg");
        WebElement registerButton = driver.findElement(By.cssSelector("input.egov-button"));
        //verify button bị disable khi chua click vao checkbox
        Assert.assertFalse(registerButton.isEnabled());

        driver.findElement(By.cssSelector("input#chinhSach")).click();
        sleepInSeconds(3);
        //verify button duoc enable sau khi click vao checkbox
        Assert.assertTrue(registerButton.isEnabled());

        //lay ra ma mau nen cua button
        String rgbRegisterBackgroundColor = registerButton.getCssValue("background-color");
        System.out.println("Background color RGB = " +rgbRegisterBackgroundColor);
        //convert tu kieu String (ma RGB) qua kieu color
        Color registerBackgroundColour = Color.fromString(rgbRegisterBackgroundColor);
        //Convert qua kieu Hexa

        String hexaRegisterBackgroundColor = registerBackgroundColour.asHex();
        System.out.println("Background color Hexa = " +hexaRegisterBackgroundColor);

        Assert.assertEquals(hexaRegisterBackgroundColor, "#ef5a00");

    }

    @Test
    public void TC_02_Fahasa_Button() {

        driver.get("https://www.fahasa.com/customer/account/create");

        //Chuyen qua Dang Nhap
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        sleepInSeconds(3);

        WebElement loginButton = driver.findElement(By.cssSelector("button.fhs-btn-login"));
        //Verify Dang Nhap button disable
        Assert.assertFalse(loginButton.isEnabled());

//        String rgbLoginBackgroundColor = loginButton.getCssValue("background");
//        System.out.println("Background color RGB = " +rgbLoginBackgroundColor);
//        //convert tu kieu String (ma RGB) qua kieu color
//        Color loginBackgroundColour = Color.fromString(rgbLoginBackgroundColor);
//        //Convert qua kieu Hexa
//
//        String hexaLoginBackgroundColor = loginBackgroundColour.asHex();
//        System.out.println("Background color Hexa = " +hexaLoginBackgroundColor);
//
//        Assert.assertEquals(hexaLoginBackgroundColor, "rgb(224,224,224)");

        //Verify background cua login button luc disable
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#000000");

        // Nhap email password
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("alohatest@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");

        //Verify login button enable
        Assert.assertTrue(loginButton.isEnabled());

        //Verify background cua login button luc enable
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex(),"#c92127");
    }

    @Test
    public void TC_03_() {

    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }



}
