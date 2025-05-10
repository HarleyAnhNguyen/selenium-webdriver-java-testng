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

public class Topic_21_FixedPopup {
    WebDriver driver;
    Actions action;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        action = new Actions(driver);
        action.moveByOffset(0,0).perform();
    }
    @Test
    public void TC_01_NgoaiNgu24h() throws InterruptedException {
        driver.get("https://ngoaingu24h.vn/");

        //click button dang nhap
        driver.findElement(By.xpath("//button[text()= 'Đăng nhập']")).click();
        Thread.sleep(300);

        //switch to Popup
        By loginPopup = By.cssSelector("div.MuiDialog-container>div.MuiPaper-elevation");
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed()); //ktra hien thi co trong HTML

        //nhap usernam & password
        driver.findElement(By.xpath("//input[@autocomplete ='username']")).sendKeys("HarleyTest");
        driver.findElement(By.xpath("//input[@autocomplete ='new-password']")).sendKeys("123456789");
        driver.findElement(By.cssSelector("div.MuiDialog-container button.dialog-button")).click();
        Thread.sleep(300);

        By errorMessage = By.cssSelector("div#notistack-snackbar");
        Assert.assertEquals(driver.findElement(errorMessage).getText(),"Bạn đã nhập sai tài khoản hoặc mật khẩu!");

        //closed popup
        driver.findElement(By.cssSelector("button.close-btn")).click();
        Thread.sleep(300);


        //ktra popup ko hien thi
        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed()); //ktra hien thi co trong HTML

    }

    @Test
    public void TC_02_KynaEnglish() throws InterruptedException {

        driver.get("https://skills.kynaenglish.vn/dang-nhap");

        //ktra popup hien thi
        By loginPopup = By.cssSelector("div.k-popup-account-mb-content");
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        //nhap thong tin vao form
        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456789");
        driver.findElement(By.cssSelector("button#btn-submit-login")).click();
        Thread.sleep(3000);

        By errorMessage = By.cssSelector("div#password-form-login-message");
        Assert.assertEquals(driver.findElement(errorMessage).getText(),"Sai tên đăng nhập hoặc mật khẩu");

    }

    @Test
    public void TC_03_Tiki_NotInDOM() throws InterruptedException {
        driver.get("https://tiki.vn/");

        //Popup 1 - Marketing
        //Hien thi co dinh khi mo site
        //dong lai khi ko con trong HTML
        //khi refresh se hien lai
        By marketingPopup = By.cssSelector("div#VIP_BUNDLE");
        Assert.assertTrue(driver.findElement(marketingPopup).isDisplayed());
        driver.findElement(By.cssSelector("div#VIP_BUNDLE img[alt='close-icon']")).click();
        Thread.sleep(500);

        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();
        Thread.sleep(3000);
        By loginPopup = By.cssSelector("div.ReactModal__Content--after-open");
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.cssSelector("p.login-with-email")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        Thread.sleep(500);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='email']/parent::div/following-sibling::span[1]")).getText(),"Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='email']/parent::div/following-sibling::span[2]")).getText(),"Mật khẩu không được để trống");

        driver.findElement(By.cssSelector("img.close-img")).click();
        Thread.sleep(500);


        Assert.assertEquals(driver.findElements(loginPopup).size(),0);

    }

    @Test
    public void TC_04_Facebook_NotInDOM() {
        driver.get("https://www.facebook.com/");

        driver.findElement(By.cssSelector("a[data-testid ='open-registration-form-button']")).click();
        //Page create new account cua FB ko con la pop-up nua => em ko lam bai nay

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
