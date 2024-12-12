package com.app.test.practice;


/*
Count the number of Duplicates
Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that
occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase)
and numeric digits.

Example
"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice
 */


import java.util.HashMap;
import java.util.Map;

public class CountCharacterList {


    public static int countDuplicates(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : s.toLowerCase().toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int duplicateCount = 0;
        for (int count : charCount.values()) {
            if (count > 1) {
                duplicateCount++;
            }
        }

        return duplicateCount;
    }

    public static void main(String[] args) {
        System.out.println(countDuplicates("abcde")); // 0
        System.out.println(countDuplicates("aabbcde")); // 2
        System.out.println(countDuplicates("aabBcde")); // 2
        System.out.println(countDuplicates("indivisibility")); // 1
        System.out.println(countDuplicates("Indivisibilities")); // 2
        System.out.println(countDuplicates("aA11")); // 2
        System.out.println(countDuplicates("ABBA")); // 2
    }
}



