package com.app.codes.sita;


/*

Write a function solution that, given an integer N, returns the maximum possible value obtains by deleting one 'S' digit frOM The
decimal representation of N is guaranteed that N contains at least one 5 digit.

Example
1. Given N= 15958, the function should return 1958
2. Given N= -5859, the function should return -589
3. Given N= -5000, the function should return 0, After deleting the '5', the only   digits in the number are zeros, so its value is 0.

Assume that:
N is an integer within the range [-999,995.. 999,995];
N contains at least one '5' digit in its decimal representation;
N contains at least two digit in its decimal representations.


 */
public class DeleteFive {

    public static int getRefactorNumber(int number){
        String numStr = Integer.toString(number);
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '5') {
                String numWithout5 = numStr.substring(0, i) + numStr.substring(i + 1);
                maxVal = Math.max(maxVal, Integer.parseInt(numWithout5));
            }
        }
        return maxVal;

    }

    public static void main(String[] args) {
        System.out.println(getRefactorNumber(15958));
        System.out.println(getRefactorNumber(-5859));
    }
}
