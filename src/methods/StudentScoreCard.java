package methods;

import java.util.Random;
import java.util.Scanner;

public class StudentScoreCard {

    public static int[][] generateScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][3];  // Physics, Chemistry, Maths
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 10 + rand.nextInt(90); // 10 to 99
            }
        }
        return scores;
    }

    public static double[][] calculateTotalAvgPercent(int[][] scores) {
        int numStudents = scores.length;
        double[][] result = new double[numStudents][3]; // total, avg, percent

        for (int i = 0; i < numStudents; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = (double) total / 3;
            double percent = (double) total / 300 * 100;

            // Round off to 2 decimal places
            result[i][0] = Math.round(total * 100.0) / 100.0;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percent * 100.0) / 100.0;
        }

        return result;
    }

    public static void displayScoreCard(int[][] scores, double[][] stats) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        for (int i = 0; i < scores.length; i++) {
            System.out.print((i+1) + "\t");
            System.out.print(scores[i][0] + "\t");
            System.out.print(scores[i][1] + "\t\t");
            System.out.print(scores[i][2] + "\t");
            System.out.print((int)stats[i][0] + "\t");
            System.out.print(stats[i][1] + "\t");
            System.out.print(stats[i][2]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();

        int[][] scores = generateScores(numStudents);
        double[][] stats = calculateTotalAvgPercent(scores);

        displayScoreCard(scores, stats);

        sc.close();
    }
}
