package com.app.test.GS;


/*

Given an array of words, print all anagrams together. For example,
if the given array is {"cat","dog","tac","god","act}, then out may be 'cat tac,act dog, god)



Time Complexity:
Let N be the total number of characters in all words, and K be the length of the longest word.

The for loop iterates through each word in the array, and for each word, it sorts its characters. Sorting takes O(K log K) time.
The putIfAbsent and get operations on the HashMap take O(1) time on average.
The overall time complexity is O(N * K log K), where N is the total number of characters and K is the length of the longest word.

Space Complexity:
The space complexity is determined by the space needed for the HashMap and the result list.

The HashMap stores the sorted words as keys, and for each key, it stores a list of words.
The space required for the HashMap is O(N + K) on average.
The result list stores the final grouped anagrams. In the worst case, each word is unique,
so the space required for the result list is O(N).
The overall space complexity is O(N + K).

 */

import java.util.*;

public class AnagramGroups {

    public static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String word : words) {
            // Sort the characters of the word to identify its anagram group
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            // Add the word to its anagram group
            anagramGroups.putIfAbsent(sortedWord, new ArrayList<>());
            anagramGroups.get(sortedWord).add(word);
        }

        // Collect all anagram groups
        List<List<String>> result = new ArrayList<>(anagramGroups.values());

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"cat", "dog", "tac", "god", "act"};
        List<List<String>> anagramGroups = groupAnagrams(words);

        for (List<String> group : anagramGroups) {
            System.out.println(String.join(", ", group));
        }
    }
}
