package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowser_Commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver = new EdgeDriver();
        driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void TC_01_() throws MalformedURLException {

        driver.get("https://web.facebook.com/");//**
        System.out.println("Window/TabID = "+driver.getWindowHandle());

        driver.close();//đóng 1 tab/window đang active (nhiều tab/window đóng 1 tab)//*
        driver.quit();// đóng hết //**

        // Lấy list Elements
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));//**
        checkboxes.get(1);

        String stringUrl =  driver.getCurrentUrl();//*
        //Lấy ra source HTML/CSS/JS của page
        //Verify 1 cách tương đối
        driver.getPageSource();
        Assert.assertTrue(driver.getPageSource().contains("Facebook helps you connect and share with the people in your life."));

        //Lấy ra Title của Page
        driver.getTitle();

        //Lấy ra ID của cửa sổ/tab hiện tại
        driver.getWindowHandle();//*
        driver.getWindowHandles();//*

        //nếu dùng 1 lần không ần khai báo biến
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");

        // nếu dùng nhiều lần thì nên khai báo biến
        Assert.assertEquals(stringUrl,"https://www.facebook.com/");

        //Cookies - Framework
        driver.manage().getCookies();//*

        //get ra những log của devtool-framework
        driver.manage().logs().get(LogType.DRIVER);//*

        //Apply cho việc tìm element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//**

        //Chờ cho page load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        //Set trước khi dung javaScriptExecutor
        //Inject 1 đoạn code JS vào trong Browser/Element
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        //Selenium 4 mới có
        driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().getPageLoadTimeout();
        driver.manage().timeouts().getScriptTimeout();

        //Chạy full màn hình
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();//**
        driver.manage().window().minimize();

        //Test Responsive (Resolution)
        //Test GUI
        driver.manage().window().setSize(new Dimension(1366,768));
        driver.manage().window().getSize();

        //set cho browser ở vị trí nào so với độ phân giải màn hình (run trên màn hình có kích thước bao nhiêu)
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().getPosition();

        //Điều hướng trang web
        driver.navigate();
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        //thao tác với history của web page (back/forward)
        driver.navigate().to("https://www.facebook.com/");
        driver.navigate().to(new URL("https://www.facebook.com/"));

        //Alert/Window(tab)/Frame(iFrame)//*
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Test");

        //Switch/Handle Window và tab//*
        String homePageWindowID = driver.getWindowHandle();
        driver.switchTo().window(homePageWindowID);

        //Switch/handle frame (iframe)//*
        //Index/ ID(name)/ Element
        driver.switchTo().frame(0);
        driver.switchTo().frame("123456");
        driver.switchTo().frame(driver.findElement(By.id("")));

        // Switch back to before frame
        driver.switchTo().defaultContent();

        //từ frame trong đi ra bên ngoài chứa nó
        driver.switchTo().parentFrame();




    }

    @Test
    public void TC_02_() {

    }

    @Test
    public void TC_03_() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
