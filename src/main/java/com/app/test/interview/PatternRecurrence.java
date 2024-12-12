package com.app.test.interview;

/*

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.



Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false


Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
 */

import java.util.HashMap;

public class PatternRecurrence {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        HashMap<Character, String> patternMap = new HashMap<>();
        HashMap<String, Character> wordMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (patternMap.containsKey(ch)) {
                if (!patternMap.get(ch).equals(word)) {
                    return false;
                }
            } else {
                patternMap.put(ch, word);
            }

            if (wordMap.containsKey(word)) {
                if (wordMap.get(word) != ch) {
                    return false;
                }
            } else {
                wordMap.put(word, ch);
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String pattern1 = "abba", s1 = "dog cat cat dog";
        String pattern2 = "abba", s2 = "dog cat cat fish";
        String pattern3 = "aaaa", s3 = "dog cat cat dog";

        System.out.println(wordPattern(pattern1, s1)); // Output: true
        System.out.println(wordPattern(pattern2, s2)); // Output: false
        System.out.println(wordPattern(pattern3, s3)); // Output: false
    }
}

