package Control_flow;

import java.util.Scanner;

public class FactorsOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        // Check if it's a positive integer
        if (number > 0) {
            System.out.println("Factors of " + number + " are:");
            // Loop from 1 to number
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("The number " + number + " is not a positive integer.");
        }

        sc.close();
    }
}

