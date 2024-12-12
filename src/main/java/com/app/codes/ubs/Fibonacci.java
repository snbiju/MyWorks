package com.app.codes.ubs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fibonacci {

    private static final Map<Integer, Integer> memoizationMap = new HashMap<>();
    private static List<Integer> fibList= new ArrayList<>();

    public static void main(String[] args) {
        int n = 10; // Change this to the desired length of the Fibonacci sequence

        System.out.println("Fibonacci Sequence:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
        System.out.println(memoizationMap);
        System.out.println();
        System.out.println();
        System.out.println("Fib List"+fibList);
        for (int i = 0; i < n; i++) {
            System.out.print(fibonaccis(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(fibonaccies(i) + " ");
        }
        System.out.println();

        int fact= factorial(5);
        for (int i = 0; i < 5; i++) {
            if (i == 4) {
                System.out.print(arry[i] + " = ");
            } else
                System.out.print(arry[i] + " * ");

        }
        System.out.println(fact);

    }
    public static int fibonaccis(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonaccis(n - 1) + fibonaccis(n - 2);
        }
    }

    //Recursion
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            // Check if the result is already memoized
            if (memoizationMap.containsKey(n)) {
                return memoizationMap.get(n);
            }

            // Calculate and memoize the result
            int result = fibonacci(n - 1) + fibonacci(n - 2);
            memoizationMap.put(n, result);
            fibList.add(result);

            return result;
        }
    }

    //Recursion
    public static int fibonaccies(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonaccies(n - 1) + fibonaccies(n - 2);
        }
    }

    //Factorial
    static int[] arry = new int[5] ;
    static int i=0;
    public static int factorial(int n) {
        arry[i]=n;
        i++;
        if (n == 0 || n == 1) {

            return 1;
        } else {

            return n * factorial(n - 1);
        }
    }


}
