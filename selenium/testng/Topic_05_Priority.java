package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Priority {

    @Test (priority = 0)
    public void shouldBeCreatedNewProduct(){
        System.out.println("shouldBeCreatedNewProduct");
    }

    @Test(priority = 1)
    public void shouldBeViewProduct(){

        System.out.println("shouldBeViewProduct");
    }
    @Test(priority = 2)
    public void shouldBeEditProduct(){

        System.out.println("shouldBeEditProduct");
    }

    @Test(priority = 3)
    public void shouldBeDeletedProduct(){

        System.out.println("shouldBeDeletedProduct");
    }


}
