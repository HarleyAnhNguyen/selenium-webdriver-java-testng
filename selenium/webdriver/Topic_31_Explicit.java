package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_31_Explicit {
    WebDriver driver;
    Actions action;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        action = new Actions(driver);
        action.moveByOffset(0,0).perform();
    }
    @Test
    public void TC_01_() {
        //Wait cho element ko hiển thị ko còn trong HTML (trước đó là có tồn tại)
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        //Wait cho element ko hiển thị (còn/ko còn trong HTML)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        //Wait cho element ko hiển thị (còn/ko còn trong HTML)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));

        //Wait cho element được phép click (button/link/radio/checkbox...)
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

        //Wait cho URL của page tuyệt đối
        explicitWait.until(ExpectedConditions.urlToBe("https://automationfc.vn/"));

        //Wait cho URL của page tương đối
        explicitWait.until(ExpectedConditions.urlContains("automationfc"));

        //Wait cho URL của page thỏa mãn biểu thức (Regex)
        explicitWait.until(ExpectedConditions.urlMatches("*#$^....."));

        //Wait cho 1 đoạn JS trả về kiểu string
        explicitWait.until(ExpectedConditions.jsReturnsValue("return arguments[0].validationMessage;"));

        //Wait cho Alert có xuất hiện trong HTML
        explicitWait.until(ExpectedConditions.alertIsPresent());

        //Wait cho Title của page tuyệt đối
        explicitWait.until(ExpectedConditions.titleIs("Fullstack Selenium in Java"));

        //Wait cho Title của page tuyệt đối
        explicitWait.until(ExpectedConditions.titleContains("Fullstack Selenium in Java"));

        //Wait cho Thỏa mãn cả 2 điều kiện (AND)
        explicitWait.until(ExpectedConditions.and(
                ExpectedConditions.urlContains(""),ExpectedConditions.titleContains("")));

        //Wait cho Thỏa mãn 1 trong 2 điều kiện (OR)
        explicitWait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains(""),ExpectedConditions.titleContains("")));

        //Wait cho Element có xuất hện trong HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        //Wait cho 1 element có thuộc tính chứa 1 giá trị nào đó
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector(""),"class","email"));

        //Wait cho 1 element có thuộc tính chứa 1 giá trị nào đó
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector(""),"class","email"));

        //Wait cho 1 element có thuộc tính ko được null
        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector("")),"class"));

        //Wait cho 1 element có thuộc tính ở trong DOM bằng giá trị nào đó
        explicitWait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.cssSelector("")),"baseURI","https://automationfc.github.io/dynamic-loading/"));

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
