package testng;

import org.testng.annotations.*;

public class Topic_01_Annotation {
    @BeforeClass
    public void beforeClass(){
        System.out.println("Run Before Class");

    }

    @Test
    public void TC_01(){
        System.out.println("Run TC01");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("Run After Class");

    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Run Before Method");

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Run After Method");

    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("Run Before Test");

    }

    @AfterTest
    public void afterTest() {
        System.out.println("Run After Test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Run Before Suite");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("Run After Suite");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("Run Before Groups");
    }
    @AfterGroups
    public void afterGroups() {
        System.out.println("Run After Groups");
    }
    @Test
    public void TC_02(){
        System.out.println("Run TC02");
    }

}
