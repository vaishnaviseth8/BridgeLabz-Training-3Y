package methods;

import java.util.Scanner;

public class TriangleParkRun {

    public static double calculateRounds(double a, double b, double c, double totalDistanceInKm) {
        double perimeter = a + b + c;
        double totalDistanceInMeters = totalDistanceInKm * 1000;
        return totalDistanceInMeters / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter side A of the triangular park (in meters): ");
        double a = scanner.nextDouble();

        System.out.print("Enter side B of the triangular park (in meters): ");
        double b = scanner.nextDouble();

        System.out.print("Enter side C of the triangular park (in meters): ");
        double c = scanner.nextDouble();

        double rounds = calculateRounds(a, b, c, 5);

        System.out.println("The athlete must complete " + Math.ceil(rounds) + " rounds to complete a 5 km run.");
    }
}

