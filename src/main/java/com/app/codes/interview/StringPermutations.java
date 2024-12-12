package com.app.codes.interview;

/*

Below is a Java code snippet that provides all permutations of a given string using recursion:
 */

import java.util.HashSet;
import java.util.Set;

public class StringPermutations {

    // Function to find all permutations of a string
    public static Set<String> permutations(String str) {
        Set<String> result = new HashSet<>();
        permutationsHelper("", str, result);
        return result;
    }

    // Helper function for recursion
    private static void permutationsHelper(String prefix, String suffix, Set<String> result) {
        int n = suffix.length();
        if (n == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutationsHelper(prefix + suffix.charAt(i),
                        suffix.substring(0, i) + suffix.substring(i + 1, n),
                        result);
            }
        }
    }

    public static void generatePermutations(char[] arr, int left, int right) {

        if (left == right) {
            System.out.println(String.valueOf(arr));
        } else {
            for (int i = left; i <= right; i++) {
                swap(arr, left, i);
                generatePermutations(arr, left + 1, right);
                swap(arr, left, i);
            }
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main method to test the function
    public static void main(String[] args) {
        String str = "abc";
        Set<String> perms = permutations(str);
        System.out.println("Permutations of " + str + ": " + perms);


        generatePermutations(str.toCharArray(), 0, str.length() - 1);
    }
}

