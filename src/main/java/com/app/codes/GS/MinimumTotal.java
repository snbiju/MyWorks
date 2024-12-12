package com.app.codes.GS;
/*

Given triangle array return the minimum path sum from top to bottom
For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104


Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?

The time complexity of the provided code is O(n^2), where n is the number of rows in the triangle. This is because we iterate through each element of the triangle exactly once, performing constant-time operations for each element.

The space complexity is O(1), as we only use a constant amount of extra space regardless of the size of the input triangle. The space used is independent of the number of rows, and we modify the input triangle in place without using any additional data structures that scale with the size of the input.

In summary:

Time Complexity: O(n^2)
Space Complexity: O(1)
 */
import java.util.ArrayList;
import java.util.List;

public class MinimumTotal {
    public static int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();

        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                int current = triangle.get(row).get(col);
                int below1 = triangle.get(row + 1).get(col);
                int below2 = triangle.get(row + 1).get(col + 1);

                triangle.get(row).set(col, current + Math.min(below1, below2));
            }
        }

        return triangle.get(0).get(0);
    }

    /*

 The time complexity of the provided code is O(n^2), where n is the number of rows in the triangle.
 This is because we iterate through each element of the triangle exactly once, performing constant-time operations for each element.

The space complexity is O(n), where n is the number of rows in the triangle. This is because we use an additional array
A of size triangle.size() + 1 to store the intermediate results. The space used scales linearly with the number of rows in the
input triangle.

In summary:

Time Complexity: O(n^2)
Space Complexity: O(n)
     */

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int row=triangle.size()-1;row>=0;row--){
            for(int col=0;col<triangle.get(row).size();col++){
                A[col] = Math.min(A[col],A[col+1])+triangle.get(row).get(col);
            }
        }
        return A[0];
    }

    public static void main(String[] args) {
        // Example 1

        List<List<Integer>> triangle1 = new ArrayList<>();
        List<Integer> list1= new ArrayList<>();
        list1.add(2);
        triangle1.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        triangle1.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        triangle1.add(list3);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle1.add(list4);

        int result1 = minimumTotal(triangle1);
        System.out.println(result1); // Output: 11

        // Example 2
        List<List<Integer>> triangle2 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
        list5.add(-10);
        triangle2.add(list5);

        int result2 = minimumTotal(triangle2);
        System.out.println(result2); // Output: -10
    }
}
