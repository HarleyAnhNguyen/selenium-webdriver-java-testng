package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_26_UploadFile {
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



    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        action = new Actions(driver);
        action.moveByOffset(0,0).perform();
    }
    @Test
    public void TC_01_Single_File() throws InterruptedException {

        //moi lan load 1 file
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By inputBy = By.cssSelector("input[type='file']");

        driver.findElement(inputBy).sendKeys(vuongGiaPath);
        Thread.sleep(5000);

        driver.findElement(inputBy).sendKeys(doAnPath);
        Thread.sleep(5000);

        driver.findElement(inputBy).sendKeys(boThuiPath);
        Thread.sleep(5000);

        //Verify file dươc load lên
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + vuongGia + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + doAn + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + boThui + "']")).isDisplayed());

        //Click upload File
        List<WebElement> startBtns = driver.findElements(By.cssSelector("table button.start"));

        for (WebElement startBtn: startBtns){
            startBtn.click();
            Thread.sleep(2000);
        }

        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + vuongGia + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + doAn + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + boThui + "']")).isDisplayed());





    }

    @Test
    public void TC_02_Multiple_File() throws InterruptedException {

        //Up nhieu file cung 1 luc

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By inputBy = By.cssSelector("input[type='file']");

        driver.findElement(inputBy).sendKeys(vuongGiaPath + "\n" + doAnPath + "\n" + boThuiPath);
        Thread.sleep(5000);

        //Verify file dươc load lên
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + vuongGia + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + doAn + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + boThui + "']")).isDisplayed());

        //Click upload File
        List<WebElement> startBtns = driver.findElements(By.cssSelector("table button.start"));

        for (WebElement startBtn: startBtns){
            startBtn.click();
            Thread.sleep(2000);
        }

        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + vuongGia + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + doAn + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + boThui + "']")).isDisplayed());

    }

    @Test
    public void TC_03_() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
