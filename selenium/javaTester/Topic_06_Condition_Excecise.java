package javaTester;

import java.util.Scanner;

public class Topic_06_Condition_Excecise {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

//        int number = 0;
//        System.out.println("Nhap vao so bat ky: ");
//        number = sc.nextInt();
//
//        if(number%2 ==0){
//            System.out.println("So "+ number+" la so chan");
//        }else {
//            System.out.println("So "+ number+" la so le");
//        }
//
//        int a = 0, b=0;
//        System.out.println("Nhap a: ");
//        a = sc.nextInt();
//        System.out.println("Nhap b: ");
//        b = sc.nextInt();
//
//        if(a>=b){
//            System.out.println( a + " lon hon hoac bang " +b);
//        }else {
//            System.out.println(a + " nho hon "+b);
//        }
        /**/

        String studentA ="", studentB ="";
        System.out.println("Nhap ten hoc sinh thu nhat: ");
        studentA = sc.nextLine();

        System.out.println("Nhap ten hoc sinh thu hai: ");
        studentB = sc.nextLine();

        if(studentA.equals(studentB)){
            System.out.println("Hai hoc sinh trung ten");
        }else
            System.out.println("Hai hoc sinh KHONG trung ten");
/*------------------TC04_MaxNumber------------------------------------*/

                int fiNumber = 0, seNumber=0, thNumber = 0;
        System.out.println("Nhap so thu nhat: ");
        fiNumber = sc.nextInt();
        System.out.println("Nhap so thu hai: ");
        seNumber = sc.nextInt();
        System.out.println("Nhap so thu ba: ");
        thNumber = sc.nextInt();

        if(fiNumber>=seNumber && fiNumber>=thNumber){
            System.out.println("so lon nhat la: "+fiNumber);
        }else if (seNumber>fiNumber && seNumber>thNumber){
            System.out.println("so lon nhat la: "+seNumber);
        }else {
            System.out.println("so lon nhat la: "+thNumber);
        }
        /*----------------------TC05_NumberIn-------------------------------*/
        int numberA = sc.nextInt();
        if(numberA>=10 && numberA <=100){
            System.out.println(numberA +" nam trong khoang [10,100]");
        }else
            System.out.println(numberA +" KHONG nam trong khoang [10,100]");

/*------------------------TC06_StudentPoint----------------------------------*/
        float studentPoint = sc.nextFloat();
        if(studentPoint<5 && studentPoint >0){
            System.out.println("Ban dat diem D");
        }else if (studentPoint>=5 && studentPoint<6.5){
            System.out.println("Ban dat diem C");
        }else if (studentPoint>=6.5 && studentPoint<7.5){
            System.out.println("Ban dat diem B");
        }else if (studentPoint>=7.5 && studentPoint<8.5){
            System.out.println("Ban dat diem A");
        }else if (studentPoint>=8.5 && studentPoint<10){
            System.out.println("Ban dat diem A+");
        }else {
                System.out.println("Diem ban nhap khong dung");
        }

    }
}
