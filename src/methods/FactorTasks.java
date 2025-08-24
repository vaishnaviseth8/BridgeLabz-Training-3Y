package methods;

import java.util.Scanner;

public class FactorTasks {


    public static int[] findFactors(int number) {

        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }


        int[] factors = new int[count];
        int index = 0;


        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }


    public static int findGreatestFactor(int[] factors) {

        if (factors.length > 1) {
            return factors[factors.length - 2];
        }
        return factors[0];
    }


    public static int findSumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }


    public static long findProductOfFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }


    public static double findProductOfCubeOfFactors(int[] factors) {
        double product = 1.0;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer greater than zero.");
            return;
        }

        int[] factors = findFactors(number);

        System.out.print("Factors of " + number + " are: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }
        System.out.println();

        int greatestFactor = findGreatestFactor(factors);
        System.out.println("Greatest factor (excluding the number itself): " + greatestFactor);

        int sumOfFactors = findSumOfFactors(factors);
        System.out.println("Sum of factors: " + sumOfFactors);

        long productOfFactors = findProductOfFactors(factors);
        System.out.println("Product of factors: " + productOfFactors);

        double productOfCubeFactors = findProductOfCubeOfFactors(factors);
        System.out.println("Product of cube of factors: " + productOfCubeFactors);
    }
}

