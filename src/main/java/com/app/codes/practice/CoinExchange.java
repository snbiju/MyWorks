package com.app.codes.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinExchange {
    static List<Integer> coins = List.of(200,100,50,20,10,5,2,1);

    static List<Integer> getExchangeCoins(int value){
        List<Integer> reuslt = new ArrayList<>();
        for (int coin:coins
             ) {
             while (value>=coin){
                 value-=coin;
                 reuslt.add(coin);
             }
        }

        return reuslt;
    }
/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0


Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];

    }

    public static void main(String[] args) {
        System.out.println(getExchangeCoins(788));

        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println(coinChange(coins1, amount1));  // Output: 3

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println(coinChange(coins2, amount2));  // Output: -1

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println(coinChange(coins3, amount3));  // Output: 0
    }
}
