package com.app.codes.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinActionExample {
    private static class PrintTask extends RecursiveAction {
        private final int start;
        private final int end;
        private static final int THRESHOLD = 10;
        public PrintTask(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        protected void compute() {
            if (end - start <= THRESHOLD) {
                for (int i = start; i < end; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            } else {
                int mid = (start + end) / 2;
                PrintTask leftTask = new PrintTask(start, mid);
                PrintTask rightTask = new PrintTask(mid, end);
                invokeAll(leftTask, rightTask);
            }
        }
    }
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new PrintTask(0, 100));
    }
}