package com.app.codes.concurrent;

import java.util.concurrent.Phaser;

/*
Phaser: A more flexible synchronization barrier, allowing dynamic registration and deregistration of threads.
 */
public class PhaserExample {
    private static final int N_TASKS = 3;
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // "1" to register the main thread
        for (int i = 0; i < N_TASKS; i++) {
            phaser.register();
            new Thread(new Task2(phaser)).start();
        }
        phaser.arriveAndAwaitAdvance(); // Main thread waits for all tasks to complete
        System.out.println("All tasks completed.");
    }
}
class Task2 implements Runnable {
    private final Phaser phaser;
    public Task2(Phaser phaser) {
        this.phaser = phaser;
    }
    @Override
    public void run() {
        System.out.println("Task executed by " + Thread.currentThread().getName());
        phaser.arriveAndDeregister(); // Signal arrival and deregister
    }
}
