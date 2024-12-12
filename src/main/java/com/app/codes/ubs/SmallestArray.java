package com.app.codes.ubs;

import java.util.ArrayList;
import java.util.List;

/**
  A professor in the Computer, Science department of HackerLand College wants to generate an array: Given an array of integers of length
  n, arr, and two integers l and r, find another array, brr, such that:
  l ≤ brr[i] ≤ r
  brr[i]-arr[i]<brr[i+1]-arr[i+1] , for every i less than n−1
  brr[i] <= brr[i+1] for every i less than n-1.

  Among all such arrays, return the lexicographically smallest one. If there in not an array that satisfies the conditions, then return an array with the single element −1.
  Example
  arr=[1,2,1,2],l=1,r=10

  The array [1,3,3,5] satisfies given conditions.

  1. Each element belongs in the range [1,10]
  2. Construct an array crr where, crr[i]=brr[i]−arr[i], crr=[0,1,2,3] and it is increasing.
  3. The array brr is non-decreasing.

  brr[i]-arr[i] for each element is
  [0,1,2,3]
  1−1=0
  3-2 = 1

  5-2 = 3
  Note that all  brr[i]>=arr[i] as well. There is not a lexicographically smaller array than [1,3,3,5] that satisfies the conditions.

  complete the function getSmallestArray has the following parameters.

  int arr[n],
  int l lower value limit,
  int r upper value limit.

  return. int [n] an array that satisfiesthe conditionsor that containing a singledigit element -1

  conditions

  1<=n<= 10^5
  1<=arr[i]<= 10^5
  1<=l, r<=10^9

  Input

  array size n= 4, arr [1,2,1,3] , l=1, r= 10
  output 1,3,3 6
 */
public class SmallestArray {


    public static List<Integer> getSmallestArray(List<Integer> arr, int l, int r) {
        int n = arr.size();
        List<Integer> brr = new ArrayList<Integer>(arr);
        List<Integer> crr = new ArrayList<>(n);

        brr.add(0,Math.max(arr.get(0), l)) ; // Ensure the first element is within the range [l, r]

        for (int i = 1; i < n-1; i++) {

            int maxDiff = arr.get(i) - arr.get(i+1);
            brr.remove(i);
            brr.add(i,Math.max(brr.get(i-1) + maxDiff, arr.get(i)));

            brr.set(i,Math.min(brr.get(i), r));

        }
        for (int i = 0; i < n; i++) {
            crr.add(i,brr.get(i) - arr.get(i));
        }

        if (crr.get(0) < 0) {
            return new ArrayList(); // Cannot satisfy the conditions
        }
        for (int b:brr
        ) {
          //  System.out.println("BRR:"+b);
        }

        return brr;
    }


    public static int[] getSmallestArray(int[] arr, int l, int r) {
        int n = arr.length;
        int[] brr = new int[n];
        int[] crr = new int[n];

        for (int i = 0; i < n; i++) {
            int min = Math.max(l, arr[i]);
            int max = Math.min(r, arr[i] + i);

            if (min > max) {
                return new int[]{-1};
            }

            brr[i] = min;
            crr[i] = brr[i] - arr[i];
        }

        for (int i = 1; i < n; i++) {
            if (crr[i] <= crr[i - 1]) {
                int diff = crr[i - 1] - crr[i] + 1;
                brr[i] += diff;
                crr[i] = brr[i] - arr[i];
            }
        }

        return brr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2};
        int l = 1;
        int r = 10;

        int[] arr1 = {1,2,1,3};
        int l1 = 1;
        int r1 = 10;

        int[] arr2 = {4,1,2,1,2};
        int l2 = 1;
        int r2 = 10;
        /*
         array size n= 4, arr [1,2,1,3] , l=1, r= 10
         output 1,3,3 6
         */

        printResult(getSmallestArray(arr, l, r));
        printResult(getSmallestArray(arr1, l1, r1));
        printResult(getSmallestArray(arr2, l2, r2));
      //  printResult(getSmallestArray(arr1, l1, r2));
        List<Integer> array= List.of(1,2,1,3);
      //  System.out.println(getSmallestArray(array,l,r));
    }

    private static void printResult(int[] result) {
        if (result[0] == -1) {
            System.out.println("-1");
        } else {
            for (int i : result) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
