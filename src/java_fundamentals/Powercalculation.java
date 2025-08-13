package java_fundamentals;

import java.util.Scanner;

public class Powercalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter base: ");
        double base = sc.nextDouble();

        // Taking exponent input
        System.out.print("Enter exponent: ");
        double exponent = sc.nextDouble();

        double result = Math.pow(base, exponent);

        System.out.println(base + " raised to the power " + exponent + " = " + result);
    }
}
