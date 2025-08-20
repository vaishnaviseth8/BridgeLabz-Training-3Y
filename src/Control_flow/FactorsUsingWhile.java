package Control_flow;

import java.util.Scanner;

public class FactorsUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        // Check if it's a natural number
        if (number > 0) {
            System.out.println("Factors of " + number + " are:");
            int counter = 1;

            // While loop to find factors
            while (counter <= number) {
                if (number % counter == 0) {
                    System.out.println(counter);
                }
                counter++;
            }
        } else {
            System.out.println("The number " + number + " is not a positive integer.");
        }

        sc.close();
    }
}

