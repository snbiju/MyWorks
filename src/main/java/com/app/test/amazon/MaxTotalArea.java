package com.app.test.amazon;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MaxTotalArea {

    private static final int MOD = 1000000007;

    public static int getMaxTotalArea(int[] sideLengths) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int length : sideLengths) {
            freq.put(length, freq.getOrDefault(length, 0) + 1);
        }

        // Using a max-heap
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                Comparator.comparingInt((int[] pair) -> pair[0]).reversed()
        );

        // Add all entries from frequency map to heap
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            heap.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        long area = 0;
        Integer pair1 = null;
        Integer pair2 = null;

        while (!heap.isEmpty()) {
            int[] current = heap.poll();
            int length = current[0];
            int repeat = current[1];

            if (repeat > 1) {
                repeat -= 2;
                pair2 = length;
            }

            if (repeat == 1) {
                // Check next element in the heap and merge it if necessary
                if (!heap.isEmpty() && length - 1 == heap.peek()[0]) {
                    int[] next = heap.poll();
                    heap.offer(new int[]{next[0], next[1] + 1});
                }
            } else if (repeat > 1) {
                heap.offer(new int[]{length, repeat});
            }

            if (pair1 != null && pair2 != null) {
                area += (long) pair1 * pair2;
                area %= MOD;
                pair1 = null;
                pair2 = null;
            } else if (pair2 != null) {
                pair1 = pair2;
                pair2 = null;
            }
        }

        return (int) (area % MOD);
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 3, 4, 6, 8, 8, 6, 8};
        System.out.println(getMaxTotalArea(arr1)); // Output

        int[] arr2 = {3, 4, 5, 5, 6};
        System.out.println(getMaxTotalArea(arr2)); // Output

        int[] arr3 = {2, 6, 6, 2, 3, 5};
        System.out.println(getMaxTotalArea(arr3)); // Output
    }
}
