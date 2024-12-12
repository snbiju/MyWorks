package com.app.codes.ubs;

public class JavaThead {

    private static int x = 0;

    public static void main(String[] args) {
        Runnable incrementTask = () -> {
            for (int i = 0; i < 100000000; i++) {
             //   synchronized (JavaThead.class) { // Use a common monitor for synchronization
                    x = x + 1;
             //   }
            }
        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final value of x: " + x);
    }






}
