package Arrays;

import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input
        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        // Step 2: Convert number to absolute in case of negative
        number = Math.abs(number);

        // Step 3: Count digits and store them in an array
        int[] digits = new int[20]; // assuming number can have max 20 digits
        int index = 0;
        long temp = number;

        while (temp > 0) {
            digits[index] = (int)(temp % 10);
            temp /= 10;
            index++;
        }

        // Step 4: Create frequency array of size 10
        int[] frequency = new int[10];

        for (int i = 0; i < index; i++) {
            frequency[digits[i]]++;
        }

        // Step 5: Display frequency
        System.out.println("\nDigit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " time(s)");
            }
        }

        sc.close();
    }
}

