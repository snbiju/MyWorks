package com.app.codes.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPossiblePalindromes {

    /**
     * Find all the palindromes from a given string. Given a string, find all
     * possible palindromic partitions of given string. Ex. "abba" --> bb, abba,
     * a, b
     *
     * @param str
     * @return no of combinations of all the palindrome substrings from a given
     *         string.
     */
    public static int palindromePermutations(final String str) {
        Set<String> palindromeOutputs = new HashSet<String>();
        int len = str.length();
        int i = 0;
        char[] charArr = new char[str.length()];
        charArr = str.toCharArray();
        for (i = 0; i < len; i++) {
            // Check with keeping current char at center
            if (i > 0)
                palindromeOutputs.addAll(centerCombinations(str, i));
            if (i < (len - 1))
                palindromeOutputs.addAll(rightCombinations(str, i));
        }

        for (char c : charArr) {
            palindromeOutputs.add(Character.toString(c));
        }

        System.out.println(palindromeOutputs);
        return palindromeOutputs.size();
    }

    public static List<String> centerCombinations(String string, int center) {
        List<String> result = new ArrayList<>();

        while (((center - 1) >= 0) && ((center + 1) < string.length())
                && (string.charAt(center - 1) == string.charAt(center + 1))) {
            result.add(string.substring(center - 1, center + 2));
            center++;
        }
        return result;
    }

    public static List<String> rightCombinations(String string, int right) {
        List<String> result = new ArrayList<>();

        while (((right + 1) < string.length()) && (string.charAt(right) == string.charAt(right + 1))) {
            result.add(string.substring(right, right + 2));
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println( palindromePermutations("malayalam"));
    }
}
