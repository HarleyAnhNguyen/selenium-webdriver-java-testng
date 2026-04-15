package javaTester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Topic_11_Array_Exercise {
    static Scanner scanner = new Scanner(System.in);
    int id, age;
    String name;
    float score;

    public static void main(String[] args){
//        TC_01_Find_Max_Number_In_Array();
//        TC_02_Sum_Of_First_Number_And_Last_Number_In_Array();
//        TC_03_Even_Number_In_Array();
//        TC_04_Sum_Of_Odd_Number_In_Array();
//        TC_05_Number_From_0_To_10_In_Array();
        TC_06_Sum_And_Average_In_Array();

    }

    public static void TC_01_Find_Max_Number_In_Array(){
        int[] numbers ={3, 12, 11, 7, 9, 26};
        String number = Arrays.toString(numbers);
        for(int i = 0; i<(numbers.length);i++){
            if(numbers[0]<numbers[i]){
               numbers[0] = numbers[i];
            }
        }
        System.out.println("Max number in array " +number+" is: " +numbers[0]);
    }

    public static void TC_02_Sum_Of_First_Number_And_Last_Number_In_Array(){
        int[] numbers ={13, 2, 11, 7, 9, 65};
        String number = Arrays.toString(numbers);
        int sum = numbers[0]+numbers[numbers.length-1];
        System.out.println("Sum of first number and last number in array " +number+" is: " +sum);
    }

    public static void TC_03_Even_Number_In_Array(){
        int[] numbers ={14, 2, 11, 81, 90, 34};
        String number = Arrays.toString(numbers);
        System.out.println("Even number in array " +number+" is: ");
        for(int i =0;i<numbers.length;i++){
            if(numbers[i]%2==0){
                System.out.print(numbers[i]+" ");
            }
        }
    }

    public static void TC_04_Sum_Of_Odd_Number_In_Array(){
        int[] numbers ={1, 2, -11, 81, -9, 3,-6};
        String number = Arrays.toString(numbers);
        int sum =0;
        for(int i =0;i<numbers.length;i++){
            if(numbers[i]%2==1 && numbers[i]>0){
                sum+=numbers[i];
            }
        }
        System.out.println("Sum of odd number that is over 0 in array " +number+" is: " +sum);
    }

    public static void TC_05_Number_From_0_To_10_In_Array(){
        int[] numbers = new int[7];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] =scanner.nextInt();
        }
        String number = Arrays.toString(numbers);
        System.out.println("Number from 0 to 10 in array " +number+" is: ");
        for(int i =0;i<numbers.length;i++){
           if(numbers[i]>=0 && numbers[i]<=10){
                System.out.print(numbers[i]+" ");
           }
        }

        scanner.close();
    }

    public static void TC_06_Sum_And_Average_In_Array(){
       List<Integer> numbersList = new ArrayList<Integer>();
       System.out.println("Enter number of elements in array: ");
       int numberOfElements = scanner.nextInt();
       for(int i=0; i<numberOfElements; i++){
           System.out.println("numbersList["+i+"]");
           int number = scanner.nextInt();
           numbersList.add(number);
       }
       int sum=0;
       for(int number:numbersList){
           sum+=number;
       }
       System.out.println("Sum of numbers in array " +numbersList+" is: " +sum);
       System.out.println("Average of number in array "+ numbersList+" is: " +sum/numbersList.size());
        scanner.close();
    }

}
