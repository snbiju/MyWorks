package com.app.test.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExceptionHandling {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("Something went wrong!");
            }
            return "Hello";
        }).exceptionally(ex -> "Recovered from: " + ex.getMessage());
        try {
            System.out.println(future.get()); // Prints "Recovered from: Something went wrong!"
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}