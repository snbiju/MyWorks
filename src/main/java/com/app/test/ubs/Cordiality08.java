package com.app.test.ubs;

import java.util.HashSet;

/*

 A small frog wants to get to the other side of a river. The frog is initially located on one bank of t he river (position 0), and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.

You are given a non-empty zero-indexed array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.

The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X.

For example, you are given integer X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

Write a function:

class Solution { public int solution(int X, int[] A); }
that, given a non-empty zero-indexed array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.

If the frog is never able to jump to the other side of the river, the function should return −1.

For example, given X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4


the function should return 6, as explained above. Assume that:

N and X are integers within the range [1..100,000];
each element of array A is an integer within the range [1..X].

Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(X), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

 */
public class Cordiality08 {


    public static int solution(int X, int[] A) {
        int steps = X;
        boolean[] bitmap = new boolean[steps + 1];
        for (int i = 0; i < A.length; i++) {
            if (!bitmap[A[i]]) {
                bitmap[A[i]] = true;
                steps--;
                if (steps == 0) return i;
            }

        }
        return -1;
    }

    public static int solution01 (int X, int[] A){

        int[]counter = new int[X+1];
        int ans = -1;
        int x = 0;

        for (int i=0; i<A.length; i++){
            if (counter[A[i]] == 0){
                counter[A[i]] = A[i];
                x += 1;
                if (x == X){
                    return i;
                }
            }
        }

        return ans;
    }

    public static int solution2(int X, int[] A) {
        HashSet<Integer> hset = new HashSet<Integer>();

        for (int i = 0 ; i < A.length; i++) {
            if (A[i] <= X)
                hset.add(A[i]);
            if (hset.size() == X)
                return i;
        }

        return -1;
    }

    public static int solution3(int X, int[] A){
        HashSet<Integer> hs = new HashSet<>();
        for(int i=1;i<=X;i++){
            hs.add(i);
        }
        for(int i=0;i<A.length;i++){
            if(hs.remove(A[i])){
                if(hs.isEmpty()){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(5,new int []{1,3,1,4,2,3,5,4}));
        System.out.println(solution01(5,new int []{1,3,1,4,2,3,5,4}));
        System.out.println(solution2(5,new int []{1,3,1,4,2,3,5,4}));
        System.out.println(solution3(5,new int []{1,3,1,4,2,3,5,4}));
    }
}
