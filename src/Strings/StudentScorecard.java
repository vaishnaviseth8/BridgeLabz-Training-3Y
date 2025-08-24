package Strings;

import java.util.Random;

public class StudentScorecard {


    public static int[][] generateScores(int n) {
        Random rand = new Random();
        int[][] scores = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = rand.nextInt(91) + 10;
            }
        }
        return scores;
    }


    public static double[][] calculateStats(int[][] scores) {
        int n = scores.length;
        double[][] stats = new double[n][3];

        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = (double) total / 3.0;
            double percentage = ((double) total / 300.0) * 100.0;

            stats[i][0] = Math.round(total * 100.0) / 100.0;
            stats[i][1] = Math.round(avg * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }


    public static String[] calculateGrades(double[][] stats) {
        int n = stats.length;
        String[] grades = new String[n];

        for (int i = 0; i < n; i++) {
            double percent = stats[i][2];

            if (percent >= 90) {
                grades[i] = "A+";
            } else if (percent >= 80) {
                grades[i] = "A";
            } else if (percent >= 70) {
                grades[i] = "B+";
            } else if (percent >= 60) {
                grades[i] = "B";
            } else if (percent >= 50) {
                grades[i] = "C";
            } else if (percent >= 40) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }

        return grades;
    }


    public static void displayScorecard(int[][] scores, double[][] stats, String[] grades) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("-------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%.0f\t%.2f\t%.2f\t\t%s\n",
                    i + 1,
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    stats[i][0],
                    stats[i][1],
                    stats[i][2],
                    grades[i]);
        }
    }

    public static void main(String[] args) {
        int numberOfStudents = 5;

        int[][] scores = generateScores(numberOfStudents);
        double[][] stats = calculateStats(scores);
        String[] grades = calculateGrades(stats);

        displayScorecard(scores, stats, grades);
    }
}

