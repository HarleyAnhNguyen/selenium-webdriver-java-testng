package javaTester;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_04_Excecise {
    public static void main(String[] args){
        int a =6 ;
        int b  = 5;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so nguyen a: " );
        a = sc.nextInt();
        System.out.print("Nhap so nguyen b: " );
        b = sc.nextInt();
        a= a+b;
        b= a-b;
        a= a-b;
        System.out.println(a);
        System.out.println(b);
    }
}
