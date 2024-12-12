package com.app.codes.Sainsbury;


import java.util.LinkedHashMap;
import java.util.Map;

/*

“Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.”

Example 1:
Input: s = "bestcode"
Output: 0
Example 2:
Input: s = "lovetocodelots"
Output: 2
Example 3:
Input: s = "aabb"
Output: -1


Time Complexity:

The first loop iterates through each character in the input string, and the second loop also iterates through the same string.
Therefore, the time complexity is O(N), where N is the length of the input string.

Space Complexity:

The space complexity is determined by the additional space used to store character counts in the hash map (charCount).
In the worst case, all unique characters in the input string will be stored in the hash map. Therefore, the space complexity is O(U),
 where U is the number of unique characters in the input string.
In summary:

Time Complexity: O(N)
Space Complexity: O(U)
Note: If the set of possible characters is fixed (e.g., ASCII characters), the space complexity can be considered constant,
and we can say the space complexity is O(1).
 */
public class FirstUniqueCharacter {


    public static int findFirstRepeatingChar(String value){
        Map<Character,Integer> countMap = new LinkedHashMap<>();

        // Count the occurrences of each character
        for (char c : value.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // Find the first character with count 1
        for (int i = 0; i < value.length(); i++) {
            if (countMap.get(value.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // No non-repeating character found

    }
    public static int firstUniqChar(String s) {
        // Create an array to store the frequency of each character
        int[] frequency = new int[26];

        // Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        // Find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        // If no unique character is found, return -1
        return -1;
    }




    public static void main(String[] args) {
        System.out.println(findFirstRepeatingChar("bestcode"));      //  0
        System.out.println(findFirstRepeatingChar("lovetocodelots")); // 2
        System.out.println(findFirstRepeatingChar("aabb"));//-1

        System.out.println(firstUniqChar("bestcode"));      //  0
        System.out.println(firstUniqChar("lovetocodelots")); // 2
        System.out.println(firstUniqChar("aabb"));//-1
    }
}
