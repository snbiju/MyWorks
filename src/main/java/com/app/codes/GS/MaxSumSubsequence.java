package com.app.codes.GS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
Given an integer array nums and an integer k, return the maximum sum of a non-empty subsequence of that array such that for every two consecutive integers in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.

A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array, leaving the remaining elements in their original order.



Example 1:

Input: nums = [10,2,-10,5,20], k = 2
Output: 37
Explanation: The subsequence is [10, 2, 5, 20].
Example 2:

Input: nums = [-1,-2,-3], k = 1
Output: -1
Explanation: The subsequence must be non-empty, so we choose the largest number.
Example 3:

Input: nums = [10,-2,-10,-5,20], k = 2
Output: 23
Explanation: The subsequence is [10, -2, -5, 20].


Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104


The time complexity of the provided solution is O(n * k), where n is the length of the array nums. This is because there are two nested loops: one iterating over the array elements (n iterations) and the other considering the maximum of the previous k elements (k iterations).

The space complexity is O(n), as the dynamic programming array dp has a length of n. The solution uses additional space proportional to the size of the input array to store intermediate results.

In summary:

Time Complexity: O(n * k)
Space Complexity: O(n)

 */
public class MaxSumSubsequence {
    public static int maxSumSubsequence1(int[] nums, int k) {
        int n = nums.length;

        // dp array to store the maximum sum of subsequence ending at index i
        int[] dp = new int[n];

        // Initialize dp array with the values of nums array
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }

        // Iterate over the array to compute the maximum sum subsequence
        for (int i = 1; i < n; i++) {
            // Consider the maximum of previous k elements
            for (int j = Math.max(0, i - k); j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
        }

        // Find the maximum value in the dp array
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

    public static int maxSumSubsequence2(int[] nums, int k) {
        int res = nums[0];
        Deque<Integer> q = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            // create dp and update max
            nums[i] += !q.isEmpty() ? q.peek() : 0;
            res = Math.max(res, nums[i]);
            // update queue or sliding window
            while (!q.isEmpty() && nums[i] > q.peekLast())
                q.pollLast();
            if (nums[i] > 0)
                q.add(nums[i]);
            if (i >= k && !q.isEmpty() && q.peek() == nums[i - k])
                q.poll();
        }
        return res;
    }

    public static int maxSumSubsequence(int[] nums, int k) {
        int result = nums[0];
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // Create dp and update max
            nums[i] += !queue.isEmpty() ? queue.peek() : 0;
            result = Math.max(result, nums[i]);

            // Update queue or sliding window
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.pollLast();
            }

            if (nums[i] > 0) {
                queue.add(nums[i]);
            }

            if (i >= k && !queue.isEmpty() && queue.peek() == nums[i - k]) {
                queue.poll();
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = {10, 2, -10, 5, 20};
        int k1 = 2;
        System.out.println(maxSumSubsequence(nums1, k1)); // Output: 37

        int[] nums2 = {-1, -2, -3};
        int k2 = 1;
        System.out.println(maxSumSubsequence(nums2, k2)); // Output: -1

        int[] nums3 = {10, -2, -10, -5, 20};
        int k3 = 2;
        System.out.println(maxSumSubsequence(nums3, k3)); // Output: 23

        int[] num4= {3574,-1795,5928,9488,-4282};
        System.out.println(maxSumSubsequence(num4,2));//output: 18990
    }
}
