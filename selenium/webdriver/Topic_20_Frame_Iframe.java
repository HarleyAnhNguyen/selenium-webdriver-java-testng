package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_20_Frame_Iframe {
    WebDriver driver;
    Actions action;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        action = new Actions(driver);
        action.moveByOffset(0,0).perform();
    }
    @Test
    public void TC_01_Iframe_FormSite() throws InterruptedException {

        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        driver.findElement(By.cssSelector("div#imageTemplateContainer img")).click();
        Thread.sleep(3000);

        //index
       // driver.switchTo().frame(0);

        //Name or ID
       // driver.switchTo().frame("frame-one85593366");

        //Web element
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe#frame-one85593366")));

        new Select(driver.findElement((By.cssSelector("select#RESULT_RadioButton-2")))).selectByVisibleText("Junior");
        new Select(driver.findElement((By.cssSelector("select#RESULT_RadioButton-3")))).selectByVisibleText("West Dorm");
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        Thread.sleep(3000);

        //B quay lai A
        driver.switchTo().defaultContent();

        //Quay lai A roi thi bam Login
        driver.findElement(By.cssSelector("a.menu-item-login.fs-btn--transparent-kashmir")).click();
        Thread.sleep(300);
        driver.findElement(By.cssSelector("button#login")).click();
        Thread.sleep(300);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(),"Username and password are both required.");


//        //A qua B
//        driver.switchTo().frame(0);
//
//        //C qua B
//        driver.switchTo().frame(0);
//
//        //C ve B
//        driver.switchTo().parentFrame();
//
//        //B ve A
//        driver.switchTo().defaultContent();



    }

    @Test
    public void TC_02_Iframe_ToiDiCodeDao() {

        driver.get("https://toidicodedao.com/");

        driver.switchTo().frame(driver.findElement(By.cssSelector("div.fb_iframe_widget iframe")));

        By followerText = By.xpath("//a[@title='Tôi đi code dạo']/parent::div/following-sibling::div[text()]");

        Assert.assertEquals(driver.findElement(followerText).getText(),"401,238 followers");


    }

    @Test
    public void TC_03_Frame() throws InterruptedException {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");

        driver.switchTo().frame("login_page");

        driver.findElement(By.cssSelector("input.form-control")).sendKeys("automationfc");
        Thread.sleep(300);
        driver.findElement(By.cssSelector("a.login-btn")).click();
        Thread.sleep(7000);

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//input[@id='keyboard']")).sendKeys("123456");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a#loginBtn")).click();
        Thread.sleep(300);


    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }

}
