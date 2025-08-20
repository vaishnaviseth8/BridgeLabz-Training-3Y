package Arrays;

import java.util.Scanner;

public class MultiplicationTable69 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input from user
        System.out.print("Enter a number to find its multiplication table from 6 to 9: ");
        int number = sc.nextInt();

        // Step 2: Create an array to store results for 6, 7, 8, 9
        int[] multiplicationResult = new int[4];  // for 6, 7, 8, 9

        // Step 3: Use for loop to calculate multiplication results
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
        }

        // Step 4: Display the result
        System.out.println("\nMultiplication results from 6 to 9:");
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 6]);
        }

        sc.close();
    }
}

