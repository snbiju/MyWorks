package com.app.test.amz;


import java.util.Arrays;

/*

Given an unsorted array of positive integers, find the number of triangles that can be formed with three different
array elements as three sides of triangles. For a triangle to be possible from 3 values, the
sum of the two sides must be greater than the third side.

Example :

Input: arr= {4, 6, 3, 7}
Output: 3
 */
public class NoOfTriangle {

    public static int noOfTriangle(int[] arr){
        int n = arr.length;
        int count = 0;

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Fix the largest side one by one
        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;

            // Step 3: Use two-pointer technique
            while (i < j) {
                // If arr[i] + arr[j] > arr[k], then all pairs (i, i+1, ..., j-1, j) are valid
                if (arr[i] + arr[j] > arr[k]) {
                    count += (j - i);  // All these pairs are valid triangles
                    j--;  // Move the second pointer downwards
                } else {
                    i++;  // Otherwise, move the first pointer upwards
                }
            }
        }

        // Return the total number of triangles found
        return count;
    }

    public static void main(String[] args) {

    int arr[]= {4, 6, 3, 7};
        System.out.println(noOfTriangle(arr));
    }
}
