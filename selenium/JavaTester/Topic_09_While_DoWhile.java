package JavaTester;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_09_While_DoWhile {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
//            int number = scanner.nextInt();
//            for (int i = number; i<100; i++){
//                if(i%2==0){
//                    System.out.println(i);
//                }
//            }
//        ...............................................
//            int n = scanner.nextInt();
//            int sum = 0;
//            for(int i = 1; i<=n; i+=2){
//                System.out.println(i);
//                sum +=i;
//            }
//            System.out.println("Tổng các số lẻ từ 0 đến " + n + " là: " + sum);

        //.........................
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int sum =0;
        for (int i = a;i<= b;i++){
            if (i%3==0) {
                System.out.print(i + " ");
                sum += i;
            }
        }
        System.out.println("Tổng các số từ a đến b chia hết cho 3 là" + sum);
//        for (int i=0;i<10;i++){
//            System.out.println(i);
//        }
//        int i =0;
//        while (i<5){
//            System.out.println(i);
//            i++;
//        }
        // Do while: chạy ít nhất một lần rồi kiểm tra điều kiện
    }

}
