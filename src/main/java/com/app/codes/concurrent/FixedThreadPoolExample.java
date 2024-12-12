package com.app.codes.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*

Thread Pools
Executors Framework
The Executors framework in Java provides a high-level API for managing a pool of threads, making it easier to handle a
large number of concurrent tasks efficiently.

FixedThreadPool: Creates a thread pool with a fixed number of threads.
CachedThreadPool: Creates a thread pool that creates new threads as needed but reuses previously constructed
 threads when they are available.

 ScheduledThreadPool: Creates a thread pool that can schedule commands to run after a given delay or to execute periodically.
 */
public class FixedThreadPoolExample {
    private static final int N_THREADS = 5;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> System.out.println("Task executed by " + Thread.currentThread().getName()));
        }
        executor.shutdown();

        ExecutorService executor1 = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executor1.execute(() -> System.out.println("Task executed by newCachedThreadPool " + Thread.currentThread().getName()));
        }
        executor1.shutdown();

        ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(2);
        executor2.scheduleAtFixedRate(() -> System.out.println("Task executed by ScheduledExecutorService " + Thread.currentThread().getName()), 1, 3, TimeUnit.SECONDS);
    }
}