package Arrays;

import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Create an array to store the heights
        double[] heights = new double[11];

        // Step 2: Input heights of 11 players
        System.out.println("Enter the heights (in cm or m) of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
        }

        // Step 3: Calculate the sum of heights
        double sum = 0.0;
        for (double h : heights) {
            sum += h;
        }

        // Step 4: Calculate the mean
        double mean = sum / heights.length;

        // Step 5: Display the result
        System.out.printf("The mean height of the football team is: %.2f\n", mean);

        sc.close();
    }
}

