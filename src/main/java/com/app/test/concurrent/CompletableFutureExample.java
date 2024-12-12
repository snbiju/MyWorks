package com.app.test.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*

CompletableFuture and Reactive Streams
Asynchronous Programming with CompletableFuture
CompletableFuture provides a way to write non-blocking, asynchronous code in Java.
It allows you to define a pipeline of actions to perform when a computation completes.

Creating and Combining CompletableFutures
 */
public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApplyAsync(greeting -> greeting + " World")
                .thenApplyAsync(message -> message + "!");
        System.out.println(future.get()); // Prints "Hello World!"
    }
}