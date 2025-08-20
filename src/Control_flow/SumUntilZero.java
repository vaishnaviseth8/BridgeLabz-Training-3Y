package Control_flow;

import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double total = 0.0;  // Total sum
        double number;       // User input

        // Input prompt
        System.out.print("Enter a number (0 to stop): ");
        number = sc.nextDouble();

        // While loop continues until user enters 0
        while (number != 0) {
            total += number;  // Add input to total

            System.out.print("Enter another number (0 to stop): ");
            number = sc.nextDouble();
        }

        // Output total sum
        System.out.println("Total sum = " + total);

        sc.close();
    }
}

