package Control_flow;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input for weight and height
        System.out.print("Enter your weight in kilograms: ");
        double weight = sc.nextDouble();

        System.out.print("Enter your height in centimeters: ");
        double heightCm = sc.nextDouble();

        // Step 2: Convert height from cm to meters
        double heightMeters = heightCm / 100;

        // Step 3: Calculate BMI using the formula
        double bmi = weight / (heightMeters * heightMeters);

        // Step 4: Print BMI and determine category
        System.out.printf("Your BMI is: %.2f\n", bmi);

        System.out.print("Weight Status: ");
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("Normal weight");
        } else if (bmi >= 25 && bmi < 29.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }

        sc.close();
    }
}

