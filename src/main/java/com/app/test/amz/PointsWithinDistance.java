package com.app.test.amz;

import java.util.Arrays;

public class PointsWithinDistance {

    public static int countSuitableLocations(int n, int[] center, int d) {
        int suitableLocations = 0;

        // Iterate through all possible warehouse locations
        for (int i = -1000; i <= 1000; i++) {
            int totalDistance = 0;

            // Calculate total distance travelled for the current warehouse location
            for (int j = 0; j < n; j++) {
                totalDistance += 2 * Math.abs(i - center[j]);
            }

            // Check if the total distance travelled is within the distance constraint
            if (totalDistance <= d) {
                suitableLocations++;
            }
        }

        return suitableLocations;
    }
    public static int countSuitableLocations1(int n, int[] center, int d) {
        int suitableLocations = 0;

        // Iterate through the center locations
        for (int i = 0; i < n; i++) {
            int totalDistance = 0;
            int currentLocation = center[i];

            // Calculate total distance travelled for the current location
            for (int j = 0; j < n; j++) {
                totalDistance += 2 * Math.abs(currentLocation - center[j]);
            }

            // Check if the total distance travelled is within the distance constraint
            if (totalDistance <= d) {
                suitableLocations++;
            }
        }

        return suitableLocations;
    }
    public static int countSuitableLocations2(int n, int[] center, int d) {
        // Sort the array of center locations
        Arrays.sort(center);

        int suitableLocations = 0;

        // Iterate through the center locations
        for (int i = 0; i < n; i++) {
            int totalDistance = 0;
            int currentLocation = center[i];

            // Calculate total distance travelled for the current location
            for (int j = 0; j < n; j++) {
                totalDistance += 2 * Math.abs(currentLocation - center[j]);
            }

            // Check if the total distance travelled is within the distance constraint
            if (totalDistance <= d) {
                suitableLocations++;
            }
        }

        return suitableLocations;
    }


    public static void main(String[] args) {
        // Test cases
        int n1 = 4;
        int[] center1 = {2, 0, 3, -4};
        int d1 = 22;
        System.out.println("Output for Test Case 1: " + countSuitableLocations(n1, center1, d1)); // Output: 5 expected:3

        int n2 = 3;
        int[] center2 = {-3, 2, 2};
        int d2 = 8;
        System.out.println("Output for Test Case 2: " + countSuitableLocations(n2, center2, d2)); // Output: 0, expected : 0
    }
}
