package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_05_Assert {
    WebDriver driver;

    @Test
    public void verifyTestNG(){
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        // nhận kiểu dữ liêu boolean (true/false)
        //Khi mong muốn điều kiện trả về đúng thì dùng assertTrue để verify

        Assert.assertTrue(driver.getPageSource().contains("Facebook helps you connect and share with the people in your life."));

        //Khi mong muốn điều kiện trả về sai thì dùng assertFails để verify
        Assert.assertFalse(driver.getPageSource().contains("Create a new account"));

        //Các hàm trả về kiểu dữ liêu boolean
        //Quy tắc: bắt đầu vs tiền tố là isXXX
        driver.findElement(By.id("")).isDisplayed();
        driver.findElement(By.id("")).isEnabled();
        driver.findElement(By.id("")).isSelected();
        new Select(driver.findElement(By.id(""))).isMultiple();

        //Unit test
        Object name =null;
        Assert.assertNull(name);

        Assert.assertNotNull(name);

        //Mong muốn kiểu dữ liệu giống như thực tế (tuyệt đối)
        //Actual = Expected
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
        Assert.assertEquals(driver.findElement(By.id("")).getText(),"Create a new account");


    }
}
