package com.app.test.hackerrank;

public class Merge2SortedArrays {
    /**
     * @param a1
     * @param a2
     */
    private static void merge2sortedArrays(int[] a1, int[] a2) {
        // int m = a1.length;
        // int n = a2.length;
        int[] A = { 4, 0, 6, 0, 8, 0 };
        int m = 3;
        int[] B = { 5, 7, 9 };
        int n = 3;

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            A[k--] = (A[i] > B[j]) ? A[i--] : B[j--];
            // if(A[i] > B[j])
            // A[k--] = A[i--];
            // else
            // A[k--] = B[j--];
        }
        while (j >= 0)
            A[k--] = B[j--];

    }
}
