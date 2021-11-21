/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demorecursive;

import java.util.Scanner;

/**
 *
 * @author DUC THINH
 */
public class DemoRecursive {

    /**
     * @param args the command line arguments
     */
// Tính giai thừa bằng đệ quy
    static long fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
// Chuyển hệ 10 bằng đệ quy

    static void convert(int n, int base) {
        if (n < base) {
            System.out.print("" + n);
        } else {
            convert(n / base, base);
            System.out.print("" + n % base);
        }
    }
// Đảo ngược string bằng đệ quy

    static String reverse(String s) {
        if (s.length() == 1) {
            return s;
        } else {
            return reverse(s.substring(1)) + s.charAt(0);
        }
    }
// Tháp Hà Nội

    static void thapHaNoi(int n, String a, String b, String c) {
        if (n == 1) {
            System.out.println("Chuyển đĩa " + n + " từ " + a + " sang " + c);
        } else {
            thapHaNoi(n-1,a,c,b);
            System.out.println("chuyển đĩa " + n + " từ " + a + " sang " + c);
            thapHaNoi(n-1,b,a,c);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//1.1
//        int n = sc.nextInt();
//        System.out.println("Factorial of number " + n + " is " + fact(6));
//1.2
//        System.out.print("Enter number: ");
//        int number = sc.nextInt();
//        System.out.print("Convert to base: ");
//        int base = sc.nextInt();
//        convert(number,base);
//1.3
//          String s = sc.nextLine();
//          System.out.println(reverse(s));
//1.4

        thapHaNoi(3, "cột A", "cột B", "cột C");
    }

}
