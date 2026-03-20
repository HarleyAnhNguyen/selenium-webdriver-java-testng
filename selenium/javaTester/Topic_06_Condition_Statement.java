package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    public void TC_01_If(String[] args){
        boolean status = 5 > 3;
        System.out.println(status);
        //Ham if se nhan vao 1 dieu kien dung
        //ktra duy nhat 1 dieu kien
        //neu dieu kien nay dung thi se action (xxx) trong phan than
        if(status){
            //dung thi di vao phan than cua if
            // sai thi bo qua
            System.out.println("Go to if");

        }

    }

    @Parameters("browser")
    @Test
    public void TC_03_If_Else_If_Else(String browserName){

        //Co nhieu dieu kien
        // Best Practice: ko nen if-else nhieu lan
        if(browserName.equalsIgnoreCase("chrome")){
            driver= new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        } else{
            throw new RuntimeException("Please input correct the browser name");
        }
        System.out.println(browserName);
        System.out.println(driver.toString());
        driver.quit();

    }


}
