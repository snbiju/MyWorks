package com.app.codes.concurrent;

import java.util.concurrent.CountDownLatch;

/*
High-Level Concurrency Utilities
java.util.concurrent Package
The java.util.concurrent package provides a rich set of utilities for advanced concurrency control.
Some of the most commonly used classes include:

CountDownLatch: Allows one or more threads to wait until a set of operations being performed by other threads completes.
 */
public class CountDownLatchExample {
    private static final int N_TASKS = 3;
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(N_TASKS);
        for (int i = 0; i < N_TASKS; i++) {
            new Thread(new Task(latch)).start();
        }
        try {
            latch.await(); // Main thread waits until all tasks are done
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("All tasks completed.");
    }
}
class Task implements Runnable {
    private final CountDownLatch latch;
    public Task(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        System.out.println("Task executed by " + Thread.currentThread().getName());
        latch.countDown(); // Decrement the count of the latch
    }
}