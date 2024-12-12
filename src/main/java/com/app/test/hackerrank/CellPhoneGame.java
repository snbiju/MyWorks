package com.app.test.hackerrank;
/**
 * You are playing a game on your cell phone. You are given an array of
 * length n, indexed from 0 to n-1. Each element of the array is either 0 or
 * 1. You can only move to an index which contains 0. At first, you are at
 * the 0th position. In each move you can do one of the following things:
 * <br>
 * <br>
 * Walk one step forward or backward. <br>
 * Make a jump of exactly m length forward. <br>
 * <br>
 * That means you can move from position x to x+1,x-1 or x+m in one move,
 * but at least one of the following conditions must be true: </br>
 * <br>
 * The new position contains 0. <br>
 * The new position is greater than n-1.<br>
 * <br>
 * You can't move backward from position . If you move to any position
 * greater than n-1, you win the game.
 *

 */

public class CellPhoneGame {
    /*
     * @param m
     *            Jump length
     * @param arr
     *            Input array
     * @param i
     *            Starting position
     * @return
     */
    @SuppressWarnings("unused")
    private static boolean isSolvable(int[] array, int m, int i) {

        /* Base Cases */
        if (i < 0 || array[i] == 1) {
            return false;
        } else if (i + 1 >= array.length || i + m >= array.length) {
            return true;
        }

        array[i] = 1; // marks as visited

        /* Recursive Cases */
        return isSolvable(array, m, i - 1) || isSolvable(array, m, i + 1) || isSolvable(array, m, i + m);
    }
}
