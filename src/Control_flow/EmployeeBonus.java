package Control_flow;

import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter your years of service: ");
        int years = sc.nextInt();

        // Calculate and display bonus
        if (years > 5) {
            double bonus = salary * 0.05;
            System.out.println("Your bonus is ₹" + bonus);
        } else {
            System.out.println("No bonus! You need more than 5 years of service.");
        }

        sc.close();
    }
}

