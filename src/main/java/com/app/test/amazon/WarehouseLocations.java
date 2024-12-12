package com.app.test.amazon;

import java.util.*;
/*

Amazon has multiple delivery centers adn delivery warehouse all over the world!
The world is represented by a number line from -10^9 to 10^9. There are n  delivery centers,
the ith one at location x is called a suitable location for a warehouse
if it is possible to bring all the products to that point by travelling a distance of no or more than d.
At any one time, products can be brought from one delivery center and placed calculate
the number of suitable locations in the world. That is, calculate the number of points x on the number line
 ( -10^9 <=x<= 10^9) where the travel distance required to bring all the products to that point is less than or equal to d.
Note: distance between point x and center[i] is |x-center[i]|, the absolute differences


input (n=3 center[]=[-2,1,0] distance=8)
output 3

input (n=4 center[]=[2,0,3,-4] distance=22)
output 5

input (n=3 center[]=[-3,2,2] distance=8)
output 0


Eample
Given n=3, center =[-3,2,2],d=8
suitable locations [-1,0,1]
output 3

Locate the warehouse at x=-3,  First bring products from center[0] = -2 covering a distance of |-3-(-2)|=1 to reach the center and |-3-(-2)| = 1 to return.
Similarly we bring products from centers 1 and 2 to point -3 for total distance of 1+1+4+4+3+3=16 which is >d .
This is not a suitable location.

Given n=4 center [2,0,3,-4] d=22
suitable locations [-1,0,1,2,3]
output = 5


Given n=3 center [-3,2,2] d=8
suitable locations []
output = 0

 */
public class WarehouseLocations {
    public static int countSuitableLocations(int n, int[] centers, int d) {
        Arrays.sort(centers); // Sort the array of delivery centers

        int count = 0;
        for (int x = -3; x <= 2; x++) { // Iterate through all possible points on the number line
            long totalDistance = 0; // Initialize the total distance to 0

            // Calculate the total distance required to bring all products to the current point
            for (int center : centers) {
                totalDistance += Math.abs(x - center);
            }

            // If the total distance is less than or equal to d, increment the count
            if (totalDistance <= d) {
                count++;
            }
        }

        return count;
    }


    public static int findSuitableLocations(int[] centers, int maxDistance) {
        // Initialize the min and max x values that can satisfy the conditions
        long minX = Long.MIN_VALUE;
        long maxX = Long.MAX_VALUE;
        int count = 0;
        // Iterate through each delivery center
        for (int center : centers) {
            // Calculate the range for the current center
            long rangeMin = center - maxDistance;
            long rangeMax = center + maxDistance;

            // Update the overall range
            minX = Math.max(minX, rangeMin);
            maxX = Math.min(maxX, rangeMax);
         //   System.out.println("min"+minX);
          //  System.out.println("max"+maxX);
            if(minX <= maxX){
                if(minX<=maxDistance)
                   count++;
            }else{
                if(maxX<=maxDistance){
                    count++;
                }
            }

        }

        // Calculate the number of suitable locations based on the final range
       /* if (minX <= maxX) {
            // If there is a valid range, return the range as the final range of suitable locations

            return (int)(maxX - minX + 1);
        } else {
            // If there is no valid range, return 0
            return 0;
        }*/
        return count;
    }

    public static int productsWithinDistance(int n, int[] center, int distance) {
        int count = 0;

        // Iterate through each product's distance from the central point
        for (int i = 0; i < n; i++) {
            // Calculate the absolute distance from the central point
            int absDistance = Math.abs(center[i]);

            // Check if the absolute distance is within the allowed distance
            if (absDistance <= distance) {
                // Increment the count of products that can be brought to the central point
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Test cases
        int[] centers1 = {-2, 1, 0};
       // System.out.println("Output for Example 1: " + countSuitableLocations(3, centers1, 8)); // Output: 3

        int[] centers2 = {2, 0, 3, -4};
       // System.out.println("Output for Example 2: " + countSuitableLocations(4, centers2, 22)); // Output: 5

        int[] centers3 = {-3, 2, 2};
       // System.out.println("Output for Example 3: " + countSuitableLocations(3, centers3, 8)); // Output: 0


      //  System.out.println("output-1:"+findSuitableLocations(centers1,8));
     //   System.out.println("output-1:"+findSuitableLocations(centers2,22));
        System.out.println("output-1:"+productsWithinDistance(centers2.length,centers2,22));



    }
}
