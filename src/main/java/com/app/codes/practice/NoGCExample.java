package com.app.codes.practice;

import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;

public class NoGCExample {

    // Pre-allocate buffers in an object pool
    private static final int BUFFER_POOL_SIZE = 10;
    private static final int BUFFER_SIZE = 1024; // Size of each buffer in bytes
    private static ArrayBlockingQueue<ByteBuffer> bufferPool = new ArrayBlockingQueue<>(BUFFER_POOL_SIZE);

    // Initialize the buffer pool with pre-allocated ByteBuffers
    static {
        for (int i = 0; i < BUFFER_POOL_SIZE; i++) {
            bufferPool.offer(ByteBuffer.allocateDirect(BUFFER_SIZE));
        }
    }

    // Method to acquire a buffer from the pool
    public static ByteBuffer acquireBuffer() throws InterruptedException {
        return bufferPool.take();
    }

    // Method to release a buffer back to the pool
    public static void releaseBuffer(ByteBuffer buffer) {
        buffer.clear(); // Reset the buffer for reuse
        bufferPool.offer(buffer);
    }

    public static void main(String[] args) throws InterruptedException {
        // Example usage of the buffer pool to minimize garbage collection

        // Acquire a buffer from the pool
        ByteBuffer buffer = acquireBuffer();

        // Use the buffer for some operations
        buffer.putInt(42);
        buffer.putDouble(3.14);
        buffer.flip(); // Flip the buffer for reading

        // Read data from the buffer
        int intValue = buffer.getInt();
        double doubleValue = buffer.getDouble();

        // Print the read values
        System.out.println("Integer value: " + intValue);
        System.out.println("Double value: " + doubleValue);

        // Release the buffer back to the pool
        releaseBuffer(buffer);

        bufferPool.clear();
        bufferPool.remove(buffer);
        bufferPool.take();
        // Print the read values
        System.out.println("Integer value: " + buffer.getInt());
        System.out.println("Double value: " + buffer.getDouble());
    }
}

