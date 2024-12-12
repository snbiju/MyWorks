package com.app.codes.hackerrank;

public class ComputeMaxDiff {
    /**
     * Compute the largest possible difference between any two elements within
     * an array such that larger element always appears after the smaller
     * element.
     *
     * @param arr
     */
    private static int computeMaxDiff(int[] arr) {
        int diff, maxDiff, min = Integer.MAX_VALUE;
        diff = maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];

            // diff = Math.abs(arr[i]) - Math.abs(min);
            diff = arr[i] - min;
            if (diff > maxDiff)
                maxDiff = diff;
        }
        return maxDiff;
    }

}
