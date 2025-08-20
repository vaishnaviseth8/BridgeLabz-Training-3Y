package Control_flow;

import java.util.Scanner;

public class MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a positive integer less than 100: ");
        int number = sc.nextInt();

        // Check if number is valid
        if (number > 0 && number < 100) {
            System.out.println("Multiples of " + number + " below 100 are:");
            int counter = number;

            // Loop through all multiples until less than 100
            while (counter < 100) {
                System.out.println(counter);
                counter += number;
            }
        } else {
            System.out.println("Invalid input. Please enter a positive number less than 100.");
        }

        sc.close();
    }
}

