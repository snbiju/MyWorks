package com.app.codes.trans;

import java.util.concurrent.*;

public class ConcurrencyThread implements Runnable{

    public void threadCountDown() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t = new Thread(() -> {
            countDownLatch.countDown();
            countDownLatch.countDown();
        });
        t.start();
        countDownLatch.await();

        System.out.println(assertEquals(0, countDownLatch.getCount()));
    }

    public void theadCyclic(){

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        Thread t = new Thread(() -> {
            try {
                cyclicBarrier.await();
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                // error handling
            }
        });
        t.start();

        System.out.println( assertEquals(1, cyclicBarrier.getNumberWaiting()));
        System.out.println(assertFalse(cyclicBarrier.isBroken()));
    }

    private boolean assertFalse(boolean broken) {
        return broken;
    }

    private boolean assertEquals(int i, long count) {
        return i==count;
    }
    // create a static CyclicBarrier instance
    public static CyclicBarrier newBarrier
            = new CyclicBarrier(3);
    public static void main(String[] args) throws InterruptedException {
        ConcurrencyThread concurrencyThread = new ConcurrencyThread();
        concurrencyThread.threadCountDown();
        concurrencyThread.theadCyclic();

        CountDownLatch latch = new CountDownLatch(4);

        // Creating worker threads
        Worker first = new Worker(1000, latch, "WORKER-1");
        Worker second = new Worker(2000, latch, "WORKER-2");
        Worker third = new Worker(3000, latch, "WORKER-3");
        Worker fourth = new Worker(4000, latch, "WORKER-4");

        // Starting above 4 threads
        first.start();
        second.start();
        third.start();
        fourth.start();

        // The main task waits for four threads
        latch.await();

        // Main thread has started
        System.out.println(Thread.currentThread().getName()
                + " has finished");



        Thread t1 = new Thread(concurrencyThread);

        // Starting the thread using start() method
        t1.start();
    }

    public void run()
    {
        // Print statement
        System.out.println(
                "Number of parties required to trip the barrier = "
                        + newBarrier.getParties());
        System.out.println(
                "Sum of product and sum = "
                        + (Computation1.product + Computation2.sum));

        // Creating object of class 1 objects
        // on which the child thread has to run
        Computation1 comp1 = new Computation1();
        Computation2 comp2 = new Computation2();

        // creation of child thread
        Thread t1 = new Thread(comp1);
        Thread t2 = new Thread(comp2);

        // Moving child thread to runnable state
        t1.start();
        t2.start();

        try {
            // parent thread awaits
            ConcurrencyThread.newBarrier.await();
        }

        catch (InterruptedException
               | BrokenBarrierException e) {

            // Display exceptions along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }

        // barrier breaks as the number of thread waiting
        // for the barrier at this point = 3
        System.out.println(
                "Sum of product and sum = "
                        + (Computation1.product + Computation2.sum));

        // Resetting the newBarrier
        newBarrier.reset();
        System.out.println("Barrier reset successful");
    }

}
class Worker extends Thread {
    private final int delay;
    private final CountDownLatch latch;

    public Worker(int delay, CountDownLatch latch,
                  String name)
    {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override public void run()
    {
        try {
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(
                    Thread.currentThread().getName()
                            + " finished");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Computation1 implements Runnable {

    public static int product = 0;
    public void run()
    {
        product = 2 * 3;
        try {
            // thread1 awaits for other threads
            ConcurrencyThread.newBarrier.await();
        }
        catch (InterruptedException
               | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

// Class 2
// Implementing Runnable interface
class Computation2 implements Runnable {

    public static int sum = 0;
    public void run()
    {
        // check if newBarrier is broken or not
        System.out.println("Is the barrier broken? - "
                + ConcurrencyThread.newBarrier.isBroken());
        sum = 10 + 20;
        try {
            ConcurrencyThread.newBarrier.await(3000,
                    TimeUnit.MILLISECONDS);

            // number of parties waiting at the barrier
            System.out.println(
                    "Number of parties waiting at the barrier "
                            + "at this point = "
                            + ConcurrencyThread.newBarrier.getNumberWaiting());
        }
        catch (InterruptedException
               | BrokenBarrierException e) {
            e.printStackTrace();
        }
        catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}