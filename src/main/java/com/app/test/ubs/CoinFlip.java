package com.app.test.ubs;
/*

There are N Coins, each showing either head or tails.
We would like all the coins to from a sequence of alternating head and tails.
What is the minimum number if coins that  must be reversed to achieve this?

write function
class solutiion { public int solution (int [] A};}

that, given an array A consisting of N integers representing the coins , return the minimum number, if coins that must be reversed.
Consecutive elements of array A represent consecutive coins and contains either a 0 (heads) or a 1 (tails).

Example
1. Given array A= [1,0,1,0,1,1], the function should return 1 After reversing the sixth coin,
we achieve an alternating sequence of coins[1,0,1,0,1,0]

2. Given array A= [1,1,0,1,1] ,
the function should return 2.After reversing the first and fifth coins, we achieve an alternating sequence [0,1,0,1,0].
3. Given array A=[0,1,0]; the function should return 0. The sequence of coins is already alternating.
4. Given array A=[0,1,1,0] , teh function should return 2. We can reverse the first and second coins to get the sequence [1,0,1,0].

Assume that
. N is an integer within range [1..100]
. each element of array A i san integer that can have one of the following values: 0,1.

In your solution , focus on correctness. The performance of your solution will not be focus of the assessment.

 */


public class CoinFlip {
    public static int solution(int[] coins) {
        int flips = 0;

        for (int i = 0; i < coins.length; i++) {
            if (i % 2 == 0 && coins[i] == 1) {
                flips++;
            } else if (i % 2 != 0 && coins[i] == 0) {
                flips++;
            }
        }

        return Math.min(flips, coins.length - flips);
    }

    public static void main(String[] args) {
        int[] coins1 = {1, 0, 1, 0, 1, 1};
        int[] coins2 = {1, 1, 0, 1, 1};
        int[] coins3 ={0,1,0};
        int[] coins4 ={0,1,1,0};

        int result1 = solution(coins1);
        int result2 = solution(coins2);
        int result3 = solution(coins3);
        int result4 = solution(coins4);

        System.out.println("Result 1: " + result1); // Output: 1
        System.out.println("Result 2: " + result2); // Output: 2
        System.out.println("Result 3: " + result3); // Output: 0
        System.out.println("Result 4: " + result4); // Output: 2
    }
}
