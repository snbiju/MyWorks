package com.app.test.GS;

/*

Complexity Analysis
Time Complexity: O(1)

The while loop runs a fixed number of times (at most 10 times for the powers of ten from
1
0
0
10
0
  to
1
0
9
10
9
 ), so it is considered constant time.
Space Complexity: O(1)

Only a few integer variables are used, which require constant space.
 */
public class PowerOfNumber {

    public static boolean isPowerOfThrees(int n) {

        if (n < 1)
            return false;
        if (n == 1)
            return true;
        while (n != 1) {
            if (n % 3 != 0) {
                return false;
            }

            n = n / 3;

        }
        return true;

    }

    public static boolean isPowerOfTens(int n) {
        if (n < 1) {
            return false;
        }
        while (n > 1) {
            if (n % 10 != 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }


    public static boolean isPowerOfThree(int n) {
        // The maximum power of three that fits in an int (3^19 = 1162261467)
        final int MAX_POWER_OF_THREE = 1162261467;

        // Check the basic cases
        if (n <= 0) {
            return false;
        }


        // If n is a divisor of 3^19, then n is a power of three
        return MAX_POWER_OF_THREE % n == 0;
    }

    public static boolean isPowerOfThrees1(int n) {

        boolean result = false;
        if (n < 1)
            return result;
        if (n == 1)
            return true;
        while (n != 1) {
            if (n % 3 != 0) {
                result = false;
                break;
            } else {
                result = true;
            }
            n = n / 3;

        }
        return result;

    }

    public static boolean isPowerOfTen(int n) {
        // The maximum power of ten that fits in an int (10^9 = 1,000,000,000)
        final int MAX_POWER_OF_TEN = 1000000000;

        // Check the basic cases
        if (n <= 0) {
            return false;
        }

        // Check if n is a divisor of 10^9
        if (MAX_POWER_OF_TEN % n != 0) {
            return false;
        }

        // Ensure that n is actually a power of ten
        // Iterate through the possible powers of ten
        int powerOfTen = 1;
        while (powerOfTen <= n) {
            if (powerOfTen == n) {
                return true;
            }
            powerOfTen *= 10;
        }

        return false;
    }

    public static boolean isPowerOfTens1(int n) {

        boolean result = false;
        if (n < 1)
            return result;
        if (n == 1)
            return true;
        while (n != 1) {
            if (n % 10 != 0) {
                result = false;
                break;
            } else {
                result = true;
            }
            n = n / 10;
        }
        return result;

    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isPowerOfThree(27));  // Output: true
        System.out.println(isPowerOfThree(0));   // Output: false
        System.out.println(isPowerOfThree(-1));  // Output: false
        System.out.println(isPowerOfThree(1));   // Output: true (3^0 = 1)


        System.out.println("------------");
        // Test cases
        System.out.println(isPowerOfTen(10));        // Output: true
        System.out.println(isPowerOfTen(100));       // Output: true
        System.out.println(isPowerOfTen(1000));      // Output: true
        System.out.println(isPowerOfTen(5000));      // Output: false
        System.out.println(isPowerOfTen(1));         // Output: true (10^0 = 1)
        System.out.println(isPowerOfTen(0));         // Output: false
        System.out.println(isPowerOfTen(-10));       // Output: false

        System.out.println("------------");

        System.out.println(isPowerOfThrees(27));  // Output: true
        System.out.println(isPowerOfThrees(0));   // Output: false
        System.out.println(isPowerOfThrees(-1));  // Output: false
        System.out.println(isPowerOfThrees(1));   // Output: true (3^0 = 1)

        System.out.println("------------");
        // Test cases
        System.out.println(isPowerOfTens(10));        // Output: true
        System.out.println(isPowerOfTens(100));       // Output: true
        System.out.println(isPowerOfTens(1000));      // Output: true
        System.out.println(isPowerOfTens(5000));      // Output: false
        System.out.println(isPowerOfTens(1));         // Output: true (10^0 = 1)
        System.out.println(isPowerOfTens(0));         // Output: false
        System.out.println(isPowerOfTens(-10));       // Output: false

    }
}
