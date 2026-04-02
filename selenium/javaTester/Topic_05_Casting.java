package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Topic_05_Casting {

    public static void main(String[] args){

        //Ngam dinh = ko mat du lieu
        byte bNumber= 126;
        System.out.println(bNumber);

        short sNumber= bNumber;
        System.out.println(sNumber);

        int iNumber = sNumber;
        System.out.println(iNumber);

        long lNumber = iNumber;
        System.out.println(lNumber);

        float fNumber = lNumber;
        System.out.println(fNumber);

        double dNumber = fNumber;
        System.out.println(dNumber);

        //Tuong Minh
        dNumber = 678843337944327.99;
        System.out.println(dNumber);

        fNumber = (float) dNumber;
        System.out.println(fNumber);

        lNumber = (long) fNumber;
        System.out.println(lNumber);

    }
}
