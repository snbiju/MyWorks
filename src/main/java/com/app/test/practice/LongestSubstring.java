package com.app.test.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        // Set to store characters in the current substring
        Set<Character> set = new HashSet<>();

        int maxLength = 0; // Maximum length of the substring
        int left = 0; // Left pointer of the sliding window

        // Iterate through the string with a right pointer
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If the current character is already in the set,
            // move the left pointer to the right until the
            // substring no longer contains the repeated character
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set
            set.add(ch);

            // Update the maximum length if needed
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test the method with example inputs
        String s1 = "abcabcbb";
        System.out.println("Length of longest substring without repeating characters in " + s1 + ": " + lengthOfLongestSubstring(s1)); // Expected output: 3

        String s2 = "bbbbb";
        System.out.println("Length of longest substring without repeating characters in " + s2 + ": " + lengthOfLongestSubstring(s2)); // Expected output: 1

        String s3 = "pwwkew";
        System.out.println("Length of longest substring without repeating characters in " + s3 + ": " + lengthOfLongestSubstring(s3)); // Expected output: 3

        String s4 = "abcdefghabcdefghi";
        System.out.println("Length of longest substring without repeating characters in " + s4 + ": " + lengthOfLongestSubstring(s4)); // Expected output: 1

    }
}
