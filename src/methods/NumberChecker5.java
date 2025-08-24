package methods;

import java.util.Scanner;

public class NumberChecker5 {

    public static boolean isPerfect(int number) {
        return sumOfProperDivisors(number) == number;
    }

    public static boolean isAbundant(int number) {
        return sumOfProperDivisors(number) > number;
    }

    public static boolean isDeficient(int number) {
        return sumOfProperDivisors(number) < number;
    }

    public static boolean isStrong(int number) {
        int original = number;
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += factorial(digit);
            number /= 10;
        }
        return sum == original;
    }

    private static int sumOfProperDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) sum += i;
        }
        return sum;
    }

    private static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        System.out.println("\n--- Number Classification ---");
        System.out.println("Is Perfect Number?   : " + (isPerfect(number) ? "Yes" : "No"));
        System.out.println("Is Abundant Number?  : " + (isAbundant(number) ? "Yes" : "No"));
        System.out.println("Is Deficient Number? : " + (isDeficient(number) ? "Yes" : "No"));
        System.out.println("Is Strong Number?    : " + (isStrong(number) ? "Yes" : "No"));
    }
}

