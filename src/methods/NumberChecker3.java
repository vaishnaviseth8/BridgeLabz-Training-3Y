package methods;

import java.util.Scanner;
import java.util.Arrays;

public class NumberChecker3 {

    public static int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static int[] getDigitsArray(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        int index = count - 1;
        while (number > 0) {
            digits[index--] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int[] reverseArray(int[] original) {
        int[] reversed = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return reversed;
    }

    public static boolean areArraysEqual(int[] a1, int[] a2) {
        if (a1.length != a2.length) return false;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }

    public static boolean isPalindrome(int number) {
        int[] digits = getDigitsArray(number);
        int[] reversed = reverseArray(digits);
        return areArraysEqual(digits, reversed);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        int[] digits = getDigitsArray(number);
        int[] reversed = reverseArray(digits);

        System.out.print("\nDigits: ");
        for (int d : digits) System.out.print(d + " ");

        System.out.print("\nReversed: ");
        for (int d : reversed) System.out.print(d + " ");

        boolean palindrome = isPalindrome(number);
        boolean duck = isDuckNumber(digits);

        System.out.println("\n\nIs Palindrome? " + (palindrome ? "Yes" : "No"));
        System.out.println("Is Duck Number? " + (duck ? "Yes" : "No"));
    }
}

