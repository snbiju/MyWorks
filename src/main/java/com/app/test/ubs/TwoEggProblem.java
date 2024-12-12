package com.app.test.ubs;

/*

This classic problem is known as the "Two Egg Problem" or "Egg Drop Problem." The goal is to find the optimal strategy
 to minimize the number of drops required to determine the critical floor from which an egg will break.

One strategy to minimize the number of drops involves using a binary search approach.
Here's a high-level explanation:

Divide the building into floors such that the interval between consecutive floors is the same as the number of drops available
(initially 2).
Drop the first egg from the midpoint of the current interval.
If the egg breaks, the critical floor is below the midpoint, and you can use the second egg to search within the lower half.
If the egg doesn't break, the critical floor is above or equal to the midpoint, and you can use the second egg to
search within the upper half.
Repeat the process with the remaining eggs until you find the critical floor.
The worst-case scenario for this strategy is that the critical floor is the highest possible floor (100 in this case).
In that case, the number of drops required is a bit more than 14.
You start with a drop from the midpoint (50), then move to 75 or 25, then 87 or 62 or 37 or 12, and so on.


 */

public class TwoEggProblem {

    public static void main(String[] args) {
        int buildingHeight = 10;
        int drops = minDrops(buildingHeight);
        System.out.println("The minimum number of drops needed: " + drops);
    }

    public static int minDrops(int height) {
        int drops = 0;
        int floors = 1;

        while (floors < height) {
            drops++;
            floors += drops;
        }

        return drops;
    }
}

