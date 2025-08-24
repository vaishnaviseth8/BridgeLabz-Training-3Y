package methods;

import java.util.Scanner;

public class NumberChecker2 {

    public static int countDigits(int number) {
        int count = 0;
        int temp = number;
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        return count;
    }

    public static int[] getDigitsArray(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        int index = count - 1;
        while (number > 0) {
            digits[index--] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return sum != 0 && number % sum == 0;
    }

    public static String[][] digitFrequency(int[] digits) {
        int[] freq = new int[10];

        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) count++;
        }

        String[][] result = new String[count][2];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                result[index][0] = String.valueOf(i);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        int[] digits = getDigitsArray(number);

        System.out.println("\nDigits:");
        for (int d : digits) {
            System.out.print(d + " ");
        }

        int digitCount = countDigits(number);
        int digitSum = sumOfDigits(digits);
        int squareSum = sumOfSquares(digits);
        boolean isHarshad = isHarshadNumber(number, digits);
        String[][] freq = digitFrequency(digits);

        System.out.println("\n\nCount of Digits: " + digitCount);
        System.out.println("Sum of Digits: " + digitSum);
        System.out.println("Sum of Squares of Digits: " + squareSum);
        System.out.println("Is Harshad Number? " + (isHarshad ? "Yes" : "No"));

        System.out.println("\nDigit Frequencies:");
        System.out.println("Digit\tFrequency");
        for (String[] row : freq) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }
}

