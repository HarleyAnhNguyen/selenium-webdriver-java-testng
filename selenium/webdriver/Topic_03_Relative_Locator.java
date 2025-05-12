package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_03_Relative_Locator {
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
    }
    @Test
    public void TC_01_Relative_Locator() {

        driver.get("https://demo.nopcommerce.com/login");

        //Login Button
        By loginButtonBy = By.cssSelector("button.login-button");
        WebElement loginButtonElement = driver.findElement(By.cssSelector("button.login-button"));

        //Remember Me checkbox
        By remeberMeCheckboxBy = By.id("RememberMe");

        //Forgot Password text
        By forgotPasswordtextBy = By.className("forgot-password");

        //Password textbox
        WebElement passwordTextboxElement= driver.findElement(By.cssSelector("input#Password"));


        WebElement remeberMeTextElement = driver
                .findElement(RelativeLocator.with(By.tagName("label"))
                        .above(loginButtonBy)
                        .toRightOf(remeberMeCheckboxBy)
                        .toLeftOf(forgotPasswordtextBy)
                        .below(passwordTextboxElement)
                        .near(forgotPasswordtextBy));

        System.out.println(remeberMeTextElement.getText());

//        RelativeLocator.with(By.tagName("label"))
//                .above(loginButtonBy)
//                .toRightOf(remeberMeCheckboxBy);
//        RelativeLocator.with(By.tagName("label"))
//                .above(loginButtonElement)
//                .toRightOf(remeberMeCheckboxBy);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
