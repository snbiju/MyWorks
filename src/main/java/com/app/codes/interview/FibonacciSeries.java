package com.app.codes.interview;

public class FibonacciSeries {

    // Recursive method to calculate the nth Fibonacci number
    public static int fib(int n) {
        // Base cases
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        // Recursive case
        return fib(n - 1) + fib(n - 2);
    }

    // Method to print the Fibonacci series up to n terms
    public static void printFibonacciSeries(int n) {
        System.out.print("Fibonacci series up to " + n + " terms: ");

        // Calculate and print the Fibonacci series up to n terms
        for (int i = 0; i < n; i++) {
            int fibNumber = fib(i);
            System.out.print(fibNumber);

            // Add a comma and space between numbers except for the last term
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(); // Move to the next line after printing the series
    }

    public static void main(String[] args) {
        // Define the number of terms you want to print
        int n = 10; // Example: Print the first 10 terms of the Fibonacci series

        // Print the Fibonacci series
        printFibonacciSeries(n);

        // Initialize the first two terms of the Fibonacci series
        int firstTerm = 0;
        int secondTerm = 1;

        // Print the initial terms of the Fibonacci series
        System.out.print("Fibonacci series up to " + n + " terms: ");
        System.out.print(firstTerm + ", " + secondTerm);

        // Calculate and print the remaining terms
        for (int i = 3; i <= n; i++) {
            int nextTerm = firstTerm + secondTerm;
            System.out.print(", " + nextTerm);
            // Update the terms for the next iteration
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }
}
