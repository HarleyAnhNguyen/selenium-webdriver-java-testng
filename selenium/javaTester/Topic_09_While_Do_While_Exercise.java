package javaTester;

import java.util.Scanner;

public class Topic_09_While_Do_While_Exercise {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

//       int number = 0;
//       number = scanner.nextInt();
//       while (number<=100){
//           if (number%2 ==0){
//               System.out.print(number+" ");
//              }
//           number++;
//       }



//       int numberA = 0, numberB =0;
//       numberA = scanner.nextInt();
//       numberB = scanner.nextInt();
//         while (numberA<=numberB){
//             if(numberA%3==0 && numberA%5==0){
//              System.out.print(numberA+" ");
//             }
//              numberA++;
//         }


         int number = 0;
         number = scanner.nextInt();
         int i = 0, sum = 0;
            while (i<=number){
                if (i%2== 1) {
                    sum +=i;
                }
                i++;
            }
            System.out.println("Tong cac so le tu 0 den "+number+" la: "+sum);


//        int number = 0, i = 1;
//        number = scanner.nextInt();
//        while (number>=1){
//            i*=number;
//            number--;
//        }
//        System.out.println("Giai thua cua so "+number+"! la: "+i);
    }
}
