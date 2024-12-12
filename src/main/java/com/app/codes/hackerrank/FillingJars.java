package com.app.codes.hackerrank;

import java.util.List;

/*

Animesh has  empty candy jars, numbered from  1 to n , with infinite capacity. He performs m operations. Each operation is described by 3  integers a, b and k . Here, a and b are indices of the jars, and k is the number of candies to be added inside each jar whose index lies between a and b (both inclusive). Can you tell the average number of candies after m operations?

Example

n=5
operations= [[1,2,10],[3,5,10]]

The array has 5 elements that all start at 0. In the first operation, 10 add 2 to the first  elements. Now the array is [10,10,0,0,0] . In the second operation, add  10 to the last 2 elements (3 - 5). Now the array is [10,10,10,10] and the average is 10. Sincd 10 is already an integer value, it does not need to be rounded.

Function Description

Complete the solve function in the editor below.

solve has the following parameters:

int n: the number of candy jars
int operations[m][3]: a 2-dimensional array of operations
Returns

int: the floor of the average number of canidies in all jars
Input Format

The first line contains two integers,  and , separated by a single space.
 lines follow. Each of them contains three integers, , , and , separated by spaces.

Constraints

3<=n<=10^7
1<=m<=10^5
1<=a<=b<=N
0<=k<=10^6



Sample Input

STDIN       Function
-----       --------
5 3         n = 5, operations[] size = 3
1 2 100     operations = [[1, 2, 100], [2, 5, 100], [3, 4, 100]]
2 5 100
3 4 100
Sample Output

160
Explanation

Initially each of the jars contains 0 candies

0 0 0 0 0
First operation:

[100 100 0 0 0]
Second operation:

[100 200 100 100 100]
Third operation:

[100 200 200 200 100]
Total = 800, Average = 800/5 = 160
 */
public class FillingJars {

    public static int solve1(int n, List<List<Integer>> operations){
        double sum = 0;
        double times=0;
        double avg = 0;
        for (List<Integer> operation : operations) {
            int a = operation.get(0);
            int b = operation.get(1);
            int k = operation.get(2);
            times=  b-a+1;
            sum = k*times;
            avg += sum/n;
        }
        return (int)avg;
    }

    public static int solve(int n, List<List<Integer>> operations) {
        long[] differenceArray = new long[n + 1];
        // Apply the operations to the difference array
        for (List<Integer> operation : operations) {
            int a = operation.get(0);
            int b = operation.get(1);
            int k = operation.get(2);

            differenceArray[a - 1] += k;
            if (b < n) {
                differenceArray[b] -= k;
            }
        }

        // Compute the prefix sum to get the actual values in the jars
        long totalCandies = 0;
        long currentCandies = 0;
        for (int i = 0; i < n; i++) {
            currentCandies += differenceArray[i];
            totalCandies += currentCandies;
        }

        // Calculate the average number of candies in the jars
        return (int) (totalCandies / n);
    }

    public static void main(String[] args) {
        // Example usage
        List<List<Integer>> operations = List.of(
                List.of(1, 2, 100),
                List.of(2, 5, 100),
                List.of(3, 4, 100)
        );
        int n = 5;
        int result = solve(n, operations);
        System.out.println(result);  // Output: 160
    }
}
