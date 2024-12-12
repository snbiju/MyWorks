package com.app.test.facebook;


/*

A cafeteria table consists of a row of N seats, numbered from 1 to N from left to right. Social distancing guidelines require that every diner be seated such that K seats to their left and K seats to their right (or all the remaining seats to that side if there are fewer than K) remain empty.
There are currently M diners seated at the table, the ith of whom is in seat Si. No two diners are sitting in the same seat, and the social distancing guidelines are satisfied.
Determine the maximum number of additional diners who can potentially sit at the table without social distancing guidelines being violated for any new or existing diners, assuming that the existing diners cannot move and that the additional diners will cooperate to maximize how many of them can sit down.
Please take care to write a solution which runs within the time limit.
Constraints
1≤N≤10^15
1≤K≤N
1≤M≤500,000
M≤N
1≤Si≤N

Sample test case #1
N = 10
K = 1
M = 2
S = [2, 6]
Expected Return Value = 3
Sample test case #2
N = 15
K = 2
M = 3
S = [11, 6, 14]
Expected Return Value = 1
 */

import java.util.Arrays;

public class CafeteriaSeating {
    public static long getMaxAdditionalDinersCount1(long N, long K, int M, long[] S) {
        Arrays.sort(S);

        long maxAdditionalDiners = 0L;

        // Calculate the gap between the first diner and the start of the table
        maxAdditionalDiners = Math.max(maxAdditionalDiners, S[0] - K);

        // Calculate the gap between the last diner and the end of the table
        maxAdditionalDiners = Math.max(maxAdditionalDiners, N - S[M - 1] - K);

        // Calculate the gap between consecutive diners
        for (int i = 1; i < M; i++) {
            long gap = (S[i] - S[i - 1]) - 2 * K;
            maxAdditionalDiners += Math.max(0, gap);
        }

        return maxAdditionalDiners;
    }
    public static long getMaxAdditionalDinersCount2(long N, long K, int M, long[] S) {
        Arrays.sort(S);

        long maxAdditionalDiners = 0;

        // Calculate available empty seats to the left and right of each existing diner
        for (int i = 0; i < M; i++) {
            long leftEmptySeats = (i == 0) ? S[i] - 1 : (S[i] - S[i - 1]) / 2 - 1;
            long rightEmptySeats = (i == M - 1) ? N - S[i] : (S[i + 1] - S[i]) / 2 - 1;

            long availableEmptySeats = Math.min(leftEmptySeats, K) + Math.min(rightEmptySeats, K);

            maxAdditionalDiners += Math.max(0, K - availableEmptySeats);
        }

        return maxAdditionalDiners;
    }
    public static long getMaxAdditionalDinersCount3(long N, long K, int M, long[] S) {
        Arrays.sort(S);

        long maxAdditionalDiners = 0;

        // Initialize the left and right pointers for the sliding window
        int left = 0;
        int right = 0;

        while (right < M) {
            // Calculate the available seats between the current window
            long availableSeats = (S[right] - K - 1) - (S[left] + K - 1) + 1;

            // If there are available seats, increment the count and move the window to the right
            if (availableSeats > 0) {
                maxAdditionalDiners++;
                right++;
            } else {
                // If no available seats, move the window to the right until there are available seats
                left++;
            }
        }

        return maxAdditionalDiners;
    }
    public static long getMaxAdditionalDinersCount4(long N, long K, int M, long[] S) {
        Arrays.sort(S);

        long maxAdditionalDiners = 0;

        // Calculate available empty seats for each existing diner
        for (int i = 0; i < M; i++) {
            long leftEmptySeats = (i == 0) ? S[i] - 1 : (S[i] - S[i - 1]) / 2 - 1;
            long rightEmptySeats = (i == M - 1) ? N - S[i] : (S[i + 1] - S[i]) / 2 - 1;

            long availableEmptySeats = Math.min(leftEmptySeats, K) + Math.min(rightEmptySeats, K);

            maxAdditionalDiners += Math.max(0, K - availableEmptySeats);
        }

        return maxAdditionalDiners;
    }


    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {

        long minSeats = K + 1;
        if (M == 0) {
            return N / minSeats + 1;
        }

        Arrays.sort(S);
        long result = 0L;

        long firstChair = S[0];
        long firstAvailableIndex = (firstChair - 1) - minSeats;
        if (firstAvailableIndex >= 0) {
            result += firstAvailableIndex / minSeats + 1;
        }

        for (int index = 0; index < M - 1; index++) {

            long leftFreeChair = S[index] + minSeats;
            long rightFreeChair = S[index + 1] - minSeats;
            long diffSpace = rightFreeChair - leftFreeChair;
            if (diffSpace >= 0) {
                result += diffSpace / minSeats + 1;
            }
        }

        long lastChair = S[M - 1];
        long lastAvailableIndex = (lastChair - 1) + minSeats;
        if (lastAvailableIndex <= N-1) {
            result += (N - 1 - lastAvailableIndex)/ minSeats + 1;
        }

        return result;
    }

    public long getMaxAdditionalDinersCount5(long N, long K, int M, long[] S) {
        long minSeats = K + 1;
        long maxAdditionalDiners = 0L;

        // Check available seats before the first diner
        long firstAvailableIndex = S[0] - minSeats;
        maxAdditionalDiners += Math.max(0, firstAvailableIndex / minSeats + 1);

        // Check available seats between existing diners
        for (int index = 0; index < M - 1; index++) {
            long leftFreeChair = S[index] + minSeats;
            long rightFreeChair = S[index + 1] - minSeats;
            long diffSpace = rightFreeChair - leftFreeChair + 1; // Include both ends
            maxAdditionalDiners += Math.max(0, diffSpace / minSeats);
        }

        // Check available seats after the last diner
        long lastAvailableIndex = N - 1 - S[M - 1] - minSeats;
        maxAdditionalDiners += Math.max(0, lastAvailableIndex / minSeats + 1);

        return maxAdditionalDiners;
    }

    public static void main(String[] args) {
        // Test cases
        CafeteriaSeating cafeteriaSeating = new CafeteriaSeating();
        System.out.println(cafeteriaSeating.getMaxAdditionalDinersCount(10, 1, 2, new long[]{2, 6}));  // Expected: 3
        System.out.println(cafeteriaSeating.getMaxAdditionalDinersCount(15, 2, 3, new long[]{11, 6, 14}));  // Expected: 1
    }
}
