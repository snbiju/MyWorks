package com.app.test.amazon;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/*
The course has n chapters, each chapter has memory[i] memory points, which a student gains or loses while reading
that chapter.

The course has a requirement: in order to study the ith chapter, the student must revisit all the previous chapters.
 A student gains memory[0] + memory[1] + … + memory[i] memory points for reading the ith chapter.
 The total memory points is the sum of memory points gained while reading each chapter.

Students can read the chapters in any order, and want to maximize their total memory points.
Find the maximum total memory points a student can score ensuring that all the chapters are read.

Example :

Input : [3,4,5]

Output: 26
 */
public class StudentsChapter {
    public static int maxMemoryPoints(int[] memory) {
        // Step 1: Sort the chapters in descending order
        Integer[] descendingMemory = Arrays.stream(memory).boxed().toArray(Integer[]::new);

        // Step 2: Sort in descending order using Collections.reverseOrder()
        Arrays.sort(descendingMemory, Collections.reverseOrder());


        // Step 3: Calculate the cumulative sum and the total memory points
        int totalMemoryPoints = 0;
        int currentSum = 0;

        for (int i = 0; i < descendingMemory.length; i++) {
            currentSum += descendingMemory[i];  // Add the current chapter's memory
            totalMemoryPoints += currentSum;    // Add to the total memory points
        }

        return totalMemoryPoints;
    }

    public static void main(String[] args) {
        int[] memory = {3, 4, 5};
        System.out.println(maxMemoryPoints(memory));  // Output: 26
    }
}
