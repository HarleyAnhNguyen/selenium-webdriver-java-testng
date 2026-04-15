package javaTester;

import java.util.ArrayList;
import java.util.List;

public class Topic_09_While_Do_While {

    public static void main(String[] args){

       int i =0;
       while (i<=5){
           System.out.println(i);
           i++;
       }
        System.out.println(i);
       System.out.println("---------------------------------");

       do{
           System.out.println(i);
           i++;
       }while (i<=5);
    }
}
