package com.app.codes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SubArrayElementCount {
    // Function to find all distinct elements present in each subarray
    // of size `k` in the array
    public static void findDistinctCount(List<Integer> input, int k) {
        // loop through the list
        for (int i = 0; i < input.size() - (k - 1); i++) {
            Set<Integer> distinct = new HashSet<>();
            distinct.addAll(input.subList(i, i + k));

            System.out.println("The count of distinct elements in "
                    + "subarray " + input.subList(i,i+k) + " is "
                    + distinct.size());
        }
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(2, 1, 2, 3, 2, 1, 4, 5,9);
        int k = 5;

        findDistinctCount(input, k);
    }
}
/**
 * The count of distinct elements in subarray { 2, 1, 2, 3, 2 } is 3
 * The count of distinct elements in subarray { 1, 2, 3, 2, 1 } is 3
 * The count of distinct elements in subarray { 2, 3, 2, 1, 4 } is 4
 * The count of distinct elements in subarray { 3, 2, 1, 4, 5 } is 5

 */