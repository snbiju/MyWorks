package com.app.codes.concurrent;

import java.util.concurrent.CompletableFuture;
/*

Real-life Example: Non-blocking I/O Operations in a Web Application

CompletableFuture can be used to perform non-blocking I/O operations, improving the responsiveness of web applications.
 */
public class NonBlockingIOExample {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> performIO())
                .thenAccept(result -> System.out.println("I/O Result: " + result))
                .exceptionally(ex -> {
                    System.err.println("Error: " + ex.getMessage());
                    return null;
                });
    }
    private static String performIO() {
        // Simulate I/O operation
        return "I/O Operation Completed";
    }
}
