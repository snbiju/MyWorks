package com.app.codes.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/*

4. Fork/Join Framework
The Fork/Join framework in Java is designed for parallel processing, making it easier to take advantage of
multi-core processors. It uses a work-stealing algorithm to balance the load among available threads.

Divide-and-Conquer Strategy
The Fork/Join framework is based on the divide-and-conquer strategy, where tasks are recursively split into smaller
subtasks until they are simple enough to solve directly.

RecursiveTask: Used for tasks that return a result.
 */
public class ForkJoinExample {
    private static class SumTask extends RecursiveTask<Long> {
        private final long[] array;
        private final int start;
        private final int end;
        private static final int THRESHOLD = 10_000;
        public SumTask(long[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);
                leftTask.fork();
                long rightResult = rightTask.compute();
                long leftResult = leftTask.join();
                return leftResult + rightResult;
            }
        }
    }
    public static void main(String[] args) {
        long[] array = new long[20_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        ForkJoinPool pool = new ForkJoinPool();
        long sum = pool.invoke(new SumTask(array, 0, array.length));
        System.out.println("Sum: " + sum);
    }
}