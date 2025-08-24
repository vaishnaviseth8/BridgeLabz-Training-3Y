package Strings;

import java.util.Scanner;

public class CharTypeFinder {

    public static String checkChar(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    public static String[][] findCharTypes(String str) {
        int length = 0;
        while (true) {
            try {
                str.charAt(length);
                length++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

        String[][] result = new String[length][2];
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkChar(ch);
        }
        return result;
    }

    public static void displayCharTypes(String[][] arr) {
        System.out.println("Character\tType");
        System.out.println("-----------------------");
        for (String[] row : arr) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[][] charTypes = findCharTypes(input);

        displayCharTypes(charTypes);
    }
}

