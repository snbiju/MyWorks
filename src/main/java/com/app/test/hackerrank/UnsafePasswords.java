package com.app.test.hackerrank;
public class UnsafePasswords {
    public static void main(String[] args) {
        long L = 47;
        long R = 1024;
        System.out.println(solve(L, R)); // Output should be 98
    }

    static long solve(long L, long R) {
        long count = 0;

        // Iterate over each starting digit from 1 to 9
        for (int digit = 1; digit <= 9; digit++) {
            long number = digit;

            // Generate unsafe numbers of increasing length
            while (number <= R) {
                // If the number is in the range [L, R], count it
                if (number >= L) {
                    count++;
                }
                // Generate the next unsafe number with the same starting and ending digit
                number = generateNextUnsafeNumber(number, digit);
            }
        }

        return count;
    }

    // Generate the next unsafe number with the same starting and ending digit
    static long generateNextUnsafeNumber(long current, int digit) {
        String currentStr = Long.toString(current);
        int length = currentStr.length();
        StringBuilder nextStr = new StringBuilder();

        // Create a number with the same length where all digits are the same
        for (int i = 0; i < length; i++) {
            nextStr.append(digit);
        }

        long nextNumber = Long.parseLong(nextStr.toString());

        // If the next number is not larger, increase the length by adding an extra digit
        if (nextNumber <= current) {
            nextStr.append(digit);
            nextNumber = Long.parseLong(nextStr.toString());
        }

        return nextNumber;
    }
}
