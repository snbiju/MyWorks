package com.app.codes.GS;


/*

Given a string, return starting index, max_count of a character appearing continuously.
Example: "aabbbbcdAA101aaa" return {2,4} since b char has the max continuous count.

Initial Checks:

The function checks if the input string is null or empty and returns {-1, 0} in such cases.
Main Loop:

The loop iterates through the string, updating the currentChar, currentCount, and currentStartIndex as it finds continuous segments of the same character.
Updating Maximums:

When a different character is encountered, the current segment is compared with the maximum segment found so far. If it's longer, the maximum variables are updated.
Final Update:

After the loop, there is a final check to ensure the last segment is considered.
Complexity Analysis
Time Complexity: O(n), where n is the length of the input string. The string is traversed only once.
Space Complexity: O(1), since only a fixed amount of extra space is used regardless of the input size.
 */
public class MaxContinuousChar {
    public static int[] findMaxContinuousChar(String s) {
        if (s == null || s.length() == 0) {
            return new int[]{-1, 0};
        }

      //  char maxChar = s.charAt(0);
        int maxCount = 1;
        int maxStartIndex = 0;

        char currentChar = s.charAt(0);
        int currentCount = 1;
        int currentStartIndex = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
               //     maxChar = currentChar;
                    maxCount = currentCount;
                    maxStartIndex = currentStartIndex;
                }
                currentChar = s.charAt(i);
                currentCount = 1;
                currentStartIndex = i;
            }
        }

        // Final check in case the longest sequence is at the end
        if (currentCount > maxCount) {
          //  maxChar = currentChar;
            maxCount = currentCount;
            maxStartIndex = currentStartIndex;
        }

        return new int[]{maxStartIndex, maxCount};
    }

    public static void main(String[] args) {
        String s = "aabbbbcdAA101aaa";
        int[] result = findMaxContinuousChar(s);
        System.out.println("Starting index: " + result[0] + ", Max count: " + result[1]);


        String s1 = "aabbbbcdAA101aaaa";
        int[] result1 = findMaxContinuousChar(s1);
        for (int i:result1
             ) {
            System.out.println(i);
        }
    }
}
