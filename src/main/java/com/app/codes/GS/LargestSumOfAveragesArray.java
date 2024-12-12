package com.app.codes.GS;


/*

You are given an integer array nums and an integer k. You can partition the array into at most k non-empty adjacent subarrays. The score of a partition is the sum of the averages of each subarray.

Note that the partition must use every integer in nums, and that the score is not necessarily an integer.

Return the maximum score you can achieve of all the possible partitions. Answers within 10-6 of the actual answer will be accepted.



Example 1:

Input: nums = [9,1,2,3,9], k = 3
Output: 20.00000
Explanation:
The best choice is to partition nums into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
We could have also partitioned nums into [9, 1], [2], [3, 9], for example.
That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
Example 2:

Input: nums = [1,2,3,4,5,6,7], k = 4
Output: 20.50000


Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 104
1 <= k <= nums.length



The time and space complexity of the provided code are as follows:

Time Complexity:
O(k⋅n^2)

The outer loop runs k times.
The middle loop runs n−k+1 times.
The inner loop runs n times in the worst case.
Space Complexity: O(k⋅n)

The 2D array average has dimensions

k×n.
Explanation:

The code uses dynamic programming to calculate the maximum average for different group sizes.
The outer loop iterates over the number of groups (k).
The middle loop iterates over the end indices of the array.
The inner loop iterates over the start indices of the array, updating the maximum average for the current group size and end index.
The 2D array average stores intermediate results for different group sizes and end indices.
Note: The provided solution has a better space complexity compared to the previous one, but the time complexity remains
O(k⋅n^2).

 */
public class LargestSumOfAveragesArray {

    public static double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] sum = new double[n + 1];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        double[][] average = new double[k + 1][n];

        for (int i = 0; i < n; i++) {
            average[1][i] = sum[i + 1] / (i + 1);
        }

        for (int groups = 2; groups <= k; groups++) {
            for (int end = groups - 1; end < n; end++) {
                for (int start = groups - 2; start < end; start++) {
                    average[groups][end] = Math.max(average[groups][end],
                            average[groups - 1][start] + (sum[end + 1] - sum[start + 1]) / (end - start));
                }
            }
        }

        return average[k][n - 1];
    }

    public static void main(String[] args) {

        int [] array1= {9,1,2,3,9};
        System.out.println (largestSumOfAverages(array1,3));

    }
}
