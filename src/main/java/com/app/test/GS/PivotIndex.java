package com.app.test.GS;

/*

Pivot Index
You are given an array A of N integers. The task is to determine the pivot index of the given array.
The pivot index is defined as the index where the sum of all the numbers to the left of the index is equal to
the sum of all the numbers to the right of the index.

Followup Solve in constant space complexity.

Input format

The first line of input contains single a integer T. denoting the number of test cases
Each test cases follows
The first line of each test case contains a single integer N  denoting the number of element of A second line contains
N space-separated integers  denoting the number of A

Output Format
Print a single integer denoted the pivot index (0-indexed)
if there is more than one pivot index, then print the left most one.
If there is no such index, print -1

constraints
1<=T<=100
1<=N<=10^4
-10^3<=Ai<=10^3

Time Limit
1 second

Example

1,2,4,1,1,1

-1,3,4,3
-1,2,1,4,5,1,2


Time Complexity:

The code iterates through the array twice. The first loop calculates the total sum of the array, and the second loop finds
the pivot index.
Both loops iterate through the array once, resulting in a linear time complexity.
Therefore, the time complexity is O(n), where n is the length of the array.
Space Complexity:

The space complexity is O(1) because the code uses a constant amount of extra space regardless of the input size.
The variables used (totalSum, leftSum, i) are of constant size.
In summary:

Time Complexity: O(n)
Space Complexity: O(1)



or

Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.



Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
Example 2:

Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.
Example 3:

Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0

 */
public class PivotIndex {

    private static int findPivotIndex(int[] arr) {
        int totalSum = 0;
        int leftSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i];

            if (leftSum == totalSum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1; // No pivot index found
    }

    public static int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 1, 1, 1};
        int[] arr2 = {-1, 3, 4, 3};
        int[] arr3= {-2,2,2,3,4,3,2};

        System.out.println(findPivotIndex(arr1)); // Output: 2
        System.out.println(findPivotIndex(arr2)); // Output: -1
        System.out.println(findPivotIndex(arr3));
    }

}
