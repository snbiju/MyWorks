package com.app.codes.amz;

/**
 Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 return the area of the largest rectangle in the histogram.



 Example 1:
 Input: heights = [2,1,5,6,2,3]
 Output: 10
 Explanation: The above is a histogram where width of each bar is 1.
 The largest rectangle is shown in the red area, which has an area = 10 units.
 Example 2:


 Input: heights = [2,4]
 Output: 4


 Constraints:

 1 <= heights.length <= 105
 0 <= heights[i] <= 104
 */

import java.util.Stack;

public class HighestAreaOfHistogram {

    public static int largestRectangleArea(int [] heights){
        int max =0;
        int area =0;
        int i =0;
        Stack<Integer> stack= new Stack<>();
        for (i=0;i<=heights.length;i++){
            int h = (i==heights.length)? 0: heights[i];
            while(!stack.isEmpty() && h<heights[stack.peek()]){
                int currentHeight = heights[stack.pop()];
                int previousIndex = stack.isEmpty()? -1 :stack.peek();
                area = currentHeight *(i-previousIndex-1);
                max = Math.max(max,area);
            }
            stack.push(i);
        }
        return max;
    }


    public static int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;

        int max = Integer.MIN_VALUE;
        int[][] position = new int[2][n];

        for (int width = 1; width <= n; width++) {
            for (int l = 0; l + width - 1 < n; l++) {
                if (width == 1) {
                    position[width % 2][l] = heights[l];
                } else {
                    int prevIndex = l + width - 1;
                    position[width % 2][l] = Math.min(position[1 - width % 2][l], heights[prevIndex]);
                }
                max = Math.max(max, position[width % 2][l] * width);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int [] heights = {2,1,5,6,2,3};
        int [] heights1 ={2,4};
        int [] heights2 ={2};
        System.out.println(largestRectangleArea(heights));
     //   System.out.println(largestRectangleArea(heights1));


        System.out.println(largestRectangleArea1(heights));
        System.out.println(largestRectangleArea1(heights1));
       // System.out.println(largestRectangleArea1(heights2));
    }
}
