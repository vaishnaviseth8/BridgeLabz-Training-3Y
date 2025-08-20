package Arrays;
import java.util.Scanner;

public class StudentGradesWith2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number of students
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();

        // Step 2: Create 2D array for marks [numStudents][3] and other arrays
        int[][] marks = new int[numStudents][3]; // 0: Physics, 1: Chemistry, 2: Maths
        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];

        // Step 3: Input marks and validate
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
                        System.out.println("Invalid! Enter marks between 0 and 100.");
                    }
                }
            }

            // Step 4: Calculate percentage
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = total / 3.0;

            // Step 5: Determine grade
            if (percentages[i] >= 90)
                grades[i] = "A+";
            else if (percentages[i] >= 80)
                grades[i] = "A";
            else if (percentages[i] >= 70)
                grades[i] = "B";
            else if (percentages[i] >= 60)
                grades[i] = "C";
            else if (percentages[i] >= 50)
                grades[i] = "D";
            else
                grades[i] = "F";
        }

        // Step 6: Display results
        System.out.println("\n--- Student Report ---");
        System.out.printf("%-10s%-10s%-10s%-15s%-10s\n", "Physics", "Chemistry", "Maths", "Percentage", "Grade");

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-10d%-10d%-10d%-15.2f%-10s\n",
                    marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }

        sc.close();
    }
}

