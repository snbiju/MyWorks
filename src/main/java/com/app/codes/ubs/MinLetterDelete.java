package com.app.codes.ubs;

/*

We are given a string S of length S of length N Consisting only of letter A adn or B .
Our goal is to string format A...AB..B(all letters 'A' occur before all letters B) by deleting soe letters from S.
In particular , String consists only of letters A or only of letters B fit this format.

Write a function
class Solution { public int solution (string S);}
that given a string S return the minimum number of letters that need to be deleted from S in order to obtain a string in the above format.

Example:

1. Given S= "BAAABAB", the function should return 2.
We can obtain "AAABB" by deleting the first occurrence of B and the last occurrence of A.
2. Given S= BBABAA the function should return 3.
We can delete all occurrence of A or all occurrences of B.
3. Given S= AABBBB, the function should return 0.
We do not have to delete any letter,
because the given string is already in the expected format.

 */
public class MinLetterDelete {

    public static int solutions(final String s) {
        final char firstChar = 'A';
        int numBs = 0, minDels = 0;
        for(char c : s.toCharArray()) {
            if (firstChar == c) {
                minDels = Math.min(numBs, minDels + 1);
            }
            else {
                numBs++;
            }
        }
        return minDels;
    }

    public static void main(String[] args) {
        String s1 = "BAAABAB";
        String s2 = "BBABAA";
        String s3 = "AABBBB";

        int result1 = solutions(s1);
        int result2 = solutions(s2);
        int result3 = solutions(s3);

        System.out.println("Result 1: " + result1); // Output: 2
        System.out.println("Result 2: " + result2); // Output: 3
        System.out.println("Result 3: " + result3); // Output: 0

    }
}
