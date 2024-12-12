package com.app.test.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
/*

Real-life Example: Parallel Processing of Large Datasets

The Fork/Join framework can be used to parallelize the processing of large datasets,
improving performance and efficiency.


 */
public class ParallelSearch {
    private static class SearchTask extends RecursiveTask<Integer> {
        private final int[] array;
        private final int start;
        private final int end;
        private final int target;
        private static final int THRESHOLD = 10_000;

        public SearchTask(int[] array, int start, int end, int target) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.target = target;
        }

        @Override
        protected Integer compute() {
            if (end - start <= THRESHOLD) {
                for (int i = start; i < end; i++) {
                    if (array[i] == target) {
                        return i;
                    }
                }
                return -1;
            } else {
                int mid = (start + end) / 2;
                SearchTask leftTask = new SearchTask(array, start, mid, target);
                SearchTask rightTask = new SearchTask(array, mid, end, target);
                leftTask.fork();
                int rightResult = rightTask.compute();
                int leftResult = leftTask.join();
                return leftResult != -1 ? leftResult : rightResult;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        ForkJoinPool pool = new ForkJoinPool();
        int index = pool.invoke(new SearchTask(array, 0, array.length, 42));
        System.out.println("Index of target: " + index);
    }
}