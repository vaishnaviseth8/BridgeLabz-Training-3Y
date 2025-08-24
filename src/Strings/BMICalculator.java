package Strings;
import java.util.Scanner;

public class BMICalculator {

    public static String[] calculateBMIandStatus(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        bmi = Math.round(bmi * 100.0) / 100.0;

        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{String.valueOf(bmi), status};
    }

    public static String[][] computeBMIForTeam(double[][] data) {
        int n = data.length;
        String[][] result = new String[n][4];

        for (int i = 0; i < n; i++) {
            double weight = data[i][0];
            double height = data[i][1];
            String[] bmiAndStatus = calculateBMIandStatus(weight, height);

            result[i][0] = String.format("%.2f", height);
            result[i][1] = String.format("%.2f", weight);
            result[i][2] = bmiAndStatus[0];
            result[i][3] = bmiAndStatus[1];
        }
        return result;
    }

    public static void displayBMIResults(String[][] data) {
        System.out.println("Person\tHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d\t%s\t\t%s\t\t%s\t\t%s\n",
                    i + 1,
                    data[i][0],
                    data[i][1],
                    data[i][2],
                    data[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int teamSize = 10;
        double[][] personData = new double[teamSize][2];

        for (int i = 0; i < teamSize; i++) {
            System.out.printf("Enter weight (kg) for person %d: ", i + 1);
            personData[i][0] = scanner.nextDouble();

            System.out.printf("Enter height (cm) for person %d: ", i + 1);
            personData[i][1] = scanner.nextDouble();
        }

        String[][] bmiResults = computeBMIForTeam(personData);
        displayBMIResults(bmiResults);
    }
}
