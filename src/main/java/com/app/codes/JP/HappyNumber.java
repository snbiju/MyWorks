package com.app.codes.JP;

/*

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.



Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false


Constraints:

1 <= n <= 231 - 1

 */
public class HappyNumber {

    public static boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = computeSumOfSquares(slow);
            fast = computeSumOfSquares(computeSumOfSquares(fast));
            if (fast == 1) {
                return true;
            }
        } while (slow != fast);
        return false;
    }

    private static int computeSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        int n1 = 19;
        int n2 = 2;

        System.out.println("Is " + n1 + " a happy number? " + isHappy(n1)); // Output: true
        System.out.println("Is " + n2 + " a happy number? " + isHappy(n2)); // Output: false
    }
}
