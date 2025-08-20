package Arrays;

import java.util.Scanner;

public class ReverseNumberUsingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take user input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Step 2: Make a copy of the number to count digits
        int tempNumber = number;
        int digitCount = 0;

        // Step 3: Count digits
        while (tempNumber != 0) {
            tempNumber = tempNumber / 10;
            digitCount++;
        }

        // Step 4: Create an array to store digits
        int[] digits = new int[digitCount];

        // Step 5: Extract digits and store in array
        for (int i = 0; i < digitCount; i++) {
            digits[i] = number % 10;
            number = number / 10;
        }

        // Step 6: Create reversed array (optional, same as original `digits` here)
        int[] reversed = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            reversed[i] = digits[i];
        }

        // Step 7: Display the reversed number
        System.out.print("Reversed number is: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(reversed[i]);
        }

        sc.close();
    }
}

