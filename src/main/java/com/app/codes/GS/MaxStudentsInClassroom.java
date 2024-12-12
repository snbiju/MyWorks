package com.app.codes.GS;

/*

Given a m * n matrix seats  that represent seats distributions in a classroom. If a seat is broken, it is denoted by '#'
 character otherwise it is denoted by a '.' character.

Students can see the answers of those sitting next to the left, right, upper left and upper right, but he cannot see the
answers of the student sitting directly in front or behind him. Return the maximum number of students that can take
the exam together without any cheating being possible.

Students must be placed in seats in good condition.

Example 1:

Input: seats = [["#",".","#","#",".","#"],
                [".","#","#","#","#","."],
                ["#",".","#","#",".","#"]]
Output: 4
Explanation: Teacher can place 4 students in available seats so they don't cheat on the exam.
Example 2:

Input: seats = [[".","#"],
                ["#","#"],
                ["#","."],
                ["#","#"],
                [".","#"]]
Output: 3
Explanation: Place all students in available seats.

Example 3:

Input: seats = [["#",".",".",".","#"],
                [".","#",".","#","."],
                [".",".","#",".","."],
                [".","#",".","#","."],
                ["#",".",".",".","#"]]
Output: 10
Explanation: Place students in available seats in column 1, 3 and 5.


Constraints:

seat contains only characters '.' and'#'.
m == seats.length
n == seats[i].length
1 <= m <= 8
1 <= n <= 8

 */

import java.util.Arrays;

public class MaxStudentsInClassroom {

    public int maxStudents1(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;

        // Preprocess valid rows
        int[] validRows = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("validRows["+i+"]= "+validRows[i] +" and validRows["+i+"<<1]="+(validRows[i] << 1));
                validRows[i] = (validRows[i] << 1) + (seats[i][j] == '.' ? 1 : 0);
            }
        }

        int stateSize = 1 << n;

        // Initialize DP array
        int[][] dp = new int[m][stateSize];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        int maxStudents = 0;

        // Iterate through rows and states
        for (int i = 0; i < m; i++) {
            for (int state = 0; state < stateSize; state++) {
                // Check if the current state is valid
                if ((state & validRows[i]) == state && ((state & (state << 1)) == 0)) {
                    // Update DP values
                    if (i == 0) {
                        dp[i][state] = Integer.bitCount(state);
                    } else {
                        for (int prevState = 0; prevState < stateSize; prevState++) {
                            if (((prevState << 1) & state) == 0 && ((state << 1) & prevState) == 0 && dp[i - 1][prevState] != -1) {
                                dp[i][state] = Math.max(dp[i][state], dp[i - 1][prevState] + Integer.bitCount(state));
                            }
                        }
                    }
                    // Update maxStudents
                    maxStudents = Math.max(maxStudents, dp[i][state]);
                }
            }
        }

        return maxStudents;
    }

    public int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;
        int[] validRows = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                validRows[i] = (validRows[i] << 1) + (seats[i][j] == '.' ? 1 : 0);
            }
        }
        int stateSize = 1 << n;
        int[][] dp = new int[m][stateSize];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < stateSize; j++) {
                if (((j & validRows[i]) == j) && ((j & (j << 1)) == 0)) {
                    if (i == 0) {
                        dp[i][j] = Integer.bitCount(j);
                    } else {
                        for (int k = 0; k < stateSize; k++) {
                            if (((k << 1) & j) == 0 && ((j << 1) & k) == 0 && dp[i - 1][k] != -1) {
                                dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Integer.bitCount(j));
                            }
                        }
                    }
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;

    }

        public static void main(String[] args) {
            MaxStudentsInClassroom solution = new MaxStudentsInClassroom();

            // Example 1
            char[][] seats1 = {
                    {'#', '.', '#', '#', '.', '#'},
                    {'.', '#', '#', '#', '#', '.'},
                    {'#', '.', '#', '#', '.', '#'}
            };
            System.out.println(solution.maxStudents(seats1)); // Output: 4

            // Example 2
            char[][] seats2 = {
                    {'.', '#'},
                    {'#', '#'},
                    {'#', '.'},
                    {'#', '#'},
                    {'.', '#'}
            };
            System.out.println(solution.maxStudents(seats2)); // Output: 3

            // Example 3
            char[][] seats3 = {
                    {'#', '.', '.', '.', '#'},
                    {'.', '#', '.', '#', '.'},
                    {'.', '.', '#', '.', '.'},
                    {'.', '#', '.', '#', '.'},
                    {'#', '.', '.', '.', '#'}
            };
            System.out.println(solution.maxStudents(seats3)); // Output: 10
        }
    }
