package com.app.codes.hackerrank;
/*

Implement a function that receives a grid representing a labyrinth and computers the shortest path from the top
left corner cell(start) to the bottom right corner cell(end). The primary input is a uniform 2D grid representing a labyrinth.
Each entry in the grid will be either a 0 or 1. 1 represents a blocked wall and 0 represents free space.

input
3  4
0 0 1 0
1 0 0 0
0 0 1 0


output
5


 */
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInLabyrinth {

    public static void main(String[] args) {
        int[][] labyrinth = {
                {0, 0, 1, 0},
                {1, 0, 0, 0},
                {0, 0, 1, 0}
        };

        int result = shortestPathLength(labyrinth);
        System.out.println("Shortest path length: " + result);
    }

    public static int shortestPathLength(int[][] labyrinth) {
        int rows = labyrinth.length;
        int cols = labyrinth[0].length;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 0}); // {row, col, steps}
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int steps = current[2];

            if (row == rows - 1 && col == cols - 1) {
                return steps; // Reached the bottom-right corner
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && labyrinth[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                    queue.offer(new int[]{newRow, newCol, steps + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return -1; // No path found
    }
}
