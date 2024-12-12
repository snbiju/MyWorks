package com.app.codes.concurrent;
/*
Basic Concurrency Concepts
Concurrency in Java begins with understanding the basic building blocks: threads and the Runnable interface.
A thread is a lightweight process that can execute code concurrently with other threads.
The Runnable interface provides a way to define a task that can be executed by a thread.

Challenges in Concurrent Programming.
Concurrent programming introduces several challenges that developers must address to ensure correctness
and performance:

Race Conditions: Occur when multiple threads access shared data simultaneously, leading to unpredictable results.
Deadlocks: Happen when two or more threads are waiting indefinitely for each other to release resources.
Thread Starvation: Arises when threads are perpetually denied access to resources, preventing them from making progress.
Understanding these challenges is crucial for developing reliable concurrent applications.
 */
public class BasicRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from a thread!");
    }
    public static void main(String[] args) {
        Thread thread = new Thread(new BasicRunnable());
        thread.start();
    }
}
