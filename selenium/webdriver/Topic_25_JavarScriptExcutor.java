package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_25_JavarScriptExcutor {
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    WebDriverWait explicitWait;
    Actions action;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    Random random;
    String email;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       // driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        jsExecutor = (JavascriptExecutor) driver;
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));
        email = "automation" + new Random().nextInt(9999) +"@gmail.com";

        action = new Actions(driver);
        action.moveByOffset(0,0).perform();
    }
    @Test
    public void TC_01_Panda() throws InterruptedException {
        jsExecutor.executeScript("window.location = 'http://live.techpanda.org/'");
        Thread.sleep(5000);

        String domainPanda = (String) jsExecutor.executeScript("return document.domain;");
        Assert.assertEquals(domainPanda,"live.techpanda.org");

        String urlPanda = (String)jsExecutor.executeScript("return document.URL;");
        Assert.assertEquals(urlPanda,"https://live.techpanda.org/");

        jsExecutor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[text()='Mobile']")));
        Thread.sleep(3000);
//        explicitWait.until(ExpectedConditions.elementToBeClickable
//                (By.xpath("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button")));

        jsExecutor.executeScript("arguments[0].click();",driver.findElement(
                By.xpath("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button")));
        Thread.sleep(3000);

        String sucessSamSungtText = (String) jsExecutor.executeScript("return document.documentElement.innerText;");
        Assert.assertTrue(sucessSamSungtText.contains("Samsung Galaxy was added to your shopping cart."));

        jsExecutor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[text()='Customer Service']")));
        Thread.sleep(3000);

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.cssSelector("input#newsletter")));
        Thread.sleep(3000);

        jsExecutor.executeScript("arguments[0].setAttribute('value', '"+email+"')", driver.findElement(By.cssSelector("input#newsletter")));

        jsExecutor.executeScript("arguments[0].click();",driver.findElement(By.cssSelector("button[title='Subscribe']")));
        Thread.sleep(10000);

        String sucessSubscribe = (String) jsExecutor.executeScript("return document.documentElement.innerText;");
        Assert.assertTrue(sucessSubscribe.contains("Thank you for your subscription."));
        Thread.sleep(3000);

        jsExecutor.executeScript("window.location = 'https://www.facebook.com/'");
        Thread.sleep(3000);
        String domainFaceBook = (String) jsExecutor.executeScript("return document.domain;");
        Assert.assertEquals(domainFaceBook,"web.facebook.com");


    }

    @Test
    public void TC_02_Warranty() {
        driver.get("https://warranty.rode.com/");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        //Empty
        loginButton.click();

        String emptyEmailMess = getElementValidationMessage("//input[@id='email']");
        Assert.assertEquals(emptyEmailMess,"Please fill out this field.");

        //Email invalid
        String invalidEmail = "abc435@fff.";
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(invalidEmail);
        loginButton.click();

        String invalidEmailMess = getElementValidationMessage("//input[@id='email']");

        if (driver.toString().contains("ChromeDriver")){
            Assert.assertEquals(invalidEmailMess,"Please include an '@' in the email address. '" + invalidEmail + "' is missing an '@'.");
        } else {
            Assert.assertEquals(invalidEmailMess,"Please enter an email address.");
        }

        //Email valid
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        loginButton.click();
        String passwordEmailMess = getElementValidationMessage("//input[@id='password']");
        Assert.assertEquals(emptyEmailMess,"Please fill out this field.");

    }

    @Test
    public void TC_03_() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public Object executeForBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText() {
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor.executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
        sleepInSecond(3);
    }

    public String getElementTextByJS(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].textContent;", getElement(locator));
    }

    public void scrollToElementOnTop(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
        return status;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }

}
