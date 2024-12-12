package com.app.codes.concurrent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*

Real-life Example: Web Server Handling Multiple Client Requests

A web server can handle multiple client requests concurrently using a thread pool,
ensuring efficient resource utilization and faster response times.

 */
public class WebServer {
    private static final int PORT = 8080;
    private static final int THREAD_POOL_SIZE = 10;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                executor.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class ClientHandler implements Runnable {
    private final Socket clientSocket;
    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    @Override
    public void run() {
        // Handle client request
    }
}
