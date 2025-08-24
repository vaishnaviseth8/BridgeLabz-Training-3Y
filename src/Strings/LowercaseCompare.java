package Strings;

import java.util.Scanner;

public class LowercaseCompare {

    public static String convertToLowerUsingCharAt(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
            }
            result.append(ch);
        }
        return result.toString();
    }

    public static boolean compareStringsUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String input = scanner.nextLine();

        String manualLower = convertToLowerUsingCharAt(input);
        String builtInLower = input.toLowerCase();

        boolean isEqual = compareStringsUsingCharAt(manualLower, builtInLower);

        System.out.println("\nManual lowercase: " + manualLower);
        System.out.println("Built-in lowercase: " + builtInLower);
        System.out.println("Are both lowercase strings equal? " + isEqual);
    }
}

