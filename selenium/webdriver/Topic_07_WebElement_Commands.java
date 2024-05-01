package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_07_WebElement_Commands {
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
    public void TC_01_() {
        //Tìm và trả về 1 element và chưa tương tác gì
        driver.findElement(By.id(""));

        //Tìm và tương tác lên
        driver.findElement(By.id("")).click();
        driver.findElement(By.id("")).sendKeys("");

        //Tìm và lưu bào 1 biến WebElement(chưa tương tác gì)
        WebElement fullNameTextbox = driver.findElement(By.id(""));

        //Dùng để xóa dữ liệu trong 1 fie;d cho phép nhập (editable)
        //textbox/TextArea/ DropDown
        //thường được sử dụng trước hàm sendkey
        driver.findElement(By.id("")).clear();//*

        //Dùng để nhập dữ liệu vào field bên trên
        driver.findElement(By.id("")).sendKeys("");//**

        //Dùng cho nhưng button/link, click element
        driver.findElement(By.id("")).click();//**


        //Tìm từ thằng cha xuống thằng con
        driver.findElement(By.id("")).findElement(By.id(""));

        //Trả về nhiều element khớp với đk
        List<WebElement> txtbox = driver.findElements(By.id(""));

        //dùng để verify 1 checkbox/radio/dropdown đã được chọn hay chưa
        driver.findElement(By.id("")).isSelected();
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        //Drop down(deafault/custom)
        Select select = new Select(driver.findElement(By.id("")));

        //Dùng để verify 1 element bất kỳ có hiển thị hay không
        driver.findElement(By.id("")).isDisplayed();
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed());//**


        //Dùng để verify 1 element có được phép thao tác không
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled());//*
        Assert.assertFalse(driver.findElement(By.id("")).isEnabled());


        //HTML Element
        //<a class="_sv4" dir="ltr" href="https://vi-vn.facebook.com/"
        // title="Vietnamese">Tiếng Việt</a>
        driver.findElement(By.id("")).getAttribute("title");//*
        driver.findElement(By.id("")).getAttribute("type");
        driver.findElement(By.id("")).getAttribute("id");


        //tab Accesibility/ Properties trong Element
        driver.findElement(By.id("")).getAccessibleName();
        driver.findElement(By.id("")).getDomAttribute("checked");
        driver.findElement(By.id("")).getDomProperty("baseURI");


        //Tab Styles trong Elements
        //Font/ Size/ Color/ Background/...
        //background-color: rgb(255, 255, 255)
        driver.findElement(By.id("")).getCssValue("background-color");//*
       // font-size: 17px;
        driver.findElement(By.id("")).getCssValue("font-size");


        //vị trí của element so với độ phân giải màn hình
        Point namTextboxLocation =driver.findElement(By.id("")).getLocation();
        namTextboxLocation.getX();
        namTextboxLocation.getY();

        //location+size
        Rectangle namTextboxRect =driver.findElement(By.id("")).getRect();
        //location
        Point namePoit = namTextboxRect.getPoint();
        //Size
        Dimension nameSize = namTextboxRect.getDimension();
        nameSize.getHeight();
        nameSize.getWidth();

        //Shadow Element(JavascriptExecutor)
        driver.findElement(By.id("")).getShadowRoot();

        // Chiều rộng và chiều cao
        Dimension addressSize =driver.findElement(By.id("")).getSize();

        //từ Id/class/name/css/xpath có thể truy ra ngược lại tagname HTML
        driver.findElement(By.id("firstname")).getTagName();//=>input
        driver.findElement(By.cssSelector("#firstname")).getTagName();//=>input
        driver.findElement(By.className("#firstname")).getTagName();//=>input

        //Element A -> đầu ra của nó là tagname của element A
        String formwithTag = driver.findElement(By.xpath("//*[@class='form-list']")).getTagName();//=>ul


        //đầu vào của Element B sẽ nhận element A là tham số truyền vào
        //div[@class='remember-me-popup']/preceding-sibling::ul
        driver.findElement(By.xpath("//div[@class='remember-me-popup']/preceding-sibling::" + formwithTag));


        driver.findElement(By.id("")).getText();//**

        //Chụp hình bị lỗi dưới dạng
        //Byte
        //file (lưu thành 1 hình ảnh có kích thước .png/.jpg)
        //Base64 (lưu dưới dạng text)
        driver.findElement(By.id("")).getScreenshotAs(OutputType.BASE64);
        driver.findElement(By.id("")).getScreenshotAs(OutputType.BYTES);
        driver.findElement(By.id("")).getScreenshotAs(OutputType.FILE);//*

        //Form (element nào là thẻ form hoặc nằm trong thẻ form
        //Register/Login/Search
        //giống như phím enter
        driver.findElement(By.id("")).submit();

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
