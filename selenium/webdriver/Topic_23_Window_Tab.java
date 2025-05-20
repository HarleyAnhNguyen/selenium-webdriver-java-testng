package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Topic_23_Window_Tab {
    WebDriver driver;
    WebDriverWait explicitWait;
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
    public void TC_01_GitHub() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        //lay ra ID cua tab hoac window ddang active tai page do driver.getWindowHandle();
        String githubWindowID = driver.getWindowHandle();
        System.out.println("GitHub Window ID:" + githubWindowID);
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Page Url: " + driver.getCurrentUrl());

        //click vao GOOGLE => no se bat len 1 tab moi va tu nhay qua
        //nhung driver ko tu nhay- no van o tab cu
        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        Thread.sleep(3000);

        System.out.println("GitHub Window ID:" + githubWindowID);

        switchToWindowByID(githubWindowID);
        Thread.sleep(5000);

        String googleWindowID = driver.getWindowHandle();
        System.out.println("GitHub Window ID:" + googleWindowID);
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Page Url: " + driver.getCurrentUrl());

        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Harley Davision");
        Thread.sleep(3000);

        //switch ve GitHub
        switchToWindowByID(googleWindowID);
        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        Thread.sleep(3000);

        //Lay het toanf bo ID cua Win dau
        Set<String> allWindowIDs = driver.getWindowHandles();

        //dung vong for de duyet qua
        for (String id :allWindowIDs){
            driver.switchTo().window(id);
            Thread.sleep(3000);
            //ktra title
            if (driver.getTitle().equals("Facebook – log in or sign up"))
                break;
        }

       for (String id :allWindowIDs){
            if (!id.equals(githubWindowID)){
                driver.switchTo().window(id);
                driver.close();
                Thread.sleep(3000);
                driver.switchTo().window(githubWindowID);
                }
        }

        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Page Url: " + driver.getCurrentUrl());

    }

    private void switchToWindowByID(String WindowID) {
        //lay ra het ID cua window/tab hien tai
        Set<String> AllWindowIDs = driver.getWindowHandles();


        //dung vong lap de lay ra tung ID 1
        for (String id : AllWindowIDs){
            System.out.println(id);
            //ktra ID nao khac voi ID dang dung thid switch qua
            if(!id.equals(WindowID)){
                driver.switchTo().window(id);
            }
        }
    }

    @Test
    public void TC_02_Techpanda() throws InterruptedException {
        driver.get("http://live.techpanda.org/");

        //Click vao moblie tab
        driver.findElement(By.xpath("//a[text() = 'Mobile']")).click();
        Thread.sleep(3000);

        //Add sp Sony Xperia vao Compare (Add to Compare)
        driver.findElement(By.xpath("//a[@title='Sony Xperia']/ancestor::div[@class='product-info']//a[@class='link-compare']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.col-main li.success-msg span")).getText()
                ,"The product Sony Xperia has been added to comparison list.");
        Thread.sleep(3000);

        //Add sp Sony Xperia vao Compare (Add to Compare)
        driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/ancestor::div[@class='product-info']//a[@class='link-compare']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.col-main li.success-msg span")).getText()
                ,"The product Samsung Galaxy has been added to comparison list.");
        Thread.sleep(3000);
        // Click vao Compare
        driver.findElement(By.xpath("//span[text()='Compare']")).click();
        Thread.sleep(3000);

        //Switch qua cua so moi
        String mobileTabWindowID = driver.getWindowHandle();
        switchToWindowByID(mobileTabWindowID);

        // verify title cua cua so
        Assert.assertEquals(driver.getTitle(),"Products Comparison List - Magento Commerce");

        //Close tab va chuyen ve Parent Window
        String compareWindowID = driver.getWindowHandle();
        driver.close();
        switchToWindowByID(compareWindowID);
        Thread.sleep(3000);

        //Click on Clear All
        driver.findElement(By.xpath("//a[text()='Clear All']")).click();
        Thread.sleep(3000);

        //accept arlert
        Alert alert = driver.switchTo().alert();
        //Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.col-main li.success-msg span")).getText()
                ,"The comparison list was cleared.");


    }

    @Test
    public void TC_03_Dictionary_Cambridge() throws InterruptedException {
        driver.get("https://dictionary.cambridge.org/vi/");

        //Click vao Dang Nhap
        driver.findElement(By.cssSelector("span.cdo-login-button")).click();
        Thread.sleep(3000);

        //Switch qua cua so moi
        String mainWindowID = driver.getWindowHandle();
        switchToWindowByID(mainWindowID);
        Thread.sleep(3000);

        //click on Log in
        driver.findElement(By.cssSelector("form#gigya-login-form input.gigya-input-submit")).click();
        Thread.sleep(3000);

        //Ktra error message
        Assert.assertEquals(driver.findElement(By.xpath("//form[@id='gigya-login-form']//input[@name='username']/following-sibling::span")).getText()
                ,"This field is required");

        Assert.assertEquals(driver.findElement(By.xpath("//form[@id='gigya-login-form']//input[@name='username']/following-sibling::span")).getText()
                ,"This field is required");

        //Close Login window, switch ve trang truoc
        String loginWindowID = driver.getWindowHandle();
        driver.close();
        switchToWindowByID(loginWindowID);
        Thread.sleep(3000);

        //Nhap tu khoa vo search
        driver.findElement(By.cssSelector("input#searchword")).sendKeys("target");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("button[title='Tìm kiếm']")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.di-title span.headword span")).getText()
                ,"target");


    }

    @Test
    public void TC_04_Selenium_4X() throws InterruptedException {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//a[text() = 'Mobile']")).click();
        Thread.sleep(3000);
        System.out.println("Window ID:" + driver.getWindowHandle());
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Page Url: " + driver.getCurrentUrl());

        driver.switchTo().newWindow(WindowType.TAB).get("http://live.techpanda.org/index.php/customer/account/login/");//drive se nhay qua window moi
        System.out.println("Window ID:" + driver.getWindowHandle());
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Page Url: " + driver.getCurrentUrl());


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
