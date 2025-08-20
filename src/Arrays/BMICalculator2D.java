package Arrays;

import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input for number of persons
        System.out.print("Enter the number of persons: ");
        int number = sc.nextInt();

        // Step 2: Create 2D array to store height, weight, BMI
        // personData[i][0] = height, [1] = weight, [2] = BMI
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // Step 3: Input height and weight
        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");

            // Input weight with validation
            while (true) {
                System.out.print("Enter weight in kg (positive number): ");
                double weight = sc.nextDouble();
                if (weight > 0) {
                    personData[i][1] = weight;
                    break;
                } else {
                    System.out.println("Weight must be positive. Try again.");
                }
            }

            // Input height with validation
            while (true) {
                System.out.print("Enter height in meters (positive number): ");
                double height = sc.nextDouble();
                if (height > 0) {
                    personData[i][0] = height;
                    break;
                } else {
                    System.out.println("Height must be positive. Try again.");
                }
            }

            // Step 4: Calculate BMI and store it
            double bmi = personData[i][1] / (personData[i][0] * personData[i][0]);
            personData[i][2] = bmi;

            // Step 5: Determine weight status
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi >= 25 && bmi < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Step 6: Display results
        System.out.println("\n--- BMI Report ---");
        System.out.printf("%-10s%-12s%-10s%-15s\n", "Height(m)", "Weight(kg)", "BMI", "Status");

        for (int i = 0; i < number; i++) {
            System.out.printf("%-10.2f%-12.2f%-10.2f%-15s\n",
                    personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }

        sc.close();
    }
}

