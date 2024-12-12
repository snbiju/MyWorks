package com.app.test.rateLimiter.algo;

import java.util.HashMap;
import java.util.Map;

/*
Fixed Window Algorithm
Let’s answer some back of the envelop questions. Say we were to implement this on a single machine, how much memory would we need to store all of the user’s data?

Let’s say the “userId” can take 8 bytes. In java, 1 byte can hold 1 character., Corresponding to that a counter which is an integer that will require 4 bytes, and then we have timestamp as well, timestamps are usually long datatype and in Java that usually take 8 bytes.

So for 1 user, we’d need at least 8 + 4 + 8 = 20 bytes.

We’ll also be maintaining some sort of metadata (that’ll be the internals of hashtable), for that let’s provision 20 bytes more for each record.

Thus, for a single user we’ll need 40 bytes and to scale this for one million user, the total memory we would need would be 40 * 10⁶ bytes = 40 MB.

40 MB can easily fit on a single server; however we would definitely not want to route all our traffic through this rate limiter why? Because, let’s say we allow 1 user to hit 10 reqeusts per second this would amount to 10 * 1 million = 10 million RPS (requests per second) which is too much for a single server.

Thus for this sort of requirement it is inevitable to use a distributed cache and for that redis or memcache will be useful.

Here’s an in-memory implementation of Fixed Window
 */
public class Limiter {

    private static final Map<String, FixedWindow> hashMap = new HashMap<>();
    // how many request you are going allow
    private static final int THRESHOLD = 3;
    // this is the period, if it is 1 it means you are gonna allow 3 request in 1 second
    private static final int PERIOD_IN_SECONDS = 1;

    static class FixedWindow {
        public int count;
        public long timestamp;

        public FixedWindow(int count, long timestamp) {
            this.count = count;
            this.timestamp = timestamp;
        }
    }

    public boolean request(String userId) {
        // this method returns true or false.
        // If we have exceeded the limit, it will return false signifying the request was dropped.
        // otherwise true
        FixedWindow fixedWindow = hashMap.get(userId);
        long currentTime = System.currentTimeMillis();
        if (fixedWindow == null || currentTime - fixedWindow.timestamp > PERIOD_IN_SECONDS * 1000L) {
            hashMap.put(userId, new FixedWindow(1, currentTime));
            return true;
        } else {
            // check if we have breached the count already
            if (fixedWindow.count < THRESHOLD) {
                fixedWindow.count += 1;
                hashMap.put(userId, fixedWindow);
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Limiter limiter = new Limiter();
        System.out.println("Sent to API Gateway Server? " + (limiter.request("1234") ? "Yes" : "No"));
        System.out.println("Sent to API Gateway Server? " + (limiter.request("1234") ? "Yes" : "No"));
        System.out.println("Sent to API Gateway Server? " + (limiter.request("1234") ? "Yes" : "No"));
        System.out.println("Sent to API Gateway Server? " + (limiter.request("1234") ? "Yes" : "No"));
        Thread.sleep(1000);
        System.out.println("Sent to API Gateway Server? " + (limiter.request("1234") ? "Yes" : "No"));
        System.out.println("Sent to API Gateway Server? " + (limiter.request("1234") ? "Yes" : "No"));

    }
}
