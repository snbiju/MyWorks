package com.app.codes.GS;
/*

Transform to Chess board

You are given an n*n binary grid boad. In each move you can swap any two rows with each other, or any two column with each other.
Return the minimum number of transform the board into a chessboard board. if the task is impossible return -1

A chessboard is board where no 0's and no 1's  ae 4-directionally adjacent.

Example 1:

0 1 1 0			1 0 1 0.      1 0 1 0
0 1 1 0 -> 	    1 0 1 0 ->    0 1 0 1
1 0 0 			0 1 0 1.      1 0 1 0
1 0 0 1.        0 1 0 1.       0 1 0 1


input board: [[0,1,10],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
output : 2

Explanation: One potential squence of move is shown.
The first move swaps the first and second column.
The second move swap the second and third row

Example 2
0 1
1 0

input
[[0,1][1,0]]

output: 0

Example 3:
1 0
1 0

input
[[1,0][1,0]]
output:
-1
explanation:

Count the number of 0's and 1's in both the first row and the first column.
Check if the counts are valid for a chessboard.
They are valid if they are either the same or differ by 1 (i.e., there are at most one extra 0 or 1).
If the counts are valid, we calculate the number of swaps needed to make the rows and columns alternately 0's and 1's.
Return the minimum number of swaps.

Time Complexity:

The code iterates through the entire first row and column of the board, performing constant-time operations for each element.
Therefore, the time complexity is O(n), where n is the size of the board.
Space Complexity:

The space complexity is O(1) because the code uses a constant amount of extra space regardless of the input size.
The variables used for counting (rowSum, colSum, rowSwap, colSwap) and loop indices are of constant size.
In summary:

Time Complexity: O(n)
Space Complexity: O(1)

 */

public class ChessboardMoves {
    public static int movesToChessboard(int[][] board) {
        int n = board.length;

        // Step 1: Count the number of 0's and 1's in the first row and column
        int rowSum = 0, colSum = 0, rowSwap = 0, colSwap = 0;
        for (int i = 0; i < n; i++) {
            rowSum += board[0][i];
            colSum += board[i][0];
            rowSwap += board[i][0] == i % 2 ? 1 : 0; // Count the number of misplaced rows
            colSwap += board[0][i] == i % 2 ? 1 : 0; // Count the number of misplaced columns
        }

        // Step 2: Check if the counts are valid
        if (rowSum != n / 2 && rowSum != (n + 1) / 2) return -1;
        if (colSum != n / 2 && colSum != (n + 1) / 2) return -1;

        // Step 3: Check if the chessboard pattern is possible
        if (n % 2 == 1) {
            if (rowSwap % 2 == 1) rowSwap = n - rowSwap;
            if (colSwap % 2 == 1) colSwap = n - colSwap;
        } else {
            rowSwap = Math.min(rowSwap, n - rowSwap);
            colSwap = Math.min(colSwap, n - colSwap);
        }

        // Step 4: Calculate the minimum number of swaps
        return (rowSwap + colSwap) / 2;
    }

    public static void main(String[] args) {
     //   int[][] board = {{1, 0}, {1, 0}};
        int[][] board1 =  {{0,1,1,0},{0,1,1,0},{1,0,0,1},{1,0,0,1}};
      //  int[][] board2 = {{0, 1}, {1, 0}};
     //   System.out.println(movesToChessboard(board)); // Output: -1
        System.out.println(movesToChessboard(board1)); // Output: 2
     //   System.out.println(movesToChessboard(board2)); // Output: 0

    }
}
