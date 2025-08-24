package methods;

import java.util.Scanner;

public class BMICalculator {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightMeters = heightCm / 100;
            double bmi = weight / (heightMeters * heightMeters);
            data[i][2] = Math.round(bmi * 100.0) / 100.0;
        }
    }

    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi < 24.9) {
                status[i] = "Normal weight";
            } else if (bmi < 29.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        return status;
    }

    public static void displayBMIReport(double[][] data, String[] status) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Person", "Weight", "Height", "BMI Status");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Person%-3d %-10.2f %-10.2f %-15s\n",
                    (i + 1), data[i][0], data[i][1], status[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] bmiData = new double[10][3];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for Person " + (i + 1) + ": ");
            bmiData[i][0] = scanner.nextDouble();

            System.out.print("Enter height (cm) for Person " + (i + 1) + ": ");
            bmiData[i][1] = scanner.nextDouble();
        }

        calculateBMI(bmiData);
        String[] bmiStatus = getBMIStatus(bmiData);
        displayBMIReport(bmiData, bmiStatus);
    }
}

