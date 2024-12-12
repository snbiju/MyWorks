package com.app.codes.Sainsbury;

/*

The digit in the number must be in ascending order. A digit must be of same or greater value than the preceding digit.
So for a five-digit number 12345;11222 might be valid solution  but 12354;11131 will never be valid

Leading zeros are not allowed. i.e, 00123;01234 are not valid solutions.

max execution time 60 sec

eg:
input
2

output
11,12,13,14,15,16,17,18,19,22,23,24,25,26,27,28,29,33,34,35,36,37,38,39,44,45.......88,89,99
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AscendingOrderNumbers {

    public static String generateAscendingNumbers(int input) {
        List<String> numDigits = new ArrayList<>();
        generateNumbersRecursive("", '0', input, numDigits);
        return String.join(",", numDigits);
    }

    private static void generateNumbersRecursive(String prefix, char lastDigit, int remainingDigits, List<String> numDigits) {
        if (remainingDigits == 0) {
            if (!prefix.isEmpty() && prefix.charAt(0) != '0') {
                numDigits.add(prefix);
            }
            return;
        }

        for (char digit = lastDigit; digit <= '9'; digit++) {
            generateNumbersRecursive(prefix + digit, digit, remainingDigits - 1, numDigits);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of digits: ");
        int numDigits = scanner.nextInt();

        if (numDigits <= 0) {
            System.out.println("Invalid input. Number of digits should be greater than zero.");
            return;
        }

        String ascendingNumbers = generateAscendingNumbers(numDigits);
        System.out.println(ascendingNumbers);
    }
}
