package com.app.test.GS;


/*

To find the total number of triangles in a hexagon where edges connect each vertex to another, you can use the following formula:

Total triangles
=(3)
Total triangles=( 3/n)

In this case,
n is the number of vertices in the hexagon, and (3)(3n) represents the combination formula "n choose 3," which calculates the number of ways to choose 3 vertices out of

n.

For a hexagon, there are 6 vertices, so the formula becomes:

Total triangles
=(6
3)
Total triangles=(
3
6
 )

Let's calculate this:

(6
3)=6! 3!⋅(6

3!⋅(6−3)!
6!

 =
3⋅2⋅1
6⋅5⋅4
 =20

So, the total number of triangles in a hexagon with edges connecting each vertex to another is 20.


The provided function countTrianglesInHexagon has a constant time complexity of O(1) because
it performs a fixed number of arithmetic operations, regardless of the input size.

As for space complexity, the function uses a constant amount of space to store the integer variable n,
so its space complexity is also O(1).
 */
public class HexagonTriangles {

    // Function to calculate the total number of triangles in a hexagon
    public static int countTrianglesInHexagon() {
        // Number of vertices in a hexagon
        int n = 6;

        // Using combination formula C(n, 3) to find the total triangles
        return n * (n - 1) * (n - 2) / (3 * 2);
    }

    // Main method to test the function
    public static void main(String[] args) {
        int totalTriangles = countTrianglesInHexagon();
        System.out.println("Total number of triangles in the hexagon: " + totalTriangles);
    }
}

