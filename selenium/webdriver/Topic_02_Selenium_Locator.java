package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");
    }
    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("FirstName")).sendKeys("Keane");

    }

    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthDay"));
    }

    @Test
    public void TC_04_Tagname() {
        driver.findElements((By.tagName("input")));
    }

    @Test
    public void TC_05_LinkText() {
        driver.findElement(By.linkText("Shipping & returns"));

    }

    @Test
    public void TC_06_Partial_LinkText() {
        driver.findElement(By.partialLinkText("vendor account"));
    }

    @Test
    public void TC_07_Css() {
// Css with id
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));

        // Css with class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        // Css with name
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        // Css with tagname
        driver.findElements(By.cssSelector("input"));

        // Css with Link
        driver.findElement(By.cssSelector("a[href='/cart']"));

        // Css with Partial Link
        driver.findElement(By.cssSelector("a[href*='addresses']"));

    }

    @Test
    public void TC_08_Xpath() {
        // Xpath with id
        driver.findElement(By.xpath("//input[@id='FirstName']"));
        // Xpath with class
        driver.findElement(By.xpath("//div[@class='page-title']"));

        // Xpath with name
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        // Xpath with tagname
        driver.findElements(By.xpath("//input"));

        // Xpath with Link
        driver.findElement(By.xpath("//a[@href='/cart']"));
        driver.findElement(By.xpath("//a[text()='Shopping cart']"));

        // Xpath with Partial Link
        driver.findElement(By.xpath("//a[contains(@href,'addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
