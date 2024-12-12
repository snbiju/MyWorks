package com.app.test.GS;
/*

You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).

You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.

You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].

Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.

Input: jobDifficulty = [6,5,4,3,2,1], d = 2
Output: 7
Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
Second day you can finish the last job, total difficulty = 1.
The difficulty of the schedule = 6 + 1 = 7
Example 2:

Input: jobDifficulty = [9,9,9], d = 4
Output: -1
Explanation: If you finish a job per day you will still have a free day. you cannot find a schedule for the given jobs.
Example 3:

Input: jobDifficulty = [1,1,1], d = 3
Output: 3
Explanation: The schedule is one job per day. total difficulty will be 3.


Constraints:

1 <= jobDifficulty.length <= 300
0 <= jobDifficulty[i] <= 1000
1 <= d <= 10

Time Complexity:

The outer loop runs for O(d) iterations.
The middle loop runs for O(n) iterations.
The innermost loop runs for a varying number of iterations, but on average, it contributes O(n) iterations.
Within the loops, the operations are constant time.
Therefore, the overall time complexity is O(d⋅n^2).

Space Complexity:

The space complexity is dominated by the 2D array dp, which has dimensions (n+1)×(d+1).
Therefore, the space complexity is O(n⋅d).

In summary:

Time Complexity: O(d⋅n^2)
Space Complexity: O(n⋅d)

 */
public class MaxJobDifficulty {

    public static int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (n < d) {
            return -1;
        }

        int[][] dp = new int[n + 1][d + 1];
        int maxDifficulty = 0;

        for (int i = 1; i <= n; i++) {
            maxDifficulty = Math.max(maxDifficulty, jobDifficulty[i - 1]);
            dp[i][1] = maxDifficulty;
        }

        for (int k = 2; k <= d; k++) {
            for (int i = k; i <= n; i++) {
                int maxDayDifficulty = 0;
                dp[i][k] = Integer.MAX_VALUE;

                for (int j = i - 1; j >= k - 1; j--) {
                    maxDayDifficulty = Math.max(maxDayDifficulty, jobDifficulty[j]);
                    dp[i][k] = Math.min(dp[i][k], maxDayDifficulty + dp[j][k - 1]);
                }
            }
        }

        return dp[n][d];
    }

    public static void main(String[] args) {
        int [] array1 = {6,5,4,3,2,1};
        System.out.println(minDifficulty(array1,2));

        int [] array2= {9,9,9};
        System.out.println(minDifficulty(array2,4));

        int[] array3= {1,1,1};
        System.out.println(minDifficulty(array3,3));

        int [] array4 = {6,5,4,3,2,1};
        System.out.println(minDifficulty(array1,4));
    }
}
