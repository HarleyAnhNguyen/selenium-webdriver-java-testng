package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_24_Shadow_DOM {
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
    public void TC_01_GitHub() {
        driver.get("https://automationfc.github.io/shadow-dom/");
        //lay element cha chua shadow host 1
        //driver.findElement(By.xpath("//a[text()='scroll.html']"));
        WebElement shadowHostParent = driver.findElement(By.cssSelector("div#shadow_host"));

        //Tu shadow host => shadow root
        SearchContext firstShadow = shadowHostParent.getShadowRoot();

        // tu shadow root lay dc element ben trong
        Assert.assertTrue(firstShadow.findElement(By.cssSelector("input[type='text']")).isDisplayed());
        Assert.assertEquals(firstShadow.findElement(By.cssSelector("span.info")).getText(),"some text");

        //lay element cha chua shadow host 2
        WebElement firstshadowHostParent =firstShadow.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext secondShadow = firstshadowHostParent.getShadowRoot();

        Assert.assertEquals(secondShadow.findElement(By.cssSelector("div#nested_shadow_content div")).getText(),"nested text");

        Assert.assertEquals(firstShadow.findElement(By.cssSelector("a[href='scroll.html']")).getText(),"nested scroll.html");

    }

    @Test
    public void TC_02_Book_Pwakit() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");

        WebElement shadowParent = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
        SearchContext bookShadow = shadowParent.getShadowRoot();

        WebElement secondShadowParent= bookShadow.findElement(By.cssSelector("book-input-decorator"));
        SearchContext inputShadow = secondShadowParent.getShadowRoot();

        Thread.sleep(3000);

        bookShadow.findElement(By.cssSelector("input[type='search']")).sendKeys("Harry Potter");
        Thread.sleep(3000);

        inputShadow.findElement(By.cssSelector("div.icon")).click();
        Thread.sleep(3000);

        WebElement thirdShadowParent= bookShadow.findElement(By.cssSelector("book-explore"));
        SearchContext exploreShadow = thirdShadowParent.getShadowRoot();

        WebElement forthShadowParent= exploreShadow.findElement(By.cssSelector("ul>li:nth-of-type(1)>book-item"));
        SearchContext resultShadow = forthShadowParent.getShadowRoot();

        Assert.assertEquals(resultShadow.findElement(By.cssSelector("h2.title")).getText(),"The Ultimate Harry Potter and Philosophy");


    }

    @Test
    public void TC_03_() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
