package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_16_Authentication_Alert {
    WebDriver driver;
    WebDriverWait explicitWait;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    String userName = "admin";
    String passWord = "admin";


    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Authentication_Alert() throws InterruptedException {
        //C1 su dung by pass qua link: http/https// + username + password + @url
        driver.get("http://" + userName + ":" + passWord +"@"+ "the-internet.herokuapp.com/basic_auth");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(),"Congratulations! You must have the proper credentials.");

    }

    @Test
    public void TC_02_Authentication_Navigate()  {

        driver.get("http://the-internet.herokuapp.com/");

        String basicAuthLink = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
        driver.get(getAutjenticationUrl(basicAuthLink,userName,passWord));

        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(),"Congratulations! You must have the proper credentials.");

    }

    @Test
    public void TC_03_Prompt() {


    }

    public String getAutjenticationUrl(String link, String username, String password){
        String[] linkArray = link.split("//");
        link = linkArray[0] +"//" + userName + ":" + passWord +"@"+linkArray[1];
        return link;
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
