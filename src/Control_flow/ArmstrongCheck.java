package Control_flow;

import java.util.Scanner;

public class ArmstrongCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Step 2: Initialize sum and store the original number
        int sum = 0;
        int originalNumber = number;

        // Step 3: Use while loop to extract digits and calculate sum of cubes
        while (originalNumber != 0) {
            // Get the last digit
            int digit = originalNumber % 10;

            // Add the cube of the digit to the sum
            sum += digit * digit * digit;

            // Remove the last digit
            originalNumber = originalNumber / 10;
        }

        // Step 4: Compare the sum with the original number
        if (sum == number) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is NOT an Armstrong number.");
        }

        sc.close();
    }
}

