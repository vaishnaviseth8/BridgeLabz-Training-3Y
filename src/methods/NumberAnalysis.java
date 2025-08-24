package methods;

import java.util.Scanner;

public class NumberAnalysis {

    public static boolean isPositive(int number) {
        return number >= 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int num1, int num2) {
        if (num1 > num2) {
            return 1;
        } else if (num1 == num2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // Input
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Processing
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + numbers[i] + " is ");
            if (isPositive(numbers[i])) {
                System.out.print("Positive and ");
                if (isEven(numbers[i])) {
                    System.out.println("Even.");
                } else {
                    System.out.println("Odd.");
                }
            } else {
                System.out.println("Negative.");
            }
        }

        // Comparison of first and last elements
        int result = compare(numbers[0], numbers[4]);
        System.out.print("First number (" + numbers[0] + ") is ");
        if (result == 1) {
            System.out.println("greater than the last number (" + numbers[4] + ").");
        } else if (result == 0) {
            System.out.println("equal to the last number (" + numbers[4] + ").");
        } else {
            System.out.println("less than the last number (" + numbers[4] + ").");
        }
    }
}

