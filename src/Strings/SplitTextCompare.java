package Strings;
import java.util.Scanner;

public class SplitTextCompare {

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

    public static String[] manualSplit(String text) {
        int length = getLength(text);
        int spaceCount = 0;

        // Count spaces
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int[] spaceIndexes = new int[spaceCount];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }

        String[] words = new String[spaceCount + 1];
        int start = 0;

        for (int i = 0; i < spaceCount; i++) {
            int end = spaceIndexes[i];
            StringBuilder word = new StringBuilder();
            for (int j = start; j < end; j++) {
                word.append(text.charAt(j));
            }
            words[i] = word.toString();
            start = end + 1;
        }

        // Last word after last space
        StringBuilder lastWord = new StringBuilder();
        for (int i = start; i < length; i++) {
            lastWord.append(text.charAt(i));
        }
        words[spaceCount] = lastWord.toString();

        return words;
    }

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a line of text: ");
        String input = scanner.nextLine();

        String[] manualWords = manualSplit(input);
        String[] builtInWords = input.split(" ");

        boolean areEqual = compareStringArrays(manualWords, builtInWords);

        System.out.println("\nManual split words:");
        for (String w : manualWords) {
            System.out.println(w);
        }

        System.out.println("\nBuilt-in split words:");
        for (String w : builtInWords) {
            System.out.println(w);
        }

        System.out.println("\nAre both splits equal? " + areEqual);
    }
}

