package com.app.codes.GS;

/*
Given an array of non-negative numbers & a target value, return the length of
the smallest sub array whose sum is greater than the target value

Time Complexity:
The algorithm uses a two-pointer approach where left and right pointers move towards each other.
Both pointers traverse the array once, so the time complexity is O(n), where n is the length of the input array nums.
Space Complexity:
The space complexity is O(1) because the algorithm uses a constant amount of extra space regardless of the input size.
It only uses a few variables (minLength, sum, left, right, and n) and does not rely on additional data structures that scale with the input size.
In summary:

Time Complexity: O(n)
Space Complexity: O(1)

 */
public class SmallestSubArray {

    public static int smallestSubArrayLength(int[] nums, int target) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum > target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;

        int result = smallestSubArrayLength(nums, target);
        System.out.println("Length of the smallest subarray: " + result);
        int [] nums1={1,3,2,6,4,5};
        System.out.println(smallestSubArrayLength(nums1,11));
    }
}
