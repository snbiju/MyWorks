package com.app.codes.google;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DivideArray {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1, 2};
        int n = arr.length;

        // Sort the array in ascending order
        Arrays.sort(arr);

        // Initialize dynamic programming arrays to keep track of the subsets
        boolean[][] dp = new boolean[n + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                // If it's possible to form the sum j using the first i elements
                if (dp[i][j]) {
                    // Choose not to include arr[i] in subset A
                    dp[i + 1][j] = true;

                    // Choose to include arr[i] in subset A
                    if (j + arr[i] <= n) {
                        dp[i + 1][j + arr[i]] = true;
                    }
                }
            }
        }

        // Find the largest possible sum for subset A
        int maxSumA = 0;
        for (int j = n / 2; j >= 0; j--) {
            if (dp[n][j]) {
                maxSumA = j;
                break;
            }
        }

        // Construct subset A
        int[] subsetA = new int[n];
        int indexA = 0;
        int indexB = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (indexA < n / 2 && (indexB == n / 2 || dp[i][maxSumA - arr[i]])) {
                subsetA[indexA++] = arr[i];
                maxSumA -= arr[i];
            } else {
                indexB++;
            }
        }

        // Construct subset B
        int[] subsetB = new int[n / 2];
        for (int i = 0, j = 0; i < n; i++) {
            if (Arrays.binarySearch(subsetA, arr[i]) < 0) {
                subsetB[j++] = arr[i];
            }
        }

        System.out.println("Subset A: " + Arrays.toString(subsetA));
        System.out.println("Subset B: " + Arrays.toString(subsetB));
    }

    public static List<Integer> subsetA(List<Integer> arr) {
        List <Integer> resA = new ArrayList<>();
        List <Integer> resB = new ArrayList<>();
        int sA=0;
        int sB=0;
        int memIndex =0;
        Collections.sort(arr, Collections.reverseOrder());

        //sum all elements from the list
        int r  =0, sumList=0;
        for (int q=0; q<arr.size(); q++){
            sumList+=arr.get(q);
        }
        r =sumList/2;

        TESTFRONT: for(int i =0; i<arr.size();i++){
            resA.add(arr.get(i));
            sA+=arr.get(i);
            memIndex =i;
            if (sA >= r) break;
        }

        // create the remaining array
        while (++memIndex < arr.size()){
            resB.add(arr.get(memIndex));
            sB+=arr.get(memIndex);

        }

        Collections.sort(resA);
        Collections.sort(resB);

        // return the greatest sum of subarray

        if (sA >= sB)
            return resA;
        else
            return resB;
    }

}



