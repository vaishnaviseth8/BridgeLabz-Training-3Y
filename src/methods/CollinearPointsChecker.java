package methods;

import java.util.Scanner;

public class CollinearPointsChecker {

    public static boolean areCollinearUsingSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        double slopeAB, slopeBC, slopeAC;

        if (x2 - x1 == 0) {
            if (x3 - x2 == 0) {
                return (x3 - x1 == 0);
            } else {
                return false;
            }
        }

        if (x3 - x2 == 0) {
            return false;
        }


        slopeAB = (double)(y2 - y1) / (x2 - x1);
        slopeBC = (double)(y3 - y2) / (x3 - x2);
        slopeAC = (double)(y3 - y1) / (x3 - x1);


        double epsilon = 1e-9;
        return (Math.abs(slopeAB - slopeBC) < epsilon) && (Math.abs(slopeBC - slopeAC) < epsilon);
    }


    public static boolean areCollinearUsingArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * (x1 * (y2 - y3) +
                x2 * (y3 - y1) +
                x3 * (y1 - y2));

        return Math.abs(area) < 1e-9;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter coordinates of Point A (x1 y1): ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();

        System.out.println("Enter coordinates of Point B (x2 y2): ");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        System.out.println("Enter coordinates of Point C (x3 y3): ");
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        boolean collinearSlope = areCollinearUsingSlope(x1, y1, x2, y2, x3, y3);
        boolean collinearArea = areCollinearUsingArea(x1, y1, x2, y2, x3, y3);

        System.out.println("Using slope method, points are collinear? " + collinearSlope);
        System.out.println("Using area method, points are collinear? " + collinearArea);

    }
}

