package Strings;

import java.util.Scanner;

public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];
        int length = 0;

        while (true) {
            try {
                text.charAt(length);
                length++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

        for (int i = 0; i < length; i++) {
            freq[text.charAt(i)]++;
        }

        for (int i = 0; i < length; i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        char result = findFirstNonRepeatingChar(input);

        if (result == '\0') {
            System.out.println("No non-repeating character found.");
        } else {
            System.out.println("First non-repeating character: " + result);
        }
    }
}

