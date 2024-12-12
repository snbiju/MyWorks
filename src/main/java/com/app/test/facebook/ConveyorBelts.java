package com.app.test.facebook;

/*
A distribution center moves packages around using a system of conveyor belts, which can be represented as line segments on the 2D Cartesian plane. The ith conveyor belt runs from coordinates
(Ai,Hi) to  (Bi,Hi). No two conveyor belts share any points in common, including endpoints or interior points. Gravity points in the direction of the negative y-axis, meaning that objects normally fall vertically downwards, with their y-coordinate decreasing over time.
Each conveyor belt runs to either the left or the right. A package can be considered to occupy a single point on the plane. If a package lands strictly within conveyor belt i (excluding its endpoints), then it will be transported to its left or right end (either (Ai ,Hi) or (Bi ,Hi)), depending on the conveyor belt's direction, before continuing to fall vertically downwards.

You'll start by selecting a single conveyor belt and choosing a fixed direction (either left or right) for it to run in. Then, random directions will be independently chosen for each of the remaining N−1 conveyor belts (each being either left or right with equal probability). Finally, a single package will be dropped into the system from high above, at coordinates (x,1,000,000), where x is a real value drawn uniform randomly from the inclusive interval [0,1,000,000]. Your objective is to minimize the expected horizontal distance which this package will travel along conveyor belts before hitting the ground (any point with y-coordinate 0).

Constraints

1≤N≤500,000
1<=Hi≤999,999
0≤Ai<Bi≤1,000,000

Sample test case #1
N = 2
H = [10, 20]
A = [100000, 400000]
B = [600000, 800000]
Expected Return Value = 155000.00000000

You should pick the second conveyor belt and cause it to run to the right. Packages falling at x-coordinates in the intervals
[0,100,000] and [800,000,1,000,000] will fall directly to the ground (with 0 horizontal travel distance), while packages falling at x-coordinates in the interval (400,000,800,000) will have an average horizontal travel distance of  200,000 units. This leaves packages falling at x-coordinates in the interval (100,000,400,000], which will have an average horizontal travel distance of either
150,000 units (if the first conveyor belt runs to the left) or 350,000 units (if it runs to the right). This yields an overall expected horizontal travel distance of
0∗0.3+200,000∗0.4+((150,000+350,000)/2)∗0.3=155,000, which is the minimum achievable expected horizontal travel distance.

Sample test case #2
N = 5
H = [2, 8, 5, 9, 4]
A = [5000, 2000, 7000, 9000, 0]
B = [7000, 8000, 11000, 11000, 4000]
Expected Return Value = 36.50000000

 */
import java.util.Arrays;


public class ConveyorBelts {

    public static double minExpectedTravelDistance(int N, int[] H, int[] A, int[] B) {
        double[] dp = new double[N];
        Arrays.fill(dp, Double.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            // Iterate over each conveyor belt as the initial belt
            for (int j = 0; j < N; j++) {
                // Iterate over two possible directions (left and right)
                for (int direction = 0; direction < 2; direction++) {
                    // Calculate the falling range for the initial conveyor belt
                    int startX = Math.min(A[j], B[j]);
                    int endX = Math.max(A[j], B[j]);

                    // Calculate the falling range for the current conveyor belt
                    int fallingStart = (direction == 0) ? startX : endX;
                    int fallingEnd = (direction == 0) ? endX : startX;

                    // Calculate the expected horizontal travel distance for the current falling range
                    double currentDistance = calculateExpectedDistance(i, H, A, B, fallingStart, fallingEnd);

                    // Update the minimum expected travel distance for the current initial belt and direction
                    dp[j] = Math.min(dp[j], currentDistance);
                }
            }
        }

        // Find the minimum expected travel distance among all possible initial belts and directions
        double minDistance = Double.MAX_VALUE;
        for (double distance : dp) {
            minDistance = Math.min(minDistance, distance);
        }

        return minDistance;
    }

    private static double calculateExpectedDistance(int initialBelt, int[] H, int[] A, int[] B, int fallingStart, int fallingEnd) {
        double expectedDistance = 0;

        // Iterate over all conveyor belts to calculate the expected distance
        for (int i = 0; i < H.length; i++) {
            if (i == initialBelt) {
                continue; // Skip the initial conveyor belt
            }

            // Calculate the intersection range between the current falling range and the i-th belt
            int intersectionStart = Math.max(A[i], fallingStart);
            int intersectionEnd = Math.min(B[i], fallingEnd);

            if (intersectionStart < intersectionEnd) {
                // Calculate the probability of falling within the intersection range
                double probability = (double) (intersectionEnd - intersectionStart) / (fallingEnd - fallingStart);

                // Update the expected distance
                expectedDistance += probability * Math.abs(H[initialBelt] - H[i]);
            }
        }

        return expectedDistance;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(minExpectedTravelDistance(2, new int[]{10, 20}, new int[]{100000, 400000}, new int[]{600000, 800000}));
        System.out.println(minExpectedTravelDistance(5, new int[]{2, 8, 5, 9, 4}, new int[]{5000, 2000, 7000, 9000, 0}, new int[]{7000, 8000, 11000, 11000, 4000}));
    }
}
