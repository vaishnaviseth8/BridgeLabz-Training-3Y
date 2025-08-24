package Strings;

import java.util.Scanner;

public class StringLengthWithoutLengthMethod {

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.next();

        int manualLength = getLength(input);
        int builtInLength = input.length();

        System.out.println("Length without length(): " + manualLength);
        System.out.println("Length using length(): " + builtInLength);
    }
}

