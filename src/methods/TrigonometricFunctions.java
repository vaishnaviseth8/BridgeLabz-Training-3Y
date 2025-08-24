package methods;

import java.util.Scanner;

public class TrigonometricFunctions {

    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double[] results = new double[3];
        results[0] = Math.sin(radians);  // sine
        results[1] = Math.cos(radians);  // cosine
        results[2] = Math.tan(radians);  // tangent
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter angle in degrees: ");
        double angle = scanner.nextDouble();

        double[] trigValues = calculateTrigonometricFunctions(angle);

        System.out.printf("Sine: %.4f\n", trigValues[0]);
        System.out.printf("Cosine: %.4f\n", trigValues[1]);
        System.out.printf("Tangent: %.4f\n", trigValues[2]);
    }
}
