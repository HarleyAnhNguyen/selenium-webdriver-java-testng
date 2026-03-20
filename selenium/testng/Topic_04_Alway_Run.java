package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Alway_Run {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.get("https://didongviet.vn/dien-thoai/samsung-galaxy-s25-5g-512gb-bhdt.html");

        //Hành động bị failed ở step này
        Assert.assertTrue(false);

    }

    @Test
    public void TC_01(){
        System.out.println("Run groups TC01");
    }

    @Test
    public void TC_02(){
        System.out.println("Run groups TC02");
    }
    @Test
    public void TC_03(){
        System.out.println("Run groups TC03");
    }

    @Test
    public void TC_04(){
        System.out.println("Run groups TC04");
    }

    @Test
    public void TC_05(){
        System.out.println("Run groups TC05");
    }

    @Test
    public void TC_06(){
        System.out.println("Run groups TC06");
    }
    @AfterClass (alwaysRun = true)
    public void afterClass(){
        driver.quit();
    }
}
