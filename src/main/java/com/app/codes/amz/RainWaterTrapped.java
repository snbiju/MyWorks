package com.app.codes.amz;

/*

Problem Description

Given an integer array A of non-negative integers representing an elevation map where the width of each bar is 1,
 compute how much water it is able to trap after raining.



Problem Constraints
1 <= |A| <= 100000



Input Format
The only argument given is integer array A.



Output Format
Return the total water it is able to trap after raining.



Example Input
Input 1:

 A = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Input 2:

 A = [1, 2]


Example Output
Output 1:

 6
Output 2:

 0


Example Explanation 1:


 In this case, 6 units of rain water (blue section) are being trapped.
Explanation 2:

 No water is trapped.


 Explanation:

The algorithm uses two pointers (left and right) that traverse the array from both ends towards the center.
In each iteration of the while loop, the algorithm compares the values at the left and right pointers.
The algorithm updates the maximum height on the left (leftMax) and right (rightMax) as it traverses the array.
The result is updated based on the difference between the current height and the corresponding maximum height.
The while loop continues until the left pointer is less than the right pointer.

Since each element in the array is visited at most twice (once from the left and once from the right),
the overall time complexity is O(N), where N is the number of elements in the array.

Time Complexity:
The time complexity of this code is O(N), where N is the length of the input array A.
The while loop iterates through the array once, and each iteration involves constant time operations.
The left and right pointers move towards each other, so each element is processed at most once.

Space Complexity:
The space complexity is O(1), constant space. The algorithm uses a fixed number of
variables (left, right, leftMax, rightMax, result), and the space required does not depend on the size of the input array.
It's an in-place algorithm that does not use any additional data structures that grow with the input size.


£££££££££££££££££

Explanation of the Code
Initial Checks:
-----------
If the input array A is null or empty,
return 0 as no water can be trapped.

Two Pointers:
-------------
Initialize two pointers left and right at the start and end of the array, respectively.
left_max and right_max are initialized to 0 to keep track of the maximum height encountered from the left and right.

Traversing the Array:
--------------------
Use a while loop to move the pointers towards each other.
At each step, compare the heights at left and right pointers.
Update left_max or right_max and calculate the trapped water accordingly.

Update and Move Pointers:
-------------------------
Move the left pointer if A[left] is less than A[right], otherwise move the right pointer.
Return Result:

The accumulated water_trapped value is returned as the result.

Complexity Analysis
------------------
Time Complexity: O(n), where n is the length of the input array. The array is traversed only once.
Space Complexity: O(1), as the solution uses a constant amount of extra space.

 */

import java.util.List;

public class RainWaterTrapped {


    static int volumeOfTrappedRainWater(int[] heights) {
        int n = heights.length;
        int totalRainWater = 0;
        for (int i = 0; i < n; i++){
            int maxLeft = 0, maxRight = 0;
            for (int j = 0; j <= i; j++){
                maxLeft = Math.max (maxLeft, heights[j]);
            }
            for (int j = i; j < n; j++) {
                maxRight = Math.max (maxRight, heights[j]);
            }
            totalRainWater += Math.min (maxRight, maxLeft) - heights[i];
        }
        return totalRainWater;
    }


    public static int trap(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int left = 0, right = A.length - 1;
        int left_max = 0, right_max = 0;
        int water_trapped = 0;

        while (left < right) {
            if (A[left] < A[right]) {
                if (A[left] >= left_max) {
                    left_max = A[left];
                } else {
                    water_trapped += left_max - A[left];
                }
                left++;
            } else {
                if (A[right] >= right_max) {
                    right_max = A[right];
                } else {
                    water_trapped += right_max - A[right];
                }
                right--;
            }
        }

        return water_trapped;
    }
    public int trap1(final int[] A) {
        int[] height=A;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                right--;
            }
        }

        return result;
    }

    public int trap(List<Integer> A) {
        List<Integer> height=A;
        int left = 0;
        int right = height.size() - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;

        while (left < right) {
            if (height.get(left) < height.get(right)) {
                if (height.get(left) > leftMax) {
                    leftMax = height.get(left);
                } else {
                    result += leftMax - height.get(left);
                }
                left++;
            } else {
                if (height.get(right) > rightMax) {
                    rightMax = height.get(right);
                } else {
                    result += rightMax - height.get(right);
                }
                right--;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        RainWaterTrapped solution = new RainWaterTrapped();

        int[] arr1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result1 = solution.trap(arr1);
        System.out.println("Output 1: " + result1); // Output: 6

        int[] arr2 = {1, 2};
        int result2 = solution.trap(arr2);
        System.out.println("Output 2: " + result2); // Output: 0


        int[] test6 = {4, 2, 0, 3, 2, 5};
         /*
        Between the 1st and 3rd bars, 1 unit of water is trapped.
        Between the 3rd and 5th bars, 1 unit of water is trapped.
        Between the 5th and 7th bars, 2 units of water are trapped.
        Between the 7th and 10th bars, 2 units of water are trapped.
        Total water trapped: 1 + 1 + 2 + 2 = 6.
         */

        int[] test1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Test Case 1: " + trap(test1)); // Expected: 6
        System.out.println("Test-1:"+volumeOfTrappedRainWater(test1));

        //There are no dips between the bars to trap any water.
        int[] test2 = {1, 2};
        System.out.println("Test Case 2: " + trap(test2)); // Expected: 0
        System.out.println("Test-2:"+volumeOfTrappedRainWater(test2));

        /*
        Between the 1st and 3rd bars, 3 units of water are trapped.
        Between the 3rd and 5th bars, 1 unit of water is trapped.
        Between the 1st and 5th bars, 3 units of water are trapped.
        Total water trapped: 3 + 1 + 3 = 7.
         */
        int[] test3 = {3, 0, 2, 0, 4};
        System.out.println("Test Case 3: " + trap(test3)); // Expected: 7
        System.out.println("Test-3:"+volumeOfTrappedRainWater(test3));

        //There is a dip, but not enough bars on either side to trap any water.
        int[] test4 = {0, 2, 0};
        System.out.println("Test Case 4: " + trap(test4)); // Expected: 0

        int[] test5 = {4, 2, 3};
        System.out.println("Test Case 5: " + trap(test5)); // Expected: 1
        System.out.println("Test Case 6: " + trap(test6)); // Expected: 9

        int result3 = solution.trap(List.of(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1));
        System.out.println("Output 1: " + result3); // Output: 6


        int result4 = solution.trap(List.of(1,2));
        System.out.println("Output 2: " + result4); // Output: 0
    }
}
