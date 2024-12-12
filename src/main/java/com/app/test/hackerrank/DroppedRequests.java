package com.app.test.hackerrank;
/*
The fictional world of Hacker land has severs whose efficiencies can be increased by adding more cores of them thus allowing
more threads to be processed. A server has several core which can process thread is client requests. Each seconds, either some
thread is assigned to a core and is added to the pool for serving requests. or a request comes in. This is denoted by the array
server[] where a positive value indicates the number of threads added, and -1 indicates a request coming in.
The request come in only on at a time. each thread can serve at most one request and then is destroyed. if there are no available
threads when a request comes in, the request goes unattended and dropped. Find number of requests that are dropped.

Example
For example, consider n-4 and server=[1,-1,-1,1].
In this case.
.server[0] =1 so numThreads =1, droppedRequest=0
-server[1]=-1 so the request is served by thread now. numThreads=0, droppedRequests=0
.server[2]=-1 A request comes in but there are no available threads, the request is dropped. Thus, numThreads=0, droppedRequests=1.
-server[3]=1 so numThreads=1, droppedRequest=1.

Hence, the number of dropped request is 1.


The time complexity of the provided code is O(n), where n is the length of the input array server.
The code iterates through the array once, processing each server entry and request.

The space complexity is O(1) because the amount of memory used by the algorithm does not scale with the size of the input.
The variables numThreads and droppedRequests are constant,
and there is no dynamic data structure that grows with the input size.

 */

import java.util.List;

public class DroppedRequests {

    public static void main(String[] args) {
        int n = 4;
        int[] server = {1, -1, -1, 1};
        int n1 = 6;
        int[] server1 = {-1, -1, 2, -1,1,-1};
        int droppedRequests = getDroppedRequests(n, server);

        System.out.println("Number of dropped requests: " + droppedRequests);
        System.out.println(getDroppedRequests(n1,server1));
    }
    public static int countDroppedRequests(List<Integer> server) {
        int numThreads = 0;
        int droppedRequests = 0;

        for (int i=0;i<server.size();i++){
            if(server.get(i)>0){
                numThreads=numThreads+server.get(i);
            }else{
                if(numThreads>0) {
                    numThreads=numThreads+server.get(i);

                }else{
                    droppedRequests = droppedRequests + 1;
                }
            }
        }

        return droppedRequests;
    }
    public static int getDroppedRequests(int n, int[] server) {
        int numThreads = 0;
        int droppedRequests = 0;

        for (int i = 0; i < n; i++) {
            // Process thread addition
            if (server[i] > 0) {
                numThreads += server[i];
                // Check if the number of threads exceeds the limit
                if (numThreads > 2 * i + 1) {
                    int excessThreads = numThreads - (2 * i + 1);
                    droppedRequests += excessThreads;
                    numThreads -= excessThreads;
                }
            }

            // Process request
            if (server[i] == -1) {
                // Check if there are available threads
                if (numThreads > 0) {
                    numThreads--;
                } else {
                    droppedRequests++;
                }
            }
        }

        return droppedRequests;
    }
}

