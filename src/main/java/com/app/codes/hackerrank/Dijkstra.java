package com.app.codes.hackerrank;

import java.util.*;

/*


Initialize distances: Set the distance from the source node to itself to 0 and the distance to all other nodes to infinity.
Maintain a priority queue (min heap) to store nodes with their current distances.

Process nodes: While the priority queue is not empty, do the following:

Extract the node with the minimum distance from the priority queue.
For each neighboring node of the extracted node, calculate the distance from the source node through the extracted node.
 If this distance is shorter than the current known distance to that node, update the distance.
Terminate: Stop when the destination node is extracted from the priority queue.
The distance to the destination node at this point is the shortest path.
 */
public class Dijkstra {
    public static Map<Integer, Integer> dijkstra(Map<Integer, List<Node>> graph, int source, int destination) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        Map<Integer, Integer> distances = new HashMap<>();

        for (int node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        priorityQueue.add(new Node(source, 0));
        distances.put(source, 0);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            if (current.node == destination) {
                break;
            }

            for (Node neighbor : graph.get(current.node)) {
                int newDistance = distances.get(current.node) + neighbor.distance;

                if (newDistance < distances.get(neighbor.node)) {
                    distances.put(neighbor.node, newDistance);
                    priorityQueue.add(new Node(neighbor.node, newDistance));
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(new Node(2, 1), new Node(3, 4)));
        graph.put(2, Arrays.asList(new Node(1, 1), new Node(3, 2), new Node(4, 5)));
        graph.put(3, Arrays.asList(new Node(1, 4), new Node(2, 2), new Node(4, 1)));
        graph.put(4, Arrays.asList(new Node(2, 5), new Node(3, 1)));

        int source = 1;
        int destination = 4;

        Map<Integer, Integer> distances = dijkstra(graph, source, destination);

        System.out.println("Shortest distance from " + source + " to " + destination + ": " + distances.get(destination));
    }

    static class Node {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
