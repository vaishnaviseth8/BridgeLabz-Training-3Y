package Control_flow;

import java.util.Scanner;

public class PowerCalculato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input base and exponent
        System.out.print("Enter the base number: ");
        int number = sc.nextInt();

        System.out.print("Enter the power: ");
        int power = sc.nextInt();

        // Initialize result and counter
        int result = 1;
        int counter = 0;

        // Loop to calculate power
        while (counter != power) {
            result = result * number;
            counter++;
        }

        // Output the result
        System.out.println(number + " raised to the power " + power + " is: " + result);

        sc.close();
    }
}

