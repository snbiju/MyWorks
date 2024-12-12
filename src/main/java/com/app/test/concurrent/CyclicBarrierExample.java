package com.app.test.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/*
CyclicBarrier: Allows a set of threads to all wait for each other to reach a common barrier point.
 */
public class CyclicBarrierExample {
    private static final int N_TASKS = 3;
    private static final CyclicBarrier barrier = new CyclicBarrier(N_TASKS, () -> System.out.println("All tasks are done!"));
    public static void main(String[] args) {
        for (int i = 0; i < N_TASKS; i++) {
            new Thread(new Task1(barrier)).start();
        }
    }
}
class Task1 implements Runnable {
    private final CyclicBarrier barrier;
    public Task1(CyclicBarrier barrier) {
        this.barrier = barrier;
    }
    @Override
    public void run() {
        System.out.println("Task executed by " + Thread.currentThread().getName());
        try {
            barrier.await(); // Wait for all threads to reach this point
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        }
    }
}