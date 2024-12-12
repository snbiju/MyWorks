package com.app.test.concurrent;

import java.util.concurrent.Semaphore;
/*
Semaphore: Used to control access to a fixed number of resources.
Real-life Example: Managing Database Connections

In a web application, a limited number of database connections can be managed using a semaphore,
ensuring efficient use of resources without overwhelming the database server.

 */
public class SemaphoreExample {
    private final Semaphore semaphore = new Semaphore(3); // Allows 3 permits
    public void accessResource() {
        try {
            semaphore.acquire();
            // Access the resource
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }

/*    public DatabaseConnectionPool(int maxConnections) {
        semaphore = new Semaphore(maxConnections);
    }
 */   public void connect() {
        try {
            semaphore.acquire();
            // Simulate database connection usage
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
}