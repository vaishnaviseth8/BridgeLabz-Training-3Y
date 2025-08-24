package methods;

import java.util.Scanner;

public class NumberChecker4 {

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isNeon(int number) {
        int square = number * number;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }

    public static boolean isSpy(int number) {
        int sum = 0, product = 1;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            product *= digit;
            number /= 10;
        }
        return sum == product;
    }

    public static boolean isAutomorphic(int number) {
        int square = number * number;
        String numStr = String.valueOf(number);
        String squareStr = String.valueOf(square);
        return squareStr.endsWith(numStr);
    }

    public static boolean isBuzz(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        System.out.println("\n--- Number Check Results ---");
        System.out.println("Is Prime?         : " + (isPrime(number) ? "Yes" : "No"));
        System.out.println("Is Neon?          : " + (isNeon(number) ? "Yes" : "No"));
        System.out.println("Is Spy?           : " + (isSpy(number) ? "Yes" : "No"));
        System.out.println("Is Automorphic?   : " + (isAutomorphic(number) ? "Yes" : "No"));
        System.out.println("Is Buzz?          : " + (isBuzz(number) ? "Yes" : "No"));
    }
}

