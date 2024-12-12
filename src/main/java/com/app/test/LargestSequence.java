package com.app.test;

import java.util.*;


/*
Given an integer sequence s = (s1,s2,s3,…,sn), a subsequence is another sequence s_ = (s_1, s_2, s_3…., s_k) with k < n, and s_1, s_2, s_3…, s_k belonging to s, exactly in that order.
Find the maximum length of a subsequence in which its elements are in increasing sorted order, lowest to highest. The subsequence doesn't have to be necessarily contigous, or unique.

INPUT
int[]    seaquence

OUTPUT
int    k

CONSTRAINTS
1 <= n <= 3000
0 <= si <= 1000000000

EXAMPLE
Input
[0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15]

Output
6


Input:
int[] sequence: 5,19,5,81,50,28,29,1,83,23
Output:
Expected:
5
Actual:
5


Input:
int[] sequence: 1000000000,22,9,33,21,50,41,60,80,90,90,100,103,108,105
Output:
Expected:
9
Actual:
9


Input:
int[] sequence: 1,0,2,6,3,4,5,11,12,13
Output:
Expected:
8
Actual:
8



Input:
int[] sequence: 1,10,2,4,6,5,13,3,11,7,15
Output:
Expected:
6
Actual:
6


[1, 10, 2, 4, 6, 5, 13, 3, 11, 7, 15]
[1, 2, 2, 3, 4, 4, 5, 3, 5, 5, 6]

 */
public class LargestSequence {
    public  int run1(int[] sequence) {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */
        if(sequence.length==0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        int k = 1;
        for(int e : sequence){
            if(map.containsKey(e)){
                map.put(e,map.get(e)+1);
            }else{
                map.put(e,k);
            }
        }






        return Collections.max(map.values());
    }
    public static int run(int[] sequence) {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */
        if(sequence.length==0){
            return 0;
        }
        int n=sequence.length;
        int[] list = new int[sequence.length];
        int i, j, max = 0;

        for (i = 0; i < n; i++)
            list[i] = 1;


        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (sequence[i] > sequence[j] && list[i] < list[j] + 1)
                    list[i] = list[j] + 1;

        for (i = 0; i < n; i++)
            if (max < list[i])
                max = list[i];

        return max;


    }

    public static void main(String[] args) {
        LargestSequence sequence= new LargestSequence();
        int[] seq= {1,10,2,4,6,5,13,3,11,7,15};
        System.out.println(run(seq));
        
    }
}
