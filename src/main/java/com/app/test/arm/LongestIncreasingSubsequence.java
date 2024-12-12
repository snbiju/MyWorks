package com.app.test.arm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {


    public static int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int maxLength = 1;

        // Initialize dp array, each element is at least an increasing subsequence of length 1.
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Fill dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static List<Integer> longestIncreasingSubsequence(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return new ArrayList<>();
        }

        int n = nums.size();
        int[] dp = new int[n];
        int[] prev = new int[n];  // Array to track the previous index of the LIS
        int maxLength = 0;
        int lastIndex = -1;

        // Initialize dp and prev arrays
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
        }

        // Fill dp array and track previous elements
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums.get(i) > nums.get(j) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        // Reconstruct the longest increasing subsequence
        List<Integer> lis = new ArrayList<>();
        for (int i = lastIndex; i >= 0; i = prev[i]) {
            lis.add(nums.get(i));
            if (prev[i] == -1) break;
        }

        Collections.reverse(lis);  // The sequence is constructed in reverse order

        return lis;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(10, 9, 2, 5, 3, 7, 101, 18);
        List<Integer> lis = longestIncreasingSubsequence(nums);
        System.out.println("Longest Increasing Subsequence: " + lis);
        // Output: [2, 3, 7, 101]

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of Longest Increasing Subsequence: " + longestIncreasingSubsequence(nums1));
        // Output: 4 (The LIS is [2, 3, 7, 101])

    }
}

