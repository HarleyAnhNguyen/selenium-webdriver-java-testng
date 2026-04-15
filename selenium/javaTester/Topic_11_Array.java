package javaTester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Topic_11_Array {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int[] studentId = {1001, 1002, 1003, 1004, 1005};
        // lay ra cac phan tu cua mang
        System.out.println(studentId[0]);
        System.out.println(studentId[1]);
        //System.out.println(studentId[6]);// ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 5
        String studentName[] = {"Nguyen Van A", "Le Thi B", "Tran Van C", "Pham Thi D", "Do Van E"};

        for (int i=0; i<studentName.length;i++){
            System.out.println(studentName[i]);
        }

        for (String std : studentName){
            if(std.equals("Le Thi B")){
                System.out.println(std);
            }
        }

        ArrayList<String> stdName = new ArrayList<String>();
       for(String std : studentName){
           stdName.add(std);
       }

        List<String> names = Arrays.asList("Tom", "Jerry", "Spike", "Tyke");
        for (String name : names){
            System.out.println(name);
        }

        String std_Name = Arrays.toString(names.toArray());
        System.out.println(std_Name);
        // [Tom, Jerry, Spike, Tyke]
        std_Name = Arrays.toString(studentName);
        System.out.println(std_Name);
        //[Nguyen Van A, Le Thi B, Tran Van C, Pham Thi D, Do Van E]
    }
}
