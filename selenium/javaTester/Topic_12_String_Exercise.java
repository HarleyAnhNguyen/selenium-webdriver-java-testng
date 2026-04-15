package javaTester;

import java.util.Scanner;

public class Topic_12_String_Exercise {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
//        TC_01_UperCase();
//        TC_02_Action_On_String();
//        TC_03_Reverse_The_String();
        TC_04_Check_Format_Of_Phone_Number();
    }

    public static void TC_01_UperCase(){
        System.out.println("Enter a String: ");
        String str = scanner.nextLine();
        int count = 0;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
                System.out.print(str.charAt(i)+" ");
                count++;
            }
        }
        System.out.println("Upper case in String is :"+count);

    }

    public static void TC_02_Action_On_String(){
        String str = "Automation Testing 345 Tutorials Online 789";
        int count =0;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)=='a'){
                count++;
            }
        }
        System.out.println("Number of character 'a' in String is: "+count);
        System.out.println("Number of digit in String is: "+count);
        System.out.println("String is contains word 'Testing' or not: "+str.contains("Testing"));
        System.out.println("String is start with word 'Automation' or not: "+str.startsWith("Automation"));
        System.out.println("String is end with word 'Automation' or not: "+str.endsWith("Online"));
        System.out.println("Index of word 'Tutorials' in String is: "+str.indexOf("Tutorials"));
        System.out.println("String after replace 'Online' with 'Offline' is: "+str.replace("Online","Offline"));
        count =0;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                count++;
            }
        }
        System.out.println("Number of digit in String is: "+count);

    }
    public static void TC_03_Reverse_The_String(){
        System.out.println("Enter a String: ");
        String str = scanner.nextLine();
        String reverse ="";
        for(int i=str.length()-1; i>=0; i--){
            reverse += str.charAt(i);

        }
        System.out.println("Reverse of String is: "+reverse);

    }

    public static void TC_04_Check_Format_Of_Phone_Number(){
        System.out.println("Enter a Phone Number: ");
        String str = scanner.nextLine();
        if(str.startsWith("7")||str.startsWith("8")||str.startsWith("9") &&str.length()==10) {
            System.out.println("Phone number is valid");
        }else {
                System.out.println("Phone number is invalid");
            }


    }

}
