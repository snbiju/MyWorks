package com.app.test.GS;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacters {
    public static void printDuplicateCharacters(String s) {
        if (s == null || s.isEmpty()) {
            System.out.println("The string is empty or null.");
            return;
        }

        // Create a hashmap to store the count of each character
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Count the occurrences of each character
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Print the characters that have more than one occurrence
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Character: " + entry.getKey() + ", Count: " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        String s = "programming";
        printDuplicateCharacters(s);
    }
}

