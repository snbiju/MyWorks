package com.app.test.ubs;

import java.util.HashSet;

/*
A non-empty array A consisting of N integer is given. Te array contains an odd number if elements, eand each element of the array can be paired with another element that has the same value except for one element that is left unpaired.

for example, in array A such that
A[0] =9  A[1]=3 A[2]=9
A[3]=3  A[4] =9 A[5]=7
a[6]=9

the element at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9
the element at index 5 has value 7 and is unpaired.

wirte a function:
 class solution { public int solution(int[] A);}

 that given an array A considering of N integers fulfilling the above conditions, return the value of the unpaired element.

 for example, in array A such that
A[0] =9  A[1]=3 A[2]=9
A[3]=3  A[4] =9 A[5]=7
a[6]=9
the function should return 7, as explained in the exaple above.

write efficient algorithm for following assumptions:
N is an odd integer within the rage [1...1,0000,000];
each element of array A is an integer within the range [1, 1,0000,000,000]
all but one of the value in A occur an even number of times

 */
public class Cordiality03 {

    public static int solution1(int[] A){
        HashSet<Integer> setArray= new HashSet<>();

        for(int i=0;i<A.length;i++ ){
            if(setArray.contains(A[i])){
                setArray.remove(A[i]);
            }else {
                setArray.add(A[i]);
            }
        }

        return setArray.iterator().next();
    }

    public static int solution(int[] A) {
        int result = 0;

        for (int num : A) {
            result ^= num;
        }

        return result;
    }
    public static void main(String[] args) {
        int [] array ={9,3,9,3,9,7,9};
        System.out.println(solution(array));
    }
}
