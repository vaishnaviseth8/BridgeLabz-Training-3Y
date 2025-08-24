package Strings;

import java.util.Scanner;

public class ShortestLongestWords {

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

        StringBuilder lastWord = new StringBuilder();
        for (int i = start; i < length; i++) {
            lastWord.append(text.charAt(i));
        }
        words[spaceCount] = lastWord.toString();

        return words;
    }

    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            int len = getLength(words[i]);
            result[i][0] = words[i];
            result[i][1] = String.valueOf(len);
        }
        return result;
    }

    public static int[] findShortestLongest(String[][] wordsLen) {
        int shortestIndex = 0;
        int longestIndex = 0;

        int shortestLen = Integer.parseInt(wordsLen[0][1]);
        int longestLen = shortestLen;

        for (int i = 1; i < wordsLen.length; i++) {
            int currentLen = Integer.parseInt(wordsLen[i][1]);
            if (currentLen < shortestLen) {
                shortestLen = currentLen;
                shortestIndex = i;
            }
            if (currentLen > longestLen) {
                longestLen = currentLen;
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a line of text: ");
        String input = scanner.nextLine();

        String[] words = manualSplit(input);
        String[][] wordsLen = wordsWithLengths(words);

        int[] indices = findShortestLongest(wordsLen);

        System.out.println("\nShortest word: " + wordsLen[indices[0]][0] + " (Length: " + wordsLen[indices[0]][1] + ")");
        System.out.println("Longest word: " + wordsLen[indices[1]][0] + " (Length: " + wordsLen[indices[1]][1] + ")");
    }
}

