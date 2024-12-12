package com.app.codes.amz;


public class ConcurrentIncrement {
    private static  int x =0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
               x=x+1;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                x=x+1;
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final value of x: " + x);
    }
}

