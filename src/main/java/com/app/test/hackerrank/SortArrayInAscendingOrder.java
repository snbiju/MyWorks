package com.app.test.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortArrayInAscendingOrder {

    /**
     * Given an array with elements, can you sort this array in ascending order
     * using only one of the following operations?
     *
     * Swap two elements OR Reverse one sub-segment.
     *
     * @param arr
     * @param size
     */
    private static String almostSorted(int[] a, int size) {
        int i, j;
        List<Integer> unsortedList = new ArrayList<>();
        i = j = 0;
        int temp;
        int sorted = 0;
        int unSorted = 0;
        int[] unSortArr = new int[size];
        int broken = 0;
        int count = 0;
        while (i < size) {
            while (a[i] < a[i + 1]) {
                sorted++;
                i++;
            }
            j = i;
            while (a[i] > a[i + 1]) {
                unSorted++;
                unSortArr[i] = a[i];
                unsortedList.add(a[i]);
                if (i >= (size - 2))
                    break;
                else
                    i++;
            }
            // if (unSorted > 0)
            // unSorted++;
            while (((j + 1) != (i - 1)) && (unSorted > 0)) {
                if (a[j] > a[i]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    unSorted -= 2;
                }
                j++;
                i--;
            }
            if (!unsortedList.isEmpty())
                unsortedList.add(a[i]);
            broken++;
            Collections.reverse(unsortedList);
            // for (int k = 0; k<size-1; k++) {
            // if (a[k] < a[k+1])
            // count++;
            // }
            int total = sorted + unSorted;
            if (size == count)
                return "YES";
        }
        return "NO";
    }
}
