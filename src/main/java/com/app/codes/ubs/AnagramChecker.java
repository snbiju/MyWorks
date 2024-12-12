package com.app.codes.ubs;

import java.util.Arrays;

public class AnagramChecker {
    public static void main(String[] args) {
        String word1 = "listen";
        String word2 = "silent";

        if (areAnagrams(word1, word2)) {
            System.out.println(word1 + " and " + word2 + " are anagrams.");
        } else {
            System.out.println(word1 + " and " + word2 + " are not anagrams.");
        }
    }

    public static boolean areAnagrams(String word1, String word2) {
        // Remove spaces and convert to lowercase for case-insensitive comparison
        word1 = word1.replaceAll("\\s", "").toLowerCase();
        word2 = word2.replaceAll("\\s", "").toLowerCase();

        // Check if the lengths of the words are equal
        if (word1.length() != word2.length()) {
            return false;
        }

        // Convert strings to char arrays and sort them
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare the sorted char arrays
        return Arrays.equals(charArray1, charArray2);
    }
}
