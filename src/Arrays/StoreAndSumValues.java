package Arrays;

import java.util.Scanner;

public class StoreAndSumValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Declare array and variables
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        // Step 2: Start infinite loop
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double input = sc.nextDouble();

            // Step 3: Check break conditions
            if (input <= 0) {
                break;
            }
            if (index == 10) {
                System.out.println("Maximum limit of 10 numbers reached.");
                break;
            }

            // Step 4: Store the number and increment index
            numbers[index] = input;
            index++;
        }

        // Step 5: Calculate total and display values
        System.out.println("\nEntered numbers:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        System.out.println("Total sum of numbers: " + total);
        sc.close();
    }
}

