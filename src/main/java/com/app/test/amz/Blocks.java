package com.app.test.amz;

import java.util.ArrayList;
import java.util.Arrays;

public class Blocks {

    static int minOperations(int arr1[], int arr2[],
                             int i, int j)
    {

        // Base Case
        if (arr1.equals(arr2))
            return 0;

        if (i >= arr1.length || j >= arr2.length)
            return 0;

        // If arr[i] < arr[j]
        if (arr1[i] < arr2[j])

            // Include the current element
            return 1 + minOperations(arr1, arr2,
                    i + 1, j + 1);

        // Otherwise, excluding the current element
        return Math.max(minOperations(arr1, arr2,
                        i, j + 1),
                minOperations(arr1, arr2,
                        i + 1, j));
    }

    public static int minimumOperationsToSort(int[] arr) {
        int n = arr.length;
        // Create an array of indices
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort the indices array based on the values of arr
        Arrays.sort(indices, (i, j) -> Integer.compare(arr[i], arr[j]));

        // Initialize visited array to keep track of visited elements
        boolean[] visited = new boolean[n];
        int operations = 0;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Skip visited elements or elements already in the correct position
            if (visited[i] || indices[i] == i) {
                continue;
            }

            // Find the cycle starting from index i
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                // Move to the next index in the cycle
                j = indices[j];
                cycleSize++;
            }

            // Calculate the number of swaps needed for this cycle
            if (cycleSize > 1) {
                operations += (cycleSize - 1);
            }
        }

        return operations;
    }

    // Function that counts the minimum
// moves required to sort the array
    static int minOperationsUtil(int[] arr)
    {
        int brr[] = new int[arr.length];

        for(int i = 0; i < arr.length; i++)
            brr[i] = arr[i];

        Arrays.sort(brr);

        // If both the arrays are equal
        if (arr.equals(brr))

            // No moves required
            return 0;

            // Otherwise
        else

            // Print minimum operations required
            return (minimumOperationsToSort(arr));
    }

    public static void main(String[] args) {
        // Example 1
        int[] blocks1 = {2, 4, 3, 1, 6};
        System.out.println(minOperationsUtil(blocks1)); // Output: 3

        // Example 2
        int[] blocks2 = {4, 11, 9, 10, 12};
        System.out.println(minOperationsUtil(blocks2)); // Output: 0
    }

    public static int minimumOperationsToSort(ArrayList<Integer> list) {
        int n = list.size();
        // Create an array of indices
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort the indices array based on the values of list
        Arrays.sort(indices, (i, j) -> Integer.compare(list.get(i), list.get(j)));

        // Initialize visited array to keep track of visited elements
        boolean[] visited = new boolean[n];
        int operations = 0;

        // Iterate through the list
        for (int i = 0; i < n; i++) {
            // Skip visited elements or elements already in the correct position
            if (visited[i] || indices[i] == i) {
                continue;
            }

            // Find the cycle starting from index i
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                // Move to the next index in the cycle
                j = indices[j];
                cycleSize++;
            }

            // Calculate the number of swaps needed for this cycle
            if (cycleSize > 1) {
                operations += (cycleSize - 1);
            }
        }

        return operations;
    }
}
