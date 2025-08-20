package Control_flow;

import java.util.Scanner;

public class OddEvenChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get input from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Check if it's a natural number (positive integer)
        if (number <= 0) {
            System.out.println("The number " + number + " is not a natural number.");
        } else {
            // Iterate from 1 to the number
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is an Even number");
                } else {
                    System.out.println(i + " is an Odd number");
                }
            }
        }

        sc.close();
    }
}

