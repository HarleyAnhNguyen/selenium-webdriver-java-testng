package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_27_Wait_Element {
    WebDriver driver;
    Actions action;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        action = new Actions(driver);
        action.moveByOffset(0,0).perform();
    }
    @Test
    public void TC_01_Visibale() {

        driver.get("https://www.facebook.com/");

        // Element có trong UI và co trong HTML
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

    }

    @Test
    public void TC_02_Invisible() throws InterruptedException {


        //ko có trên UI nhưng có trong cây HTML
        driver.get("https://www.facebook.com/r.php?locale=en_US&display=page");
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input[name ='reg_email_confirmation__']")));

        //ko có trên UI cũng ko có trong cây HTML
        driver.get("https://www.facebook.com/login/identify/");

        driver.findElement(By.cssSelector("div[role = 'banner'] svg")).click();


        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Email or phone number']/following-sibling::input")));
        driver.findElement(By.cssSelector("div[aria-label='Close'] i")).click();


        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Email or phone number']/following-sibling::input")));




    }

    @Test
    public void TC_03_Presence() throws InterruptedException {
        driver.get("https://www.facebook.com/r.php?locale=en_US&display=page");


        // 1. Element co trong UI có trong HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name ='reg_email__']")));

        Thread.sleep(3000);

        //2. Element ko co trong UI, có trong HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name ='reg_email_confirmation__']")));

        Thread.sleep(3000);


    }

    @Test
    public void TC_04_Staleness() throws InterruptedException {
        driver.get("https://www.facebook.com/login/identify/");

        //Click mở ra popup ra
        driver.findElement(By.cssSelector("div[role = 'banner'] svg")).click();
        Thread.sleep(3000);

        WebElement emailElement  = driver.findElement(By.xpath("//span[text()='Email or phone number']/following-sibling::input"));

        explicitWait.until(ExpectedConditions.visibilityOf(emailElement));
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("div[aria-label='Close'] i")).click();

        //3. Element ko co trong UI, ko có trong HTML
        explicitWait.until(ExpectedConditions.stalenessOf(emailElement));
        Thread.sleep(3000);


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
