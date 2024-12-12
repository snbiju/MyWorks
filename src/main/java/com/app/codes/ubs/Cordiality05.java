package com.app.codes.ubs;

import java.util.HashSet;

/*
Write a function
 class Soliution { public int solution(int [] A){}}
 that, given an array A consiting of N integers retruns the number of distinct values in array A

 A[0] = 2  A[1]=1 A[2]=1
 A[3] = 2  A[4]=3 A[5] = 1

 the function should return 3, beause there are 3 distinct alues in array A, namely 1,2. and 3.

 Write an efficient algorithm for the following assumptions:
 	 N is an integer within the range [0...100,000];
 	 each element of array A is an integer within teh range [-1,000,000....1,000,000].


 */
public class Cordiality05 {

    public static int solution(int [] A){

        HashSet set = new HashSet();

        for (int a:A
             ) {
            set.add(a);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,2,3,1,2,3}));
        System.out.println(solution(new int[] {2,1,3,2,2,1}));
    }
}
