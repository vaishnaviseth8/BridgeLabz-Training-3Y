package Strings;

import java.util.Scanner;

public class CharFrequency {

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

    public static String[][] findCharFrequency(String text) {
        int[] freq = new int[256];
        int length = getLength(text);

        for (int i = 0; i < length; i++) {
            freq[text.charAt(i)]++;
        }

        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) uniqueCount++;
        }

        String[][] result = new String[uniqueCount][2];
        int index = 0;

        for (int i = 0; i < length; i++) {
            int ascii = text.charAt(i);
            if (freq[ascii] != 0) {
                result[index][0] = String.valueOf((char) ascii);
                result[index][1] = String.valueOf(freq[ascii]);
                freq[ascii] = 0; // mark as processed
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[][] freqData = findCharFrequency(input);

        System.out.println("Character\tFrequency");
        for (String[] row : freqData) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }
}
