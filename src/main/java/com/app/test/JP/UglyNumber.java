package com.app.test.JP;

/*

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return true if n is an ugly number.



Example 1:

Input: n = 6
Output: true
Explanation: 6 = 2 × 3
Example 2:

Input: n = 1
Output: true
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
Example 3:

Input: n = 14
Output: false
Explanation: 14 is not ugly since it includes the prime factor 7.


Constraints:

-231 <= n <= 231 - 1

Time Complexity:

In the worst-case scenario, the while loop inside the isUgly() method will run until n becomes 1.
For each iteration of the while loop, we perform constant-time operations.
Therefore, the time complexity of the solution is O(log n), where n is the input number.
Space Complexity:

The space complexity of the solution is O(1) because we are using a constant amount of extra space regardless of the input size.
We only use a fixed-size array primes to store the prime numbers 2, 3, and 5, and a few integer variables for calculations.
Hence, the space complexity is constant, O(1).
In summary:

Time complexity: O(log n)
Space complexity: O(1)
 */

public class UglyNumber {
    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        int[] primes = {2, 3, 5};

        for (int prime : primes) {
            while (n % prime == 0) {
                n /= prime;
            }
        }

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(6));  // Output: true
        System.out.println(isUgly(1));  // Output: true
        System.out.println(isUgly(14)); // Output: false
    }
}
