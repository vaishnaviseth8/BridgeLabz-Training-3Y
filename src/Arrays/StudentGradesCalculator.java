package Arrays;

import java.util.Scanner;

public class StudentGradesCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take number of students
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();

        // Step 2: Create arrays to store marks, percentages, and grades
        int[][] marks = new int[numStudents][3]; // 0: Physics, 1: Chemistry, 2: Maths
        double[] percentage = new double[numStudents];
        String[] grades = new String[numStudents];

        // Step 3: Input marks
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";

                while (true) {
                    System.out.print(subject + " marks: ");
                    int mark = sc.nextInt();

                    if (mark >= 0 && mark <= 100) {
                        marks[i][j] = mark;
                        break;
                    } else {
                        System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                    }
                }
            }

            // Step 4: Calculate percentage
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            // Step 5: Assign grade based on percentage
            if (percentage[i] >= 90) {
                grades[i] = "A+";
            } else if (percentage[i] >= 80) {
                grades[i] = "A";
            } else if (percentage[i] >= 70) {
                grades[i] = "B";
            } else if (percentage[i] >= 60) {
                grades[i] = "C";
            } else if (percentage[i] >= 50) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }

        // Step 6: Display results
        System.out.println("\n--- Student Report ---");
        System.out.printf("%-10s%-10s%-10s%-12s%-10s%-6s\n", "Physics", "Chemistry", "Maths", "Percentage", "Grade", "");

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-10d%-10d%-10d%-12.2f%-10s\n",
                    marks[i][0], marks[i][1], marks[i][2], percentage[i], grades[i]);
        }

        sc.close();
    }
}

