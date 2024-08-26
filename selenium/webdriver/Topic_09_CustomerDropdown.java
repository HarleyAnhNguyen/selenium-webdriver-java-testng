package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
    public void TC_01_JQuery() {

        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        sleepInSeconds(3);
        //1. click vào thẻ để nó xổ ra
//        driver.findElement(By.cssSelector("span#number-button")).click();

        // 2.1 nó xổ ra chứa hết tất cả item
        //2.2 Nó xổ ra nhưng chỉ chứa 1 phần và đang lòa thêm
//       explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));
//
//        List<WebElement> allItems = driver.findElements(By.cssSelector("ul#number-menu div"));
//
//        for (WebElement item :allItems){
//
//            if(item.getText().equals("15")){
//                item.click();
//                break;//9-19 ko ktra
//            }
//        }

        SelectItemInDropdown("span#speed-button", "ul#speed-menu div", "Faster");
        sleepInSeconds(3);


        SelectItemInDropdown("span#files-button", "ul#files-menu div", "ui.jQuery.js");
        sleepInSeconds(3);

        SelectItemInDropdown("span#number-button", "ul#number-menu div", "15");
        sleepInSeconds(3);

        SelectItemInDropdown("span#salutation-button", "ul#salutation-menu div", "Mrs.");
        sleepInSeconds(3);


//        driver.navigate().refresh();

        // Ngàn/ Triệu
        // 3.1 Nếu như item cần chọn có hiện thì click
        // 3.2 Nếu như item cần chọn nằm bên dưới thì 1 số trường hợp cần scroll xuống để hiện thị rồi mới chọn
        // 4 trước khi chọn thì kiểm tra nếu như text của item bằng với item cần chọn thì click

        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(),"Faster");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button>span.ui-selectmenu-text")).getText(),"ui.jQuery.js");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(),"15");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(),"Mrs.");

    }

    @Test
    public void TC_02_ReactJS() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        SelectItemInDropdown("i.dropdown.icon", "div.item>span.text", "Christian");
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Christian");
        sleepInSeconds(3);

        SelectItemInDropdown("i.dropdown.icon", "div.item>span.text", "Stevie Feliciano");
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Stevie Feliciano");
        sleepInSeconds(3);

        SelectItemInDropdown("i.dropdown.icon", "div.item>span.text", "Matt");
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Matt");
        sleepInSeconds(3);
    }

    @Test
    public void TC_03_VueJS() {

        driver.get("https://mikerodham.github.io/vue-dropdowns/");

        SelectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Second Option");
        sleepInSeconds(3);

        SelectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Third Option");
        sleepInSeconds(3);

    }

    @Test
    public void TC_04_Editable() {

        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

        SelectItemInEditableDropdown("input.search", "div.item span", "Belgium");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Belgium");
        sleepInSeconds(3);

        SelectItemInEditableDropdown("input.search", "div.item span", "Angola");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Angola");
        sleepInSeconds(3);

        SelectItemInEditableDropdown("input.search", "div.item span", "Benin");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Benin");
        sleepInSeconds(3);

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


    public  void SelectItemInDropdown(String parentCss, String childItemCss, String itemTextExpected){

        driver.findElement(By.cssSelector(parentCss)).click();//span#number-button

        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));//ul#number-menu div

        List<WebElement> allItems = driver.findElements(By.cssSelector(childItemCss));

        for (WebElement item :allItems){

            if(item.getText().equals(itemTextExpected)){
                item.click();
                break;//9-19 ko ktra
            }
        }
    }

    public  void SelectItemInEditableDropdown(String parentCss, String childItemCss, String itemTextExpected){

        driver.findElement(By.cssSelector(parentCss)).clear();
        driver.findElement(By.cssSelector(parentCss)).sendKeys(itemTextExpected);
        sleepInSeconds(1);

        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));//ul#number-menu div

        List<WebElement> allItems = driver.findElements(By.cssSelector(childItemCss));

        for (WebElement item :allItems){

            if(item.getText().equals(itemTextExpected)){
                item.click();
                break;//9-19 ko ktra
            }
        }

    }

}
