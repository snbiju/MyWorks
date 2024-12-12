package com.app.codes.GS;
/*

Given a 2-D String array of student-marks find the student with the highest average and output his average score. If the average is in decimals, floor it down to the nearest integer.

Example 1:

Input:  [{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}]
Output: 99
Explanation: Since Jessica's average is greater than Bob's, Mike's and Jason's average.
Follow-up:
Questions: What is the time complexity? What is the space complexity? Can you solve it in O(n) time? (I used an integer array to store the average and sorted it using Arrays.sort(). But then, I refined my code to store only the maximum average, when I calculated the average).

The interviewer was insistent on me testing for more cases. She also helped me point out where my code was going wrong (I was trying to add integers but my code was concatenating and then converting to Integer) and I quickly fixed it.

Time Complexity
Populating the Map:

Iterating through the input array to populate the map takes O(n) time, where n is the number of records in the input array.
Calculating Averages:

For each student, calculating the average involves summing their scores and dividing by the count of scores.
Let's assume there are k unique students. If each student has an average of m scores, iterating through the list of scores for each student takes O(m).
Since we need to perform this for k students, the total time for this step is O(k * m).
Since each score is processed exactly once and assuming m is a constant factor relative to n, the overall time complexity is O(n).

Space Complexity
Storing Scores in the Map:

We use a HashMap to store the scores for each student.
The space required for the map is proportional to the number of records in the input array. Each record (student name and their scores) is stored in a list.
In the worst case, if all students are unique, the space required is O(n).
Auxiliary Space:

The additional space used for variables such as topStudent and highestAverage is constant, i.e., O(1).
Thus, the overall space complexity is O(n), where n is the number of input records.

Summary
Time Complexity: O(n)
Space Complexity: O(n)


 */
import java.util.*;

public class HighestAverageScore {

    public static int highestAverage(String[][] scores) {
        if (scores == null || scores.length == 0) {
            return -1;
        }

        // Map to store total scores and count of scores for each student
        Map<String, List<Integer>> studentScores = new HashMap<>();

        // Populate the map with scores
        for (String[] record : scores) {
            String name = record[0];
            int score = Integer.parseInt(record[1]);
            studentScores.putIfAbsent(name, new ArrayList<>());
            studentScores.get(name).add(score);
        }

        String topStudent = null;
        double highestAverage = 0.0;

        // Calculate the average score for each student
        for (Map.Entry<String, List<Integer>> entry : studentScores.entrySet()) {
            String student = entry.getKey();
            List<Integer> scoresList = entry.getValue();
            double average = scoresList.stream().mapToInt(Integer::intValue).average().orElse(0.0);

            if (average > highestAverage) {
                highestAverage = average;
                topStudent = student;
            }
        }

        // Output the highest average score
        return (int) highestAverage;

    }
    public static void main(String[] args) {
        // Input
        String[][] input = {{"Bob", "87"}, {"Mike", "35"}, {"Bob", "52"}, {"Jason", "35"}, {"Mike", "55"}, {"Jessica", "99"}};
        String [][] input2= {{"Ram","100"},{ "Shyam", "90"},{"Ram","70"}};
        System.out.println(highestAverage(input));
        System.out.println(highestAverage(input2));

    }
}