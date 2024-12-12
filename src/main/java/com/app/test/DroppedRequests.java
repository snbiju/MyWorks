package com.app.test;

/*

The fictional world of Hackerland has servers whose efficiencies can be increased by adding more cores
to them thus allowing more thread to be processed.
A server has several cores which can be process threads for serving client requests.
Each second, either some thread is assigned to be core and is added  to the pool for serving request,or a request comes in.
This is denoted by the array server[] where  a positive value indicates the number of threads added , and -1
indicates a request coming in.
The request come in only one at a time. Each thread can server at most one request and then is destroyed .
if there are no available threads when a request comes in the request goes unattended and is dropped.
Find the number of request that are dropped.

Eg: consider n=4 and server = [1,-1,-1,1]
in  this case
server[0]=1 so numThreads = 1, droppedRquests =0
server[1]= = -1 So the request is served by the thread. Now numThread=0 , droppedRequest=0
server[2] = -1 A request come in but there are no available threads the request is dropped.
Thus, numThreads = 0 droppedRequest=1.
server[3]=1 so numTheads=1, droppedRequests=1.
Hence, the number of dropped request is 1.

Functional Description
Complete the functional countDroppedRequest in the editor
countDroppedRequest has the following parameter
int server[n]: the chronological order processing by the server

Return

int: the number of request that are dropped

constrains

1<=n<=10^5


Test Case

server [-1,-1,2,-1,1,-1] n=6
output 2

server[3,-1,-1,-1] n=5
output 1


 */
import java.util.List;

public class DroppedRequests {
    public static int countDroppedRequests(int n, int[] server) {
        int numThreads = 0;
        int droppedRequests = 0;
        int[] servedRequests = new int[n];

        for (int i = 0; i < n; i++) {
            if (server[i] > 0) {
                if (numThreads < 3) {
                    int serveCount = Math.min(server[i], 3 - numThreads);
                    numThreads += serveCount;
                    servedRequests[i] = serveCount;
                } else {
                    droppedRequests += server[i];
                }
            } else if (i > 0) {
                servedRequests[i] = servedRequests[i - 1];
            }

            if (i - 10 >= 0) {
                numThreads -= servedRequests[i - 10];
            }
        }

        return droppedRequests;
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

    public static void main(String[] args) {
        int n = 6;
        int[] server = {1,-1,-1,1};
        int []server0={-1,-1,2,-1,1,-1};

        List<Integer> server1= List.of(1,-1,-1,1);
        List<Integer> server2= List.of(-1,-1,2,-1,1,-1);
        List<Integer> server3= List.of(3,-1,-1,-1,-1);
       // int droppedRequests = countDroppedRequests(n, server);
   //     System.out.println("Number of dropped requests: " + droppedRequests);
   //     System.out.println("Number of dropped requests0: " + countDroppedRequests(n, server0));

        System.out.println("Number of dropped requests1: " + countDroppedRequests(server1));
        System.out.println("Number of dropped requests2: " + countDroppedRequests(server2));
        System.out.println("Number of dropped requests3: " + countDroppedRequests(server3));
    }
}

