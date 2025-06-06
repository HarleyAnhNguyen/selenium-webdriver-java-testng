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

import java.time.Duration;
import java.util.List;

public class Topic_28_Wait_FindElement {
    WebDriver driver;
    Actions action;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        driver.manage().window().maximize();

        action = new Actions(driver);
        action.moveByOffset(0,0).perform();
    }
    @Test
    public void TC_01_FindElement() {

        driver.get("https://demo.nopcommerce.com/register");

        //1 - Neu tim thay duy nhat 1 element
        // tra ve dung element do
        //ko cần chờ hết time của implicit
        driver.findElement(By.cssSelector("input#FirstName"));

        //2. nếu tìm thấy nhiều hơn 1 element
        //Chỉ thao ta vơi element đầu tiên
        //Lưu ý là khi lấy locator nên check trước
        driver.findElement(By.cssSelector("input[type='text']"));

        //3. Nếu không tìm thấy element nào
        // mới đầu vào fineElement nhưng ko thấy
        //Tìm lại mà thấy element thì ko cần chờ hết tổng time còn lại
        //Tìm lại mà ko thấy và hết tổng thời gian 13s thì đánh faild tc
        //Show lỗi: NoSuchElementException
        driver.findElement(By.cssSelector("input#RememberMe"));

    }

    @Test
    public void TC_02_FindElements() {

        driver.get("https://demo.nopcommerce.com/register");
        List<WebElement> elements = null;

        //1 - Neu tim thay duy nhat 1 element
        //trả ra đúng 1 element
        elements = driver.findElements(By.cssSelector("input#FirstName"));
        System.out.println(elements.size());

        //2. nếu tìm thấy nhiều hơn 1 element
        //trả ra hết toàn bộ element =4
        elements =driver.findElements(By.cssSelector("input[type='text']"));
        System.out.println(elements.size());

        //3. Nếu không tìm thấy element nào
        // trả về elements =0
        //Tìm lại mà thấy element thì ko cần chờ hết tổng time còn lại
        //Tìm lại mà ko thấy và hết tổng thời gian 13s
        //trả về elements =0, ko đánh failed test case
        elements = driver.findElements(By.cssSelector("input#RememberMe"));
        System.out.println(elements.size());
        Assert.assertEquals(elements.size(),0);

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
