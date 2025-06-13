package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class Topic_31_Explicit_Exc {
    WebDriver driver;
    Actions action;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    String uploadForderPath = projectPath + File.separator + "uploadFiles" + File.separator;
    String vuongGia ="vuonggia.png";
    String doAn ="Do an.JPEG";
    String boThui ="BoThui.jpg";

    String vuongGiaPath = uploadForderPath + vuongGia;
    String doAnPath = uploadForderPath + doAn;
    String boThuiPath = uploadForderPath + boThui;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        action = new Actions(driver);
        action.moveByOffset(0,0).perform();
    }
    @Test
    public void TC_01_Less_Than(){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.xpath("//button[text() ='Start']")).click();

        //Điều kiện wait
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }

    @Test
    public void TC_02_Equal(){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.xpath("//button[text() ='Start']")).click();

        //Điều kiện wait
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }

    @Test
    public void TC_03_More_Than(){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.xpath("//button[text() ='Start']")).click();

        //Điều kiện wait
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }

    @Test
    public void TC_04() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.xpath("//button[text() ='Start']")).click();

        //Visible (dành cho 1 element sau được xuất hiện)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));

        //Invisible (dành cho 1 element sắp biến mất/ kì vọng biến mất đi)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));

        //Text
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div#finish>h4"),"Hello World!"));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }

    @Test
    public void TC_04_Calendar() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        //Wait and verify Calendar element is display
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1"))).isDisplayed());

        //Wait and verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(
                By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"No Selected Dates to display.")));

        //Wait and click elemet
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/a[text()='13']"))).click();

        //Wait and verify  cho ajax loading invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector("div[id$='RadCalendar1']>div.raDiv"))));

        //Wait and verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(
                By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"Friday, June 13, 2025")));

    }

    @Test
    public void TC_05_Gofile() throws InterruptedException {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://gofile.io/?t=uploadFiles");



        //Wait and verify  cho loading invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.cssSelector("main#index_main>div#index_loader"))));

        //Wait and click element
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/myfiles']>button"))).click();

        //Wait and verify  cho loading invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.cssSelector("div#filemanager_loading"))));

        Thread.sleep(5000);
        By inputBy = By.cssSelector("input[type='file']");

        //Upload file
        driver.findElement(inputBy).sendKeys(vuongGiaPath + "\n" + doAnPath + "\n" + boThuiPath);

        //Wait và Kiem tra loading tung file
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.xpath("//span[text()='"+boThui+"']/ancestor::div[@class='file-item']//div[@class='progress-container']/div/div"))));
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.xpath("//span[text()='"+boThui+"']/ancestor::div[@class='file-item']//div[@class='processing-indicator']//span[text()='Server processing file...']"))));

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.xpath("//span[text()='"+doAn+"']/ancestor::div[@class='file-item']//div[@class='progress-container']/div/div"))));
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.xpath("//span[text()='"+doAn+"']/ancestor::div[@class='file-item']//div[@class='processing-indicator']//span[text()='Server processing file...']"))));

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.xpath("//span[text()='"+vuongGia+"']/ancestor::div[@class='file-item']//div[@class='progress-container']/div/div"))));
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.xpath("//span[text()='"+vuongGia+"']/ancestor::div[@class='file-item']//div[@class='processing-indicator']//span[text()='Server processing file...']"))));

        //Wait và kiem tra page hoàn thanh loading và load lại page
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.cssSelector("div#filemanager_loading"))));

        //Wait và kiểm tra ảnh được load thành công
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("//a[text()='"+boThui+"']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("//a[text()='"+doAn+"']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("//a[text()='"+vuongGia+"']"))).isDisplayed());

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
