package com.app.test.amazon;

/*
You are given an array of 'bad' numbers and a start and end number.
You need to calculate the longest continuous range of numbers that don't include a bad number,
between the start and end point.

To solve this problem, you can follow these steps:

Sort the array of bad numbers.
Initialize variables to keep track of the longest continuous range and the current continuous range.
Iterate from the start number to the end number.
For each number in the range, check if it's a bad number. If it's not, increment the current continuous range.
 If it is a bad number, update the longest continuous range if the current range is greater.
Return the longest continuous range found.

Time Complexity:
Sorting the array of bad numbers:

O(nlogn), where n is the number of bad numbers.
Iterating through the range from start to end:

O(m), where m is the size of the range.
Binary search for each number in the range: O(logn) per number.
The overall time complexity is dominated by the sorting step, so the time complexity is O(nlogn), where n is the number of bad numbers.

Space Complexity:
Sorting the array of bad numbers:
O(n), where n is the number of bad numbers.
Constant extra space for variables:
O(1).
The overall space complexity is O(n), where
n is the number of bad numbers.

Summary:
Time Complexity:
O(nlogn)
Space Complexity:
O(n)
These complexities are based on the size of the input array of bad numbers.
The time complexity could be further optimized if the array is already sorted or if a different approach is used
to find the longest continuous range.

 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ContinuousRange {

    public static int longestContinuousRange(int[] badNumbers, int start, int end) {
        Arrays.sort(badNumbers);

        int longestRange = 0;
        int currentRange = 0;

        for (int num = start; num <= end; num++) {
            if (Arrays.binarySearch(badNumbers, num) < 0) {
                currentRange++;
            } else {
                longestRange = Math.max(longestRange, currentRange);
                currentRange = 0;
            }
        }

        longestRange = Math.max(longestRange, currentRange);

        return longestRange;
    }
    public static boolean braceCheck(String str){

        int len = str.length();
        Map<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');


        Stack<Character> stack = new Stack<>();

        for (char c:str.toCharArray()){
            if(map.containsKey(c)){
                stack.push(c);
            }
            else if(map.containsValue(c)){
                if(!stack.isEmpty() && map.get(stack.peek())==c){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }

        return map.isEmpty();
    }

    static int longestRange(int[] bad, int start,int end){
        Arrays.sort(bad);
        int currentRange= 0;
        int longestRange=0;

        for (int i=start;i<=end;i++){
            if(Arrays.binarySearch(bad,i)<0){
                currentRange++;
            }else {
                longestRange=Math.max(longestRange,currentRange);
                currentRange=0;
            }
        }
        return Math.max(longestRange,currentRange);

    }

    public static void main(String[] args) {
        int[] badNumbers = {3, 7, 10};
        int start = 1;
        int end = 12;

        int longestRange = longestContinuousRange(badNumbers, start, end);
        System.out.println("Longest continuous range: " + longestRange);
        System.out.println("Longest:"+longestRange(badNumbers,start,end));
    }
}

