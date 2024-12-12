package com.app.test;

public class ThreadLocalExp
{
    public static class MyRunnable implements Runnable
    {
        int a=0;
        private final ThreadLocal<Integer> threadLocal =
                new ThreadLocal<Integer>();
        @Override
        public void run() {
            a++;
            threadLocal.set(10 +a);
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(threadLocal.get());
        }
    }
    public static void main(String[] args)
    {
        MyRunnable runnableInstance = new MyRunnable();

        Thread t1 = new Thread(runnableInstance);
        Thread t2 = new Thread(runnableInstance);
        // this will call run() method
        t1.start();
        t2.start();
    }
}