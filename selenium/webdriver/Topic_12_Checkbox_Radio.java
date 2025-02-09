package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_12_Checkbox_Radio {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Default_Telerik_Checkbox() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");

        // click vao checkbox Dual-zone air conditioning
        //case 1: Dual zone checkbox luc mo len chua duoc chon
        WebElement dualCheckbox =driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input"));

        dualCheckbox.click();
        sleepInSeconds(2);

        //verify checkbox da duoc chon
        Assert.assertTrue(dualCheckbox.isSelected());

        //Case 2: RearSide checkbox luc mo len da duoc chon
        WebElement rearSideCheckbox =driver.findElement(By.xpath("//label[text()='Rear side airbags']/preceding-sibling::span/input"));

        if (!rearSideCheckbox.isSelected()){
            rearSideCheckbox.click();
        }

        Assert.assertTrue(rearSideCheckbox.isSelected());

        //bo chon het 2 checkbox
        uncheckElement(dualCheckbox);
        uncheckElement(rearSideCheckbox);

    }
    @Test
    public void TC_02_Default_Telerik_Radio() {

        //Truy cap trang va lay Element cua radiobutton 2.0 Petrol, 147kW
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        WebElement radiobutton2Petro147kW =driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input"));

        // click vao radiobutton 2.0 Petrol, 147kW
        radiobutton2Petro147kW.click();

        //verify Radio 2.0 Petrol, 147kW da duoc chon
        Assert.assertTrue(radiobutton2Petro147kW.isSelected());

        //verify Radio 1.4 Petrol, 92kW
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='1.4 Petrol, 92kW']/preceding-sibling::span/input")).isSelected());

    }

    @Test
    public void TC_03_SelectAll_Or_1Checkbox() {

        driver.get("https://automationfc.github.io/multiple-fields/");

        List<WebElement> allEverHadCheckbox = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));

        //chon het checkbox

        for(WebElement checkbox:allEverHadCheckbox){
            if (!checkbox.isSelected()){
                checkbox.click();
                //sleepInSeconds(1);
            }
        }

        //verify all checkbox duoc chon
        for (WebElement checkbox:allEverHadCheckbox){
            Assert.assertTrue(checkbox.isSelected());
        }

        //refresh lai trang
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        allEverHadCheckbox = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));

        //Select 1 checkbox nao do
        for (WebElement checkbox:allEverHadCheckbox){
            if(checkbox.getAttribute("value").equals("Rheumatic Fever") && !checkbox.isSelected()){
                checkbox.click();
                sleepInSeconds(3);
            }
        }

        //verify checkbox isSelected
        for (WebElement checkbox:allEverHadCheckbox){
            if(checkbox.getAttribute("value").equals("Rheumatic Fever")){
               Assert.assertTrue(checkbox.isSelected());
            }else {
                Assert.assertFalse(checkbox.isSelected());
            }
        }

    }



    @Test
    public void TC_0301_DefaultCheckBox_Or_RadioButton() {

        driver.get("https://material.angular.io/components/radio/examples");

        WebElement radioSummer= driver.findElement(By.cssSelector("input[value='Summer']"));

        radioSummer.click();

        if(!radioSummer.isSelected()){
            radioSummer.click();
        }
        driver.get("https://material.angular.io/components/checkbox/examples");

        WebElement chkboxChecked= driver.findElement(By.xpath("//label[text() ='Checked']/preceding-sibling::div//input"));
        WebElement chkboxIndeterminate= driver.findElement(By.xpath("//label[text() ='Indeterminate']/preceding-sibling::div//input"));

        chkboxChecked.click();
        chkboxIndeterminate.click();

        Assert.assertTrue(chkboxChecked.isSelected());
        Assert.assertTrue(chkboxIndeterminate.isSelected());

        chkboxChecked.click();
        chkboxIndeterminate.click();

        Assert.assertFalse(chkboxChecked.isSelected());
        Assert.assertFalse(chkboxIndeterminate.isSelected());

    }


    @Test
    public void TC_04_SelectAll_Or_1Checkbox() {
        driver.get("https://automationfc.github.io/multiple-fields/");

        //Select all checkbox
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("span.form-checkbox-item>input"));

        //Click all checkboxes
        for (WebElement checkbox : checkboxes){
            if(!checkbox.isSelected()){
                checkbox.click();
            }
        }

        // Verify all checkboxes selected
        for (WebElement checkbox : checkboxes){
            Assert.assertTrue(checkbox.isSelected());
        }

        //Deselect all checkboxes
        for (WebElement checkbox : checkboxes){
            if(checkbox.isSelected()){
                checkbox.click();
            }
        }

        //Verify all checkbox deslected
        for (WebElement checkbox : checkboxes){
            Assert.assertFalse(checkbox.isSelected());
        }

        //Select 1 in all + verify
        driver.findElement(By.cssSelector("input[value='Cancer']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Cancer']")).isSelected());


        for(WebElement checkbox : checkboxes){
            if(!checkbox.isSelected() && checkbox.getAttribute("value").equals("Heart Attack")){
                checkbox.click();
            }
        }
        sleepInSeconds(1);
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Heart Attack']")).isSelected());

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void checkElement(WebElement element){
        if (!element.isSelected()){
            element.click();
        }
        Assert.assertTrue(element.isSelected());
    }

    public void uncheckElement(WebElement element){
        if (element.isSelected()){
            element.click();
        }
        Assert.assertFalse(element.isSelected());
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
