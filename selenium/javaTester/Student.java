package javaTester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student {
    int id, age;
    String name;
    float score;


    public Student(int id, String name, int age, float score){
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;

    }
    public void display(){
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Score: "+score);
    }

    public static void main(String[] args){
       Student[] students = new Student[3];
       students[0]= new Student(1001,"Harley",31,8.5f);
       students[1]= new Student(1002,"Cody",28,8.0f);
       students[2]= new Student(1003,"Avocado",7,5.0f);
       for (int i=0; i< students.length; i++){
           students[i].display();
           System.out.println("-----------------------------");
       }
    }
}
