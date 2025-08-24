package methods;
import java.util.Arrays;

public class ZaraBonusCalculator {


    public static int[][] generateSalaryAndService() {
        int[][] empData = new int[10][2];

        for (int i = 0; i < 10; i++) {

            int salary = (int) (Math.random() * 90000) + 10000;
            int years = (int) (Math.random() * 11);

            empData[i][0] = salary;
            empData[i][1] = years;
        }
        return empData;
    }


    public static double[][] calculateBonusAndNewSalary(int[][] empData) {
        double[][] newData = new double[10][2];

        for (int i = 0; i < empData.length; i++) {
            int oldSalary = empData[i][0];
            int years = empData[i][1];
            double bonusRate = (years > 5) ? 0.05 : 0.02;
            double bonusAmount = oldSalary * bonusRate;
            double newSalary = oldSalary + bonusAmount;

            newData[i][0] = newSalary;
            newData[i][1] = bonusAmount;
        }
        return newData;
    }


    public static void displaySummary(int[][] empData, double[][] newData) {
        double sumOldSalary = 0;
        double sumNewSalary = 0;
        double totalBonus = 0;

        System.out.println("Emp#  Old Salary  Years Service  Bonus Amount  New Salary");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < empData.length; i++) {
            int oldSalary = empData[i][0];
            int years = empData[i][1];
            double bonus = newData[i][1];
            double newSalary = newData[i][0];

            System.out.printf("%-5d %-11d %-14d %-12.2f %.2f\n", (i + 1), oldSalary, years, bonus, newSalary);

            sumOldSalary += oldSalary;
            sumNewSalary += newSalary;
            totalBonus += bonus;
        }

        System.out.println("----------------------------------------------------------");
        System.out.printf("Total %-10.2f       %-14s %-12.2f %.2f\n", sumOldSalary, "", totalBonus, sumNewSalary);
    }

    public static void main(String[] args) {
        int[][] empData = generateSalaryAndService();
        double[][] newData = calculateBonusAndNewSalary(empData);
        displaySummary(empData, newData);
    }
}

