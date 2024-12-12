package com.app.codes.JP;

/*

You are building a string s of length n one character at a time, prepending each new character to the front of the string. The strings are labeled from 1 to n, where the string with length i is labeled si.

For example, for s = "abaca", s1 == "a", s2 == "ca", s3 == "aca", etc.
The score of si is the length of the longest common prefix between si and sn (Note that s == sn).

Given the final string s, return the sum of the score of every si.



Example 1:

Input: s = "babab"
Output: 9
Explanation:
For s1 == "b", the longest common prefix is "b" which has a score of 1.
For s2 == "ab", there is no common prefix so the score is 0.
For s3 == "bab", the longest common prefix is "bab" which has a score of 3.
For s4 == "abab", there is no common prefix so the score is 0.
For s5 == "babab", the longest common prefix is "babab" which has a score of 5.
The sum of the scores is 1 + 0 + 3 + 0 + 5 = 9, so we return 9.
Example 2:

Input: s = "azbazbzaz"
Output: 14
Explanation:
For s2 == "az", the longest common prefix is "az" which has a score of 2.
For s6 == "azbzaz", the longest common prefix is "azb" which has a score of 3.
For s9 == "azbazbzaz", the longest common prefix is "azbazbzaz" which has a score of 9.
For all other si, the score is 0.
The sum of the scores is 2 + 3 + 9 = 14, so we return 14.


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
 */
public class SomeOfScoreBuild {

    public long sumScores(String s) {
        int z[] = calculateZValue(s.toCharArray());

        long sum = s.length();
        for (int el : z)
            sum += el;
        return sum;
    }

    private int[] calculateZValue(char[] input) {
        int n = input.length;
        int[] Z = new int[n];
        int left = 0, right = 0;

        for (int i = 1; i < n; i++) {
            if (i > right) {
                left = right = i;
                while (right < n && input[right] == input[right - left]) {
                    right++;
                }
                Z[i] = right - left;
                right--;
            } else {
                int k = i - left;
                if (Z[k] < right - i + 1) {
                    Z[i] = Z[k];
                } else {
                    left = i;
                    while (right < n && input[right] == input[right - left]) {
                        right++;
                    }
                    Z[i] = right - left;
                    right--;
                }
            }
        }
        return Z;
    }


    public long sumScores1(String s) {
        char[] ch = s.toCharArray();
        long sum = ch.length;
        int x = 0, y = 0;
        int[] z = new int[ch.length];

        for (int i = 1; i < ch.length; i++) {
            z[i] = computeZValue(ch, i, x, y, z);
            sum += z[i];
        }
        return sum;
    }

    private int computeZValue(char[] ch, int i, int x, int y, int[] z) {
        int maxPrefixLength = Math.max(0, Math.min(z[i - x], y - i + 1));
        while (i + maxPrefixLength < ch.length && ch[maxPrefixLength] == ch[i + maxPrefixLength]) {
            x = i;
            y = i + maxPrefixLength;
            maxPrefixLength++;
        }
        return maxPrefixLength;
    }

    public static void main(String[] args) {
        SomeOfScoreBuild solution = new SomeOfScoreBuild();

        String s1 = "babab";
        System.out.println(solution.sumScores(s1));  // Output: 9

        String s2 = "azbazbzaz";
        System.out.println(solution.sumScores(s2));  // Output: 14

        String s3 = "aabaaa";
        System.out.println(solution.sumScores(s3)); // Output: 12
    }
}
