package javaTester;

import java.util.Scanner;

public class Topic_07_SwitchCase {

    public static void main(String[] args){

        /*----------------------days of month-----------------------*/

        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();

        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Thang co 31 ngay");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Thang co 30 ngay");
                break;
            case 2:
                System.out.println("Thang co 28 hoac 29 ngay");
                break;
            default:
                System.out.println("Thang nhap vao khong dung, vui long nhap so tu 1 den 12");
                break;
        }


        /*-----------------------------Number To English-------------------------------*/
        int number = sc.nextInt();

        switch (number){
            case 1:
                System.out.println("One");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 10:
                System.out.println("Ten");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 9:
                System.out.println("Nine");
                break;
            case 2:
                System.out.println("Two");
                break;
            default:
                System.out.println("Thang nhap vao khong dung, vui long nhap so tu 1 den 10");
                break;
        }

        /*-----------------------------Calculating -------------------------------*/
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();
        String operator = sc.next();

        switch (operator){
            case "+":
                System.out.println("A + B = " +(firstNumber+secondNumber));
                break;
            case "-":
                System.out.println("A - B = " +(firstNumber-secondNumber));
                break;
            case "*":
                System.out.println("A x B = " +(firstNumber*secondNumber));
                break;
            case "/":
                System.out.println("A / B = " +firstNumber/secondNumber);
                break;
        }




    }
}
