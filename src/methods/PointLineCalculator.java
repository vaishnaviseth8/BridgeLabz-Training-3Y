package methods;
import java.util.Scanner;

public class PointLineCalculator {

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double m, b;
        if (x2 == x1) {
            m = Double.POSITIVE_INFINITY;
            b = Double.NaN;
        } else {
            m = (y2 - y1) / (x2 - x1);
            b = y1 - m * x1;
        }
        return new double[]{m, b};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.printf("Euclidean distance between the points: %.4f%n", distance);

        double[] lineEquation = findLineEquation(x1, y1, x2, y2);

        if (Double.isInfinite(lineEquation[0])) {
            System.out.println("The line is vertical. Equation: x = " + x1);
        } else {
            System.out.printf("Equation of the line: y = %.4fx + %.4f%n", lineEquation[0], lineEquation[1]);
        }
    }
}

