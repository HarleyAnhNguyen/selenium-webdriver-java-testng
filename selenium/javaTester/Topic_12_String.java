package javaTester;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;

public class Topic_12_String {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        String s1 ="Cat";
        String s2 = s1;
        String s3 =new String("Cat");
        System.out.println(s1==s2);
        System.out.println(s1==s3);

        String nameOfClass = "Selenium Automation Testing";
        String addressOfClass = "Ho Chi Minh City";
        System.out.println(nameOfClass.length());//Do dai cua chuoi: 27 ki tu
        System.out.println(nameOfClass.charAt(0));//Lay ra ki tu o vi tri n: nameOfClass.charAt(0) S
        System.out.println(nameOfClass.concat(" - "+addressOfClass));// Noi chuoi: Selenium Automation Testing - Ho Chi Minh City
        System.out.println(nameOfClass+" - "+addressOfClass);// Noi chuoi: Selenium Automation Testing - Ho Chi Minh City
        System.out.println(nameOfClass.equals("Selenium Automation Testing"));//Kiem tra 2 chuoi co bang nhau hay khong (tuyet doi): true
        System.out.println(nameOfClass.equalsIgnoreCase("selenium automation Testing"));//Kiem tra 2 chuoi co bang nhau hay khong (tuong doi, ko phan biet hoa thuong): true

        System.out.println(nameOfClass.startsWith("Se"));//Kiem tra chuoi co bat dau bang 1 chuoi khac hay khong: true
        System.out.println(nameOfClass.contains("Auto"));//Kiem tra chuoi co chua 1 chuoi khac hay khong: true
        System.out.println(nameOfClass.endsWith("ting"));//Kiem tra chuoi co ket thuc bang 1 chuoi khac hay khong: true

        System.out.println(nameOfClass.indexOf("Auto"));//Tra ve vi tri xuat hien dau tien cua chuoi con trong chuoi cha: 9
        System.out.println(nameOfClass.substring(7,15));//Tra ve chuoi con tu vi tri bat dau den vi tri ket thuc -1: m Automa

        String result = "Viewing 48 of 132 results";
        String results[] = result.split(" ");//Cat chuoi thanh 1 mang cac chuoi con voi ky tu phan tach la " "
        System.out.println(results[1]);//48

        String productPrice = "$100.00";
        productPrice = productPrice.replace("$","");//Thay the chuoi con bang chuoi moi: 100.00
        float price = Float.parseFloat(productPrice);//Chuyen chuoi thanh so thuc: 100.00
        productPrice = String.valueOf(price);//Chuyen so thuc thanh chuoi: 100.0

//        String osName = System.getProperty("os.name");//Lay ra ten he dieu hanh dang su dung: Windows 10
//        System.out.println(osName);//handle multiple OS: Windows 10, Mac OS X, Linux(Action - keys -Control - Command)
//        if(osName.toLowerCase().contains("Windows")){
//            Keys key = Keys.CONTROL;
//        } else {
//            Keys key = Keys.COMMAND;
//        }
//
//        WebDriver driver = new FirefoxDriver();
//        String driverInstanceName = driver.toString();//Lay ra ten cua doi tuong driver: org.openqa.selenium.firefox.FirefoxDriver@1b6d3586
//        System.out.println(driverInstanceName);
//        // Dung de: dua vao ten trinh duyet tat browser/driver
//        driver.quit();

        String helloWorld = " \n  Hello World       ";
        System.out.println(helloWorld.trim());//Xoa khoang trang o dau va cuoi chuoi: Hello World
        System.out.println(helloWorld);

        helloWorld=" ";
        System.out.println(helloWorld.isEmpty());//Kiem tra chuoi co rong hay khong: true
        System.out.println(helloWorld.isBlank());//Kiem tra chuoi co rong hoac chi chua khoang trang hay khong: true

        String dynamicButton = "//button[@id='%s']";
        System.out.println(String.format(dynamicButton,"login"));//Dinh dang chuoi voi gia tri truyen vao: //button[@id='login']
        System.out.println(String.format(dynamicButton,"register"));//Dinh dang chuoi voi gia tri truyen vao: //button[@id='register']
        System.out.println(String.format(dynamicButton,"search"));//Dinh dang chuoi voi gia tri truyen vao: //button[@id='search']

    }
}
