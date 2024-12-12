package com.app.codes.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumToys {

    public static int maximumToys(int[] prices, int k) {
        // Sort the prices in ascending order
        Arrays.sort(prices);

        int totalCost = 0;
        int count = 0;

        // Iterate through the sorted prices and keep track of total cost and number of toys bought
        for (int price : prices) {
            if (totalCost + price <= k) {
                totalCost += price;
                count++;
            } else {
                break; // Exit the loop if adding the next toy exceeds the budget
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of toys and the budget
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        // Read the prices of the toys
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        // Compute and print the maximum number of toys that can be bought
        System.out.println(maximumToys(prices, k));

        scanner.close();
    }
}
