package com.app.test.ubs;
/*
You have a ladder of X steps. You can go up the ladder by taking either one or two steps each time.
Write a function to determine how many potential different combinations of one or two steps you could
take to the top of the ladder.
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int steps = 5; // Change this to the desired number of steps
        int combinations = climbStairs(steps);
        System.out.println("Number of combinations: " + combinations);
    }

    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1; // There is only one way to climb 0 or 1 step
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
