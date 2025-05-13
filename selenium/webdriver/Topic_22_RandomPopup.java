package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_22_RandomPopup {
    WebDriver driver;
    Actions action;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        action = new Actions(driver);
        action.moveByOffset(0,0).perform();
    }
    @Test
    public void TC_01_javacodegeeks() throws InterruptedException {
        driver.get("https://www.javacodegeeks.com/");
        By newletterPopup = By.xpath("//div[@data-title ='Newsletter-Books Anime Brief' and not(contains(@style,'display:none'))]");

        //Hien thi close,
        if(driver.findElements(newletterPopup).size()>0
                && driver.findElements(newletterPopup).get(0).isDisplayed()){
            System.out.println("-----------------GO TO IF--------------");
            driver.findElement(By.xpath("//div[@data-title ='Newsletter-Books Anime Brief' " +
                    "and not(contains(@style,'display:none'))]" +
                    "//div[contains(@class,'lepopup-fadeIn')]" +
                    "//a[@onclick='return lepopup_close();']")).click();
            Thread.sleep(3000);
        }
        //ko hien thi thi action tiep
        System.out.println("-----------------DONT GO TO IF--------------");
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile Testing Explained");
        driver.findElement(By.cssSelector("form#search span.tie-icon-search")).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("header>h1.page-title")).isDisplayed());



    }

    @Test
    public void TC_02_vnkedu() throws InterruptedException {
        driver.get("https://vnk.edu.vn/");
        By marketingPopup = By.cssSelector("div.popmake-content");

        if(driver.findElements(marketingPopup).size()>0
                && driver.findElements(marketingPopup).get(0).isDisplayed()){
            System.out.println("-----------------GO TO IF--------------");
            driver.findElement(By.cssSelector("button.pum-close")).click();
            Thread.sleep(3000);
        }
        //ko hien thi thi action tiep
        System.out.println("-----------------DONT GO TO IF--------------");
        driver.findElement(By.xpath("//li[contains(@id,'mega-menu-item')]/a[text()='Liên hệ']")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("div.title-content>span.hot-line")).isDisplayed());

    }

    @Test
    public void TC_03_dehieu() throws InterruptedException {
        driver.get("https://dehieu.vn/");
        By registerForSale = By.cssSelector("div.modal-dialog>div");

        if(driver.findElements(registerForSale).size()>0
                && driver.findElements(registerForSale).get(0).isDisplayed()){
            System.out.println("-----------------GO TO IF--------------");
            driver.findElement(By.cssSelector("button.close")).click();
            Thread.sleep(3000);
        }
        //ko hien thi thi action tiep
        System.out.println("-----------------DONT GO TO IF--------------");
        driver.findElement(By.cssSelector("a.signin-site-menu")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("div#login-site")).isDisplayed());

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
