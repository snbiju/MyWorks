package com.app.test.hackerrank;

import java.util.Scanner;

public class CavityMap {

    /**
     * You are given a square map of size . Each cell of the map has a value
     * denoting its depth. We will call a cell of the map a cavity if and only
     * if this cell is not on the border of the map and each cell adjacent to it
     * has strictly smaller depth. Two cells are adjacent if they have a common
     * side (edge).
     *
     * You need to find all the cavities on the map and depict them with the
     * uppercase character X.
     */
    private static void cavityMap() {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int j = 0;
        String[] grid = new String[n];
        int[][] gridArr = new int[n][n];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            grid[grid_i] = in.next();
            for (int i = 0; i < n; i++) {
                String parts = grid[grid_i].substring(i, i + 1);
                gridArr[j][i] = Integer.parseInt(parts);
                // System.out.println("Parts are"+parts);
            }
            j++;
        }

        for (int i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (i != 0 && i != n - 1 && j != 0 && j != n - 1) {
                    if (gridArr[i][j] > gridArr[i + 1][j] && gridArr[i][j] > gridArr[i - 1][j]
                            && gridArr[i][j] > gridArr[i][j + 1] && gridArr[i][j] > gridArr[i][j - 1])
                        gridArr[i][j] = 111;
                }
            }
            // System.out.println();
        }

        String[][] outputStr = new String[n][n];
        int aa = outputStr.length;

        for (int i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                outputStr[i][j] = Integer.toString(gridArr[i][j]);
                // System.out.print(gridArr[i][j]+" ");
                if (gridArr[i][j] == 111)
                    outputStr[i][j] = "X";
            }
            // System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(outputStr[i][j]);
            }
            System.out.println();
        }
    }
}
