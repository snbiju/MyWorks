package com.app.codes.ubs;
/*

A non-empty array A consisting of N integers is given. The consecutive element of array represent consecutive car on a rad

Array A contains only 0s and /or 1s.
0 represents a car travelling east.
1 represents a car travelling west

The goal is to count passing cars. We say that a pair of ars(P,Q) ,
 where 0<=P<Q<N, ius p-passing when P is traveling to the east and Q is traveling to the west.

For example , consider array A such that
A[0] = 0
A[1]=1
A[2]=0
A[3]=1
A[4]=1

Wee have five pairs of passing cars:(0,1),(0,3),(0,4),(2,3),(2,4).

class Solution { public int solution (int[] A);
}
that , given a non-empty array A of N integers, return the number if pairs of passing cars.
The function should retrun -1 if the number of paris of passing cars exceeds 1,000,000,000.
For example, given:
A[0] = 0
A[1]=1
A[2]=0
A[3]=1
A[4]=1
the function should retrun 5, as explained above:
write efficient algorithm for the following assumptions:
N is an integer within te range [1...100,000];
each element of array A is an integer that can have one of the following value;0,1
 */
public class Cordiality04 {
    public static int solution(int [] A){
        int eastBoundCarSeen = 0;
        int passingBoundCar = 0;

        for (int car : A) {
            if (car == 0) {
                eastBoundCarSeen++;
            } else {
                passingBoundCar += eastBoundCarSeen;

                if (passingBoundCar > 100000000) {
                    return -1;
                }
            }
        }

        return passingBoundCar;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {0,1,0,1,1}));
    }

}
