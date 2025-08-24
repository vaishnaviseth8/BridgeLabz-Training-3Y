package Strings;

import java.util.Scanner;

public class PalindromeCheck {

    public static int getLength(String str) {
        int count = 0;
        while (true) {
            try {
                str.charAt(count);
                count++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }

    // Logic 1: Iterative palindrome check
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = getLength(text) - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive palindrome check
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Using char arrays and reverse
    public static char[] reverseStringUsingCharAt(String text) {
        int length = getLength(text);
        char[] reverse = new char[length];
        for (int i = 0; i < length; i++) {
            reverse[i] = text.charAt(length - 1 - i);
        }
        return reverse;
    }

    public static boolean isPalindromeCharArray(String text) {
        char[] original = text.toCharArray();
        char[] reverse = reverseStringUsingCharAt(text);
        if (original.length != reverse.length) return false;
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String input = scanner.nextLine();

        boolean iterativeResult = isPalindromeIterative(input);
        boolean recursiveResult = isPalindromeRecursive(input, 0, input.length() - 1);
        boolean charArrayResult = isPalindromeCharArray(input);

        System.out.println("Palindrome Check using Iterative method: " + iterativeResult);
        System.out.println("Palindrome Check using Recursive method: " + recursiveResult);
        System.out.println("Palindrome Check using Char Array method: " + charArrayResult);
    }
}

