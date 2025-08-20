package Arrays;

import java.util.Scanner;

public class ZaraBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Arrays for 10 employees
        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        // Totals
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        System.out.println("Enter salary and years of service for 10 employees:");

        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1));

            // Input validation loop
            System.out.print("Enter salary: ");
            double s = sc.nextDouble();

            System.out.print("Enter years of service: ");
            double y = sc.nextDouble();

            if (s <= 0 || y < 0) {
                System.out.println("Invalid input. Salary must be > 0 and years >= 0. Please re-enter.\n");
                i--; // decrement index to repeat for same employee
                continue;
            }

            salary[i] = s;
            yearsOfService[i] = y;
        }

        // Calculate bonus, new salary, and totals
        for (int i = 0; i < 10; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }

            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        // Display results
        System.out.println("\nBonus details for employees:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Employee %d => Old Salary: ₹%.2f | Bonus: ₹%.2f | New Salary: ₹%.2f\n",
                    (i + 1), salary[i], bonus[i], newSalary[i]);
        }

        // Display totals
        System.out.println("\n--- Company Totals ---");
        System.out.printf("Total Old Salary: ₹%.2f\n", totalOldSalary);
        System.out.printf("Total Bonus Paid: ₹%.2f\n", totalBonus);
        System.out.printf("Total New Salary: ₹%.2f\n", totalNewSalary);

        sc.close();
    }
}

