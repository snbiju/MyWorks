package com.app.test.ubs;

/*

A non-empty array A consisting of N integers is given. Array A represent numbers on a tape.
An integer P. Such that 0<P<N, splits this tape into two non-empty parts: A[0],A[1]...A[P-1] and A[P],A[P+1],....A[N-1].

The difference between the two parts is the value of : |(A[0]+A[1]+...+A[P-1]+A[P+1]...+A[N-1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example consider array A such that?:

A[0] = 3
A[1]=1
A[2]=2
A[3]=4
A[4]=3

we can split this tape in four places:

p=1 , difference =|3-10|=7
p=2 , difference =|4-9|=5
p=3 , difference =|6-7|=1
p=4, difference =|10-3|=7

write a function
class Solution { public int solution (int[] A);
that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

For example, given

[0] = 3
A[1]=1
A[2]=2
A[3]=4
A[4]=3

the function should return 1, as explained above.
write an efficient algorithm for the following assumptions:

N is an integer within the range [2.....100,00]:
each element of array A is an integer within the range [-1,000 1000]

 */
public class Cordiality07 {
    public static int solution(int[] A){
        int rightSum=0;
        for(int i=0;i<A.length;i++){
            rightSum+=A[i];
        }
        int leftSum=0;
        int maxDiff= Integer.MAX_VALUE;
        for (int i=0;i<A.length-1;i++){
            rightSum-=A[i];
            leftSum+=A[i];
            if(Math.abs(leftSum-rightSum)<maxDiff)
            maxDiff=Math.abs(leftSum-rightSum);

        }

        return maxDiff;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int [] {3,1,2,4,3}));
        System.out.println(solution(new int [] {1000,-1000}));
    }
}
