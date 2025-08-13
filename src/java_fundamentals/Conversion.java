package java_fundamentals;

import java.util.Scanner;
public class Conversion {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        double celsius= sc.nextDouble();
        double fahrenheit=(celsius*9.0/5.0)+32.0;
        System.out.println(fahrenheit);
    }
}
