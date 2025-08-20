package Control_flow;

import java.util.Scanner;

public class YoungestAndTallestFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Amar
        System.out.print("Enter Amar's age: ");
        int amarAge = sc.nextInt();
        System.out.print("Enter Amar's height (in cm): ");
        int amarHeight = sc.nextInt();

        // Input for Akbar
        System.out.print("Enter Akbar's age: ");
        int akbarAge = sc.nextInt();
        System.out.print("Enter Akbar's height (in cm): ");
        int akbarHeight = sc.nextInt();

        // Input for Anthony
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = sc.nextInt();
        System.out.print("Enter Anthony's height (in cm): ");
        int anthonyHeight = sc.nextInt();

        // Finding the youngest
        String youngest;
        int minAge = Math.min(amarAge, Math.min(akbarAge, anthonyAge));

        if (minAge == amarAge) {
            youngest = "Amar";
        } else if (minAge == akbarAge) {
            youngest = "Akbar";
        } else {
            youngest = "Anthony";
        }

        // Finding the tallest
        String tallest;
        int maxHeight = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));

        if (maxHeight == amarHeight) {
            tallest = "Amar";
        } else if (maxHeight == akbarHeight) {
            tallest = "Akbar";
        } else {
            tallest = "Anthony";
        }

        // Output results
        System.out.println("\nThe youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);

        sc.close();
    }
}

