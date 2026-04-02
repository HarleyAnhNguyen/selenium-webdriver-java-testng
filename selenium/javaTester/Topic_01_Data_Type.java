package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Topic_01_Data_Type {
    static  int studentNumber;
    static  boolean status;

    //Primitive type/ value type: kieu du lieu nguyen thuy
    byte bNumber= 6;
    short sNumber=1500;
    int iNumber =65000;
    long lNumber =6500;
    float fNumber =16.89f;
    double dNumber =18.78d;
    char cChar = '1';
    boolean bBoolean = false;

    //Reference type: tham chieu
    //String
    String address ="Ho Chi Minh";

    //Array
    String[] studenAddress = {address,"Ha Noi", "Da Nang"};
    Integer[] studentID = {15,20,50};

    //Class
    Topic_01_Data_Type  topic;

    //Interface
    WebDriver driver;

    //Object
    Object aObject;

    //Collection
    //List/Set/Queue/Map
    List<WebElement> homePageLink = driver.findElements(By.tagName("a"));
    Set<String> allWindows =driver.getWindowHandles();
    List<String> productName = new ArrayList<String>();

    public void clickToElement(){
        address.trim();
        studenAddress.clone();
        driver.getCurrentUrl();
        aObject.toString();
        homePageLink.size();

    }



    public static void main(String[] args){
        System.out.println(studentNumber);
        System.out.println(status);

        Topic_01_Data_Type rf = new Topic_01_Data_Type();

        System.out.println(rf.address);

    }
}
