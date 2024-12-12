package com.app.codes.hackerrank;


/*

Sock Merchant:

Description: John works at a clothing store. He has a list of socks where each sock is labeled with its color.
 He wants to sell as many socks as possible, but he also wants to group the socks by color.
 */
import java.util.HashMap;
import java.util.Map;

public class SockMerchant {

    public static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> sockCount = new HashMap<>();
        int pairCount = 0;

        // Count the occurrences of each color
        for (int color : ar) {
            sockCount.put(color, sockCount.getOrDefault(color, 0) + 1);
        }

        // Count the number of pairs for each color
        for (int count : sockCount.values()) {
            pairCount += count / 2;
        }

        return pairCount;
    }

    public static void main(String[] args) {
        int n = 9;
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};

        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}

