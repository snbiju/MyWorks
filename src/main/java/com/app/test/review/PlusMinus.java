package com.app.test.review;

import java.text.DecimalFormat;
import java.util.List;

/*

Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the decimal value of each fraction on a new line with  places after the decimal.

Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to  are acceptable.

Example

There are  elements, two positive, two negative and one zero. Their ratios are ,  and . Results are printed as:

0.400000
0.400000
0.200000
Function Description

Complete the plusMinus function in the editor below.

plusMinus has the following parameter(s):

int arr[n]: an array of integers
Print
Print the ratios of positive, negative and zero values in the array. Each value should be printed on a separate line with  digits after the decimal. The function should not return a value.

Input Format

The first line contains an integer, , the size of the array.
The second line contains  space-separated integers that describe .

Constraints



Output Format

Print the following  lines, each to  decimals:

proportion of positive values
proportion of negative values
proportion of zeros
Sample Input

STDIN           Function
-----           --------
6               arr[] size n = 6
-4 3 -9 0 4 1   arr = [-4, 3, -9, 0, 4, 1]
Sample Output

0.500000
0.333333
0.166667
Explanation

There are  positive numbers,  negative numbers, and  zero in the array.
The proportions of occurrence are positive: , negative:  and zeros: .
 */
public class PlusMinus {
    public static void plusMinus(List<Integer> arr) {

        // Write your code here
        int n= arr.size();
        int positiveCount=0;
        int negativeCount=0;
        int zeroCount=0;
        double postiveProportion=0.0;
        double negativeProportion=0.0;
        double zeroProportion=0.0;

        DecimalFormat df = new DecimalFormat("#.######");
        for(int i : arr){
            if(i>0){
                positiveCount++;
            }else if(i<0){
                negativeCount++;
            }else{
                zeroCount++;
            }
        }
        postiveProportion=(double)positiveCount/n;
        negativeProportion=(double)negativeCount/n;
        zeroProportion=(double)zeroCount/n;


        System.out.println(df.format(postiveProportion));
        System.out.println(df.format(negativeProportion));
        System.out.println(df.format(zeroProportion));

        System.out.printf("%.6f\n",postiveProportion);
        System.out.printf("%.6f\n",negativeProportion);
        System.out.printf("%.6f\n",zeroProportion);
        System.out.printf("%.6f\n",zeroProportion);

    }


    public static void main(String[] args) {
    List<Integer> integers = List.of(-4, 3, -9, 0 ,4 ,1);
    plusMinus(integers);
    }
}
