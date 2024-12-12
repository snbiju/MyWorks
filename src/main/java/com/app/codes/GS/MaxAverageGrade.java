package com.app.codes.GS;

/*

Given a 2D String array, that contains (Student Name, Grades). There can be one more grades per student. Retrun the maximum Average Grade amoungst all students

input:
[ ["Rachel","100"], ["Phoebe","80"],
["Monica","95"],["Rachel","50"],
["Phoebe","60"]]

output:
95


The time complexity of the provided code is O(N), where N is the number of entries in the grades array.
The reason for this is that the code iterates through each entry in the array once, performing constant-time operations for each entry.

The space complexity is also O(N), where N is the number of unique students.
In the worst case, each student is represented as a unique key in the gradeSumMap and gradeCountMap HashMaps.
Therefore, the space required is proportional to the number of unique students.

Note: The space complexity analysis assumes that the number of unique students is the dominating factor for space usage.
 If the number of unique students is much smaller than the total number of entries, the space complexity could be considered O(1).
 However, in the worst case (all students are unique), it remains O(N).


Time Complexity:

Input Processing (Loop through grades):

The code iterates through each entry in the grades array.
The time complexity of this part is O(N), where N is the number of entries in the grades array.
Map Operations:

For each entry, the code performs operations on two HashMaps (gradeSumMap and gradeCountMap).
HashMap operations (put, get, getOrDefault) are generally O(1) on average.
The time complexity for this part is O(N), where N is the number of entries in the grades array.
Calculating Average (Second Loop):

The code iterates through entries in the gradeSumMap.
The time complexity of this part is O(M), where M is the number of distinct students (keys) in the grades array.
Overall Time Complexity:

Combining the time complexities of the three parts, the overall time complexity is O(N + M).
Space Complexity:

HashMaps:

Two HashMaps (gradeSumMap and gradeCountMap) are used to store the sum of grades and the count of grades for each student.
The space complexity for the HashMaps is O(M), where M is the number of distinct students (keys) in the grades array.
Variables:

Other than the HashMaps, the code uses a constant amount of space for variables like maxAverage, student, sum, count, etc.
The space complexity for variables is O(1).
Overall Space Complexity:

Combining the space complexities of HashMaps and variables, the overall space complexity is O(M).
In summary:

Time Complexity: O(N + M)
Space Complexity: O(M)

 */
import java.util.HashMap;
import java.util.Map;

public class MaxAverageGrade {

    public static int getMaxAverageGrade(String[][] grades) {
        Map<String, Integer> gradeSumMap = new HashMap<>();
        Map<String, Integer> gradeCountMap = new HashMap<>();

        for (String[] entry : grades) {
            String student = entry[0];
            int grade = Integer.parseInt(entry[1]);

            gradeSumMap.put(student, gradeSumMap.getOrDefault(student, 0) + grade);
            gradeCountMap.put(student, gradeCountMap.getOrDefault(student, 0) + 1);
        }

        double maxAverage = 0.0;

        for (Map.Entry<String, Integer> entry : gradeSumMap.entrySet()) {
            String student = entry.getKey();
            int sum = entry.getValue();
            int count = gradeCountMap.get(student);
            double average = (double) sum / count;

            maxAverage = Math.max(maxAverage, average);
        }

        return (int) maxAverage;
    }

    public static void main(String[] args) {
        String[][] grades = {
                {"Rachel", "100"}, {"Phoebe", "80"},
                {"Monica", "95"}, {"Rachel", "50"},
                {"Phoebe", "60"}
        };

        int maxAverage = getMaxAverageGrade(grades);
        System.out.println("Max Average Grade: " + maxAverage);
    }
}
