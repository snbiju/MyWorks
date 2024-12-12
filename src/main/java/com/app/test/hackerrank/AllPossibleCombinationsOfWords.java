package com.app.test.hackerrank;

import java.util.Set;

public class AllPossibleCombinationsOfWords {
    /**
     * Get all the possible combinations of words from a given string
     *
     * @param str
     */
    private static Set<String> stringPermutations(String str, int start, int end, Set<String> output) {
        if (start == end) {
            output.add(str);
            System.out.println(str);
        } else {
            for (int i = start; i <= end; i++) {
                str = swap(str, start, i);
                stringPermutations(str, start + 1, end, output);
                // str = swap(str, start, i);
            }
        }
        return output;
    }
    /**
     * Swap characters
     *
     * @param str
     * @param start
     *            position 1
     * @param i
     *            position 2
     * @return swapped string
     */
    private static String swap(String str, int start, int i) {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[start];
        charArray[start] = temp;
        return String.valueOf(charArray);
    }
}
