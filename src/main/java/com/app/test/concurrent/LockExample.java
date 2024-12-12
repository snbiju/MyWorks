package com.app.test.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*

Locks and Semaphores
Java provides advanced concurrency constructs like locks and semaphores to manage access to shared resources more
 precisely than the synchronized keyword.

ReentrantLock: Offers more control over locking mechanisms, including the ability to interrupt and time out.

 The ReentrantLock ensures that the increment method can be safely accessed by multiple threads.
 */
public class LockExample {
    private final Lock lock = new ReentrantLock();
    private int counter = 0;
    public void increment() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockExample lockExample = new LockExample();
        lockExample.increment();
    }
}