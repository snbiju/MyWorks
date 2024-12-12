package com.app.codes.ubs;

import java.util.HashSet;

/*

 	 An  array A consisting of N different integers is given. The array contains integers in the range[1..(N+1)], which means that exactly one element is missing.

 	 your goal is to find that missing element.

 	 write a function

 	 class Solution { publi int solution (int[] A);
}
That, given an array A, returns the value of the missing element

For example
A[0] = 2
A[1]=3
A[2]=1
A[3]=5

the function should return 4, as it is missing element,
 Write an efficient algorithm for the following assumptions:
 	 N is an integer within the range [0...100,000];
 	 the elements of A are all distinct;
 	 each element of array A is an integer within the range [1..(N+1)]
 */
public class Cordiality06 {

    public static int  solution (int[] A){
        HashSet<Integer> elements = new HashSet<>();
        int sum = 0;
        for (int i=1;i<=A.length+1;i++) {
            elements.add(i);
        }
        for (int i=0;i<A.length;i++
             ) {
                elements.remove(A[i]);
        }

    return elements.iterator().next();
    }

    public static int solution1(int [] A){
        int n = A.length;
        boolean[] found = new boolean[n + 2];  // Create a boolean array to mark found elements
        for (int a : A) {
            if (a > 0 && a <= n) {
                found[a] = true;  // Mark the found elements as true
            }
        }
        for (int i = 1; i < found.length; i++) {
            if (!found[i]) {
                return i;  // The first false element represents the missing positive integer
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        System.out.println(solution1(new int[] {2,3,1,5}));
        System.out.println(solution(new int[] {2,3,1,5}));
    }
}
