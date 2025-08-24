package Strings;

import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void generateException(String str) {
        String sub = str.substring(5, 2);
        System.out.println("Substring: " + sub);
    }

    public static void handleException(String str) {
        try {
            String sub = str.substring(5, 2);
            System.out.println("Substring: " + sub);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.next();

        try {
            generateException(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception generated: " + e);
        }

        handleException(input);
    }
}

