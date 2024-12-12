package com.app.test.amazon;

import java.util.Arrays;

/*

Amazon Fresh is a new grocery store designed from the ground up to offer a seamless grocery shopping experience to consumers.

As part of a stock clearance exercise at the store, given many piles of fresh products, follow the rules given below to stack
 the products in an orderly manner.

There are a total of n piles of products. The number of products in each pile is represented by the array numProducts.
 Select any subarray from the array numProducts and pick up products from each pile. The number of products you pick from
 the i th pile is strictly less than the number of products you pick from the (i+1) th pile for all indices i of
 the subarray. Find the maximum number of products that can be picked.

Examples:

Input : [7, 4, 5, 2, 6, 5] Output : 12
Input : [2,9,4,7,5,2] Output : 16
Input : [7, 4, 5, 2, 6, 5, 12, 13, 8, 20] Output : 53
 */
public class AmazonFresh {

    public static int maxProductsPicked(int[] numProducts) {
        int maxPicked = 0;  // Variable to track the maximum number of products picked
        int n = numProducts.length;  // Total number of piles

        // Iterate through the array to find all valid subarrays
        for (int i = 0; i < n; i++) {
            int currentSum = numProducts[i];  // Start the sum with the first element in the subarray

            // Check subarray starting from index i
            for (int j = i + 1; j < n; j++) {
                // If current pile has fewer products than the next one, add the next one to the sum
                if (numProducts[j] > numProducts[j - 1]) {
                    currentSum += numProducts[j];
                } else {
                    // If the sequence breaks, stop the subarray here
                    break;
                }
            }

            // Update the maximum number of products picked if current sum is higher
            maxPicked = Math.max(maxPicked, currentSum);
        }

        return maxPicked;  // Return the result
    }

    public static int maxPickedProducts(int[] numProducts) {
        int n = numProducts.length;
        int maxPicked = 0;

        for (int i = 0; i < n; i++) {
            int currentSum = numProducts[i];
            int lastPicked = numProducts[i];

            for (int j = i + 1; j < n; j++) {
                if (numProducts[j] > lastPicked) {
                    currentSum += numProducts[j];
                    lastPicked = numProducts[j];
                } else {
                    break;
                }
            }

            maxPicked = Math.max(maxPicked, currentSum);
        }

        return maxPicked;
    }

    public static int maxProducts(int[] numProducts) {
        int n = numProducts.length;
        int[] dp = new int[n];
        dp[0] = numProducts[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + numProducts[i], numProducts[i]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        // Test cases
        int[] numProducts1 = {7, 4, 5, 2, 6, 5};
        System.out.println("----------"+maxPickedProducts(numProducts1));  // Output: 12
        System.out.println("Max Product:"+maxProductsPicked(numProducts1));
        System.out.println("--*--"+maxProducts(numProducts1));

        int[] numProducts2 = {2, 9, 4, 7, 5, 2};
        System.out.println("----------"+maxPickedProducts(numProducts2));  // Output: 16

        int[] numProducts3 = {7, 4, 5, 2, 6, 5, 12, 13, 8, 20};
        System.out.println("----------"+maxPickedProducts(numProducts3));  // Output: 53
        System.out.println("--*--"+maxProducts(numProducts3));

        System.out.println("Max Product:"+maxProductsPicked(numProducts3));
    }
}

