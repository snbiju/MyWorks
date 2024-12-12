package com.app.test.GS;

/*

Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized the largest sum of the split.

A sub array is a contiguous part of the array.



Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two sub arrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.


Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= k <= min(50, nums.length)

Time Complexity:

The initialization loop that calculates the maximum and total sum has a time complexity of O(N),
where N is the length of the nums array.
The binary search has a time complexity of O(log(right - left)), where right is the sum of all elements in nums
and left is the maximum element in nums.
The isValid method iterates through each element in nums once, so it has a linear time complexity of O(N).
Combining all the steps, the overall time complexity is O(N) + O(log(right - left)) + O(N) = O(N + log(right - left)).

Space Complexity:

The space complexity is O(1) as the algorithm uses a constant amount of extra space, regardless of the input size.
In summary, the time complexity is O(N + log(right - left)), and the space complexity is O(1).

 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums1 = {7, 2, 5, 10, 8};
        int k1 = 2;
        System.out.println(splitArray(nums1, k1)); // Output: 18

        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 2;
        System.out.println(splitArray(nums2, k2)); // Output: 9
    }

    public static int splitArray(int[] nums, int k) {
        long left = 0;
        long right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (isValid(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (int) left;
    }

    private static boolean isValid(int[] nums, int k, long target) {
        int count = 1;
        long sum = 0;

        for (int num : nums) {
            sum += num;
            if (sum > target) {
                count++;
                sum = num;
                if (count > k) {
                    return false;
                }
            }
        }

        return true;
    }
}
