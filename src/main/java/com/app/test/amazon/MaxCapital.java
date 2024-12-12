package com.app.test.amazon;



import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxCapital {
        // Function to calculate the maximum capital
        public static int findMaximizedCapital(int N, int W, int K, int[] Profits, int[] Capital) {
            // Step 1: Create an array of projects where each project is represented by its capital and profit
            int[][] projects = new int[N][2];
            for (int i = 0; i < N; i++) {
                projects[i][0] = Capital[i];  // Capital required for the project
                projects[i][1] = Profits[i];  // Profit from the project
            }

            // Step 2: Sort the projects by the capital required (in ascending order)
            Arrays.sort(projects, Comparator.comparingInt(o -> o[0]));

            // Step 3: Create a max-heap (priority queue) to store profits of projects we can afford
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

            int currentCapital = W;
            int projectIndex = 0;

            // Step 4: Iterate up to K times to choose up to K projects
            for (int i = 0; i < K; i++) {
                // Add all projects we can afford with the current capital to the max-heap
                while (projectIndex < N && projects[projectIndex][0] <= currentCapital) {
                    maxHeap.offer(projects[projectIndex][1]);
                    projectIndex++;
                }

                // If there are no projects we can afford, break early
                if (maxHeap.isEmpty()) {
                    break;
                }

                // Step 5: Select the project with the maximum profit (from max-heap) and add its profit to capital
                currentCapital += maxHeap.poll();
            }

            // Return the maximum capital after selecting at most K projects
            return currentCapital;
        }

        public static void main(String[] args) {
            // Example 1
            int N1 = 3;
            int W1 = 0;
            int K1 = 2;
            int[] P1 = {1, 2, 3};
            int[] C1 = {0, 1, 1};
            System.out.println(findMaximizedCapital(N1, W1, K1, P1, C1));  // Output: 4

            // Example 2
            int N2 = 4;
            int W2 = 1;
            int K2 = 3;
            int[] P2 = {1, 3, 5, 7};
            int[] C2 = {0, 1, 2, 3};
            System.out.println(findMaximizedCapital(N2, W2, K2, P2, C2));  // Output: 10
        }


}
