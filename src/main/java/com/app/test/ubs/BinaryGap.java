package com.app.test.ubs;
/*

A binary gap within a positive integer N is any maximal sequence of consecutive zeros
that is surrounded by ones at both ends in the binary representation of N.

For example number 9 has binary representation 1001 and contains a binary gap of length 2.
The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one for length 3.
The number 20 has binary representation 10100 and contains one binary gap of length 1.
The number 15 has binary representation 1111 and has no binary gaps.
The number 32 has binary representation 100000 and has no binary gap.

write function
class Solution {
public int solution(int N);
}

that, given a postive integer N, return the length of its longest binary gap.
The function should return 0 if N doesn't contain a binary gap.

Example.
given N=1041 the function should return 5 , because N has binary representation 1000000100001 and
so its longest binary fap is of length 5, Given N=32 the function should return 0,
because N has binary representation 100000 and thus no binary gaps.


Write an efficient algorithm for the following assumptions:
N is an integer within for the range [1...2,147,483,647]
 */
public class BinaryGap {

    public static int solution(int N){
        String binary = Integer.toBinaryString(N);

        int max=0;
        String[] split= binary.split("1");
       int n= binary.charAt(binary.length()-1)=='1'? split.length: split.length-1;


        for(int i=0;i<n;i++){
            if(max<split[i].length()){
                max=split[i].length();
            }
        }
        return max;
//   number 529 has binary representation 1000010001
      //  System.out.println(binary);
      //  System.out.println(intToBinary(N));

       // return 0;
    }

    private static String intToBinary(int n){


        // array to store binary number
        int[] binaryNum = new int[1000];
        StringBuilder builder = new StringBuilder();

        // counter for binary array
        int i = 0;
        while (n > 0)
        {
            // storing remainder in binary array
            builder.append(n%2);
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution(1041));
        System.out.println(solution(32));
        System.out.println(solution(20));
    }
}
