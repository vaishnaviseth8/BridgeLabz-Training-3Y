package Strings;

import java.util.Scanner;

public class UppercaseCompare {

    public static String convertToUpperUsingCharAt(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);
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

        String manualUpper = convertToUpperUsingCharAt(input);
        String builtInUpper = input.toUpperCase();

        boolean isEqual = compareStringsUsingCharAt(manualUpper, builtInUpper);

        System.out.println("\nManual uppercase: " + manualUpper);
        System.out.println("Built-in uppercase: " + builtInUpper);
        System.out.println("Are both uppercase strings equal? " + isEqual);
    }
}

