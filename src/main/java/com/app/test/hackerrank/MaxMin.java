package com.app.test.hackerrank;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*/

You will be given a list of integers, arr, and a single integer . You must create an array of length k from elements of  arr such that its unfairness is minimised. Call that array arr' . Unfairness of an array is calculated as

max(arr')-min(ar')

Where:
- max denotes the largest integer in  arr'
- min denotes the smallest integer in arr'

Example

arr =[1,3,7,2]
k=2


Pick any two elements, say arr' = [4,7].
unfairness = max(4,7) - min(4,7) = 7-4 =3

Testing for all pairs, the solution [1,2] provides the minimum unfairness.

Note: Integers in arr may not be unique.

Function Description

Complete the maxMin function in the editor below.
maxMin has the following parameter(s):

int k: the number of elements to select
int arr[n]:: an array of integers
Returns

int: the minimum possible unfairness
Input Format

The first line contains an integer n, the number of elements in array arr.
The second line contains an integer k.
Each of the next  lines contains an integer arr[i] where 0<=i<=n.

Sample Input 0

7
3
10
100
300
200
1000
20
30
Sample Output 0

20

Explanation 0

Here ; selecting the  integers , unfairness equals

max(10,20,30) - min(10,20,30) = 30 - 10 = 20
Sample Input 1

10
4
1
2
3
4
10
20
30
40
100
200
Sample Output 1

3
Explanation 1

Here ; selecting the  integers , unfairness equals

max(1,2,3,4) - min(1,2,3,4) = 4 - 1 = 3
Sample Input 2

5
2
1
2
1
2
1
Sample Output 2

0

 */
public class MaxMin {
    public static int maxMin(int k, List<Integer> arr) {
        // Write your code here
        // Sort the array
        Collections.sort(arr);

        // Initialize the minimum unfairness to a large number
        int minUnfairness = Integer.MAX_VALUE;

        // Iterate through the array to find the minimum unfairness
        for (int i = 0; i <= arr.size() - k; i++) {
            int currentUnfairness = arr.get(i + k - 1) - arr.get(i);
            if (currentUnfairness < minUnfairness) {
                minUnfairness = currentUnfairness;
            }
        }
        return minUnfairness;

    }

    public static int maxMin(int k, int[] arr) {
        // Sort the array
        Arrays.sort(arr);

        // Initialize the minimum unfairness to a large number
        int minUnfairness = Integer.MAX_VALUE;

        // Iterate through the array to find the minimum unfairness
        for (int i = 0; i <= arr.length - k; i++) {
            int currentUnfairness = arr[i + k - 1] - arr[i];
            if (currentUnfairness < minUnfairness) {
                minUnfairness = currentUnfairness;
            }
        }

        return minUnfairness;
    }

    public static void main(String[] args) {

            // Sample Input 0
            int arr1[] = {10, 100, 300, 200, 1000, 20, 30};
            List arr11 = Arrays.asList(arr1);
            int k1 = 3;
            System.out.println(maxMin(k1, arr11));  // Output: 20
            System.out.println(maxMin(k1, arr1));  // Output: 20

            // Sample Input 1
            int arr2[] = {1, 2, 3, 4, 10, 20, 30, 40, 100, 200};
            List arr21 = Arrays.asList(arr2);
            int k2 = 4;
            System.out.println(maxMin(k2, arr21));  // Output: 3

            // Sample Input 2
            int[] arr3 = {1, 2, 1, 2, 1};
            List arr31= Arrays.asList(arr3);
            int k3 = 2;
            System.out.println(maxMin(k3, arr31));  // Output: 0

    }
}
