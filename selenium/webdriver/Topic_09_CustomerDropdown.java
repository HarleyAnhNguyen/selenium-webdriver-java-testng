package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.SortedSet;
import java.util.concurrent.TimeUnit;

public class Topic_09_CustomerDropdown {
    WebDriver driver;

    //Wait tuong minh: trang thai cu the cho element
    //Visible/Invisible/Presence/Number /Clickable/...
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_() {

        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        sleepInSeconds(3);
        //1. click vào thẻ để nó xổ ra
        driver.findElement(By.cssSelector("span#number-button")).click();

        // 2.1 nó xổ ra chứa hết tất cả item
        //2.2 Nó xổ ra nhưng chỉ chứa 1 phần và đang lòa thêm
       explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));

        List<WebElement> allItems = driver.findElements(By.cssSelector("ul#number-menu div"));

        for (WebElement item :allItems){
            String textitem = item.getText();
            System.out.println("Text item:" + textitem);
            if(textitem.equals("8")){
                item.click();
                break;//9-19 ko ktra
            }
        }

        // Ngàn/ Triệu
        // 3.1 Nếu như item cần chọn có hiện thì click
        // 3.2 Nếu như item cần chọn nằm bên dưới thì 1 số trường hợp cần scroll xuống để hiện thị rồi mới chọn
        // 4 trước khi chọn thì kiểm tra nếu như text của item bằng với item cần chọn thì click




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

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
