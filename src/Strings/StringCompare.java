package Strings;

import java.util.Scanner;

public class StringCompare {


    public static boolean compareUsingCharAt(String str1, String str2) {
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


        System.out.print("Enter first string: ");
        String input1 = scanner.next();

        System.out.print("Enter second string: ");
        String input2 = scanner.next();


        boolean manualResult = compareUsingCharAt(input1, input2);


        boolean builtInResult = input1.equals(input2);


        System.out.println("\nManual comparison result (using charAt): " + manualResult);
        System.out.println("Built-in equals() result: " + builtInResult);


        if (manualResult == builtInResult) {
            System.out.println("Both methods give the same result.");
        } else {
            System.out.println(" Results do not match. Something went wrong.");
        }

        scanner.close();
    }
}

