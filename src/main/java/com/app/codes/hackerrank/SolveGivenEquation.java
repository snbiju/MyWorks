package com.app.codes.hackerrank;

import java.util.Scanner;
/*

Solve the given equations: You will be given an array, and T number of equations.
Solve that equation and update the array for every equation you solve
Input Example:
2 3 4 5 1 → input array
3 → number of equations
x*x
x+x
3*x+x

Output:
32 72 128 200 8
Explanation :

For first case array becomes arr=[ 4 9 16 25 1]
For second case array becomes arr=[8 18 32 50 2]
For third case array becomes arr=[32 72 128 200 8]

 */

public class SolveGivenEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int t = scanner.nextInt();
        String[] equation = new String[t];
        for (int i = 0; i < t; i++) {
            equation[i] = scanner.next();
        }

        equationCalculation(n, arr, t, equation);
    }

    private static void equationCalculation(int n, int[] arr, int t, String[] equation) {
        for (int k = 0; k < t; k++) {
            for (int i = 0; i < n; i++) {
                int x = arr[i];
                arr[i] = eval(equation[k]);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int eval(String expression) {
        // Implement the evaluation logic here
        return 0;
    }
}
