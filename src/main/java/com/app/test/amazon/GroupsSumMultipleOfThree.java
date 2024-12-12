package com.app.test.amazon;

public class GroupsSumMultipleOfThree {

    public static int findGroups(int[] arr, int n) {
        // Count occurrences of remainders when divided by 3
        int[] remainderCount = new int[]{0, 0, 0};

        // Count elements with remainders 0, 1, and 2
        for (int i = 0; i < n; i++)
            remainderCount[arr[i] % 3]++;

        // Initialize the result
        int totalGroups = 0;

        // Case 3.a: Count groups of size 2 from elements with remainder 0
        totalGroups += ((remainderCount[0] * (remainderCount[0] - 1)) >> 1);

        // Case 3.b: Count groups of size 2 with one element with remainder 1 and the other with remainder 2
        totalGroups += remainderCount[1] * remainderCount[2];

        // Case 4.a: Count groups of size 3 with all elements having remainder 0
        totalGroups += (remainderCount[0] * (remainderCount[0] - 1) * (remainderCount[0] - 2)) / 6;

        // Case 4.b: Count groups of size 3 with all elements having remainder 1
        totalGroups += (remainderCount[1] * (remainderCount[1] - 1) * (remainderCount[1] - 2)) / 6;

        // Case 4.c: Count groups of size 3 with all elements having remainder 2
        totalGroups += ((remainderCount[2] * (remainderCount[2] - 1) * (remainderCount[2] - 2)) / 6);

        // Case 4.d: Count groups of size 3 with different remainders
        totalGroups += remainderCount[0] * remainderCount[1] * remainderCount[2];

        // Return the total count of groups
        return totalGroups;
    }

    public static int findGroups0(int[] arr, int n) {
        // Array to store the count of remainders when dividing by 3
        int[] remainderCount = new int[3];
        for (int i = 0; i < n; i++) {
            remainderCount[arr[i] % 3]++;
        }

        // Number of groups of two
        int groupsOfTwo = Math.min(remainderCount[1], remainderCount[2]);

        // Number of groups of three
        int groupsOfThree = remainderCount[0] / 2;
        groupsOfThree += Math.min(remainderCount[1] - groupsOfTwo, remainderCount[2] - groupsOfTwo) / 3;

        return groupsOfTwo + groupsOfThree;
    }
    public static int findGroups1(int[] arr, int n) {
        // Count occurrences of remainder when divided by 3
        int c[] = new int[]{0, 0, 0};
        int i;

        int res = 0; // To store the result

        // Count elements with remainder 0, 1 and 2
        for (i = 0; i < n; i++)
            c[arr[i] % 3]++;

        // Case 3.a: Count groups of size 2 from 0 remainder elements
        res += ((c[0] * (c[0] - 1)) >> 1);

        // Case 3.b: Count groups of size 2 with one element with 1
        // remainder and other with 2 remainder
        res += c[1] * c[2];

        // Case 4.a: Count groups of size 3 with all 0 remainder elements
        res += (c[0] * (c[0] - 1) * (c[0] - 2)) / 6;

        // Case 4.b: Count groups of size 3 with all 1 remainder elements
        res += (c[1] * (c[1] - 1) * (c[1] - 2)) / 6;

        // Case 4.c: Count groups of size 3 with all 2 remainder elements
        res += ((c[2] * (c[2] - 1) * (c[2] - 2)) / 6);

        // Case 4.c: Count groups of size 3 with different remainders
        res += c[0] * c[1] * c[2];

        // Return total count stored in res
        return res;

    }

    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {3, 6, 7, 2, 9};
        int n1 = 5;
        System.out.println("Output for Example 1: " + findGroups(arr1, n1)); // Output: 8

        // Example 2
        int[] arr2 = {2, 1, 3, 4};
        int n2 = 4;
        System.out.println("Output for Example 2: " + findGroups(arr2, n2)); // Output: 4
    }
}
