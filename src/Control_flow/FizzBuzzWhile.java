package Control_flow;

import java.util.Scanner;

public class FizzBuzzWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        // Check if it's a natural number
        if (number <= 0) {
            System.out.println("The number " + number + " is not a natural number.");
        } else {
            System.out.println("FizzBuzz from 1 to " + number + ":");

            int i = 1; // Initialize counter
            while (i <= number) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
                i++; // Increment counter
            }
        }

        sc.close();
    }
}

