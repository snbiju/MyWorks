package com.app.codes.hackerrank;

/**
 * Given an array of positive integers. All numbers occur even number of
 * times except one number which occurs odd number of times. Find the number
 * in O(n) time & constant space
 */


public class OddOccurringElements {

    public static int getOddOccurringElement(int[] arr) {
        int result = 0;
        // int res[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // int num = arr[i];
            result ^= arr[i];
            // res[i] = result;
        }
        return result;
    }
}
