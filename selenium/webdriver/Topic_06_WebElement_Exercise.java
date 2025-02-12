package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_WebElement_Exercise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Displayed() {

        driver.get("https://automationfc.github.io/basic-form/index.html");

        if(driver.findElement(By.cssSelector("input#mail")).isDisplayed()){
            driver.findElement(By.cssSelector("input#mail")).sendKeys("Automation Testing");
            System.out.println("Email is displayed");

        }else{
            System.out.println("Email is not displayed");
        }

        if(driver.findElement(By.cssSelector("input#under_18")).isDisplayed()){
            driver.findElement(By.cssSelector("input#under_18")).click();
            System.out.println("Under 18 is displayed");

        }else{
            System.out.println("Under 18 is not displayed");
        }

        if(driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()){
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("Automation Testing");
            System.out.println("Education is displayed");

        }else{
            System.out.println("Education is not displayed");
        }

        if(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()){
            System.out.println("Name: User5 is displayed");

        }else{
            System.out.println("Name: User5 is not displayed");
        }


        Assert.assertTrue(driver.findElement(By.cssSelector("input#mail")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("textarea#edu")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed());

    }

    @Test
    public void TC_02_Enabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        //Enable Element

        if(driver.findElement(By.cssSelector("input#mail")).isEnabled()){
            System.out.println("Email is Enabled");

        }else{
            System.out.println("Email is Disabled");
        }

        if(driver.findElement(By.cssSelector("input#under_18")).isEnabled()){
            System.out.println("Under 18 is Enabled");

        }else{
            System.out.println("Under 18 is Disabled");
        }

        if(driver.findElement(By.cssSelector("textarea#edu")).isEnabled()){
            System.out.println("Education is Enabled");

        }else{
            System.out.println("Education is Disabled");
        }


        if(driver.findElement(By.xpath("//select[@name='user_job1']")).isEnabled()
        & driver.findElement(By.xpath("//select[@name='user_job2']")).isEnabled()){

            System.out.println("Job Role 01 and Job Role 02 is Enabled");

        }else{
            System.out.println("Job Role 01 and Job Role 02 is Disabled");
        }

        if(driver.findElement(By.cssSelector("input#development")).isEnabled()){

            System.out.println("Development checkbox is Enabled");

        }else{
            System.out.println("Development checkbox is Disabled");
        }

        if(driver.findElement(By.cssSelector("input#slider-1")).isEnabled()){

            System.out.println("Slider 01 checkbox is Enabled");

        }else{
            System.out.println("Slider 01 checkbox is Disabled");
        }

        //Disable Element

        if(driver.findElement(By.cssSelector("input#disable_password")).isEnabled()){
            System.out.println("Password is Enabled");

        }else{
            System.out.println("Password is Disabled");
        }

        if(driver.findElement(By.cssSelector("input#radio-disabled")).isEnabled()){
            System.out.println("Radio button is Enabled");

        }else{
            System.out.println("Radio button is Disabled");
        }

        if(driver.findElement(By.cssSelector("textarea#bio")).isEnabled()){
            System.out.println("Biography is Enabled");

        }else{
            System.out.println("Biography is Disabled");
        }
    }

    @Test
    public void TC_03_Selected() {

        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.cssSelector("input#under_18")).click();
        driver.findElement(By.cssSelector("input#java")).click();

        if(driver.findElement(By.cssSelector("input#under_18")).isSelected()){
            System.out.println("Under 18 is Selected");

        }else{
            System.out.println("Under 18 is de-selected");
        }


        if(driver.findElement(By.cssSelector("input#java")).isSelected()){
            System.out.println("Java is Selected");

        }else{
            System.out.println("Java is de-selected");
        }

        driver.findElement(By.cssSelector("input#java")).click();

        if(driver.findElement(By.cssSelector("input#java")).isSelected()){
            System.out.println("Java is Selected");

        }else{
            System.out.println("Java is de-selected");
        }

    }

    @Test
    public void TC_04_MailChimp() {

        driver.get("https://login.mailchimp.com/signup/");

        driver.findElement(By.cssSelector("input#email")).sendKeys("alohaptit@gmail.com");

        driver.findElement(By.xpath("//div[@class='signup-wrap lastUnit mc-login-content ']")).click();

        sleepInSeconds(5);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#new_username")).getAttribute("value").toString(),"alohaptit@gmail.com");



        driver.findElement(By.cssSelector("input#new_password")).sendKeys("4");
        sleepInSeconds(3);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

        driver.findElement(By.cssSelector("input#new_password")).sendKeys("b");
        sleepInSeconds(3);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

        driver.findElement(By.cssSelector("input#new_password")).sendKeys("A");
        sleepInSeconds(3);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

        driver.findElement(By.cssSelector("input#new_password")).sendKeys("@");
        sleepInSeconds(3);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

        driver.findElement(By.cssSelector("input#new_password")).sendKeys("34567");
        sleepInSeconds(3);

        Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
