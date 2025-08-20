package Control_flow;

import java.util.Scanner;

public class RocketLaunchCountdown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get input value for countdown
        System.out.print("Enter starting number for countdown: ");
        int counter = sc.nextInt();

        // While loop to countdown to 1
        while (counter >= 1) {
            System.out.println(counter);
            counter--; // Decrement the counter
        }

        // Final message after countdown
        System.out.println("Liftoff! 🚀");

        sc.close();
    }
}

