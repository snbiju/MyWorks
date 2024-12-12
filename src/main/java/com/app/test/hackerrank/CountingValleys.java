package com.app.test.hackerrank;


/*
Gary is an avid hiker. He starts and ends his hike at sea level.
A valley is a sequence of consecutive steps below sea level. Given Gary's sequence of steps, find and print the number
of valleys he walked through.
Counting Valleys
 */
public class CountingValleys {

    public static int countingValleys(int steps, String path) {
        int level = 0; // Sea level
        int valleyCount = 0;

        for (char step : path.toCharArray()) {
            if (step == 'U') {
                level++;
            } else if (step == 'D') {
                level--;
            }

            // Check if Gary enters a valley
            if (step == 'U' && level == 0) {
                valleyCount++;
            }
        }

        return valleyCount;
    }

    public static void main(String[] args) {
        int steps = 12;
        String path = "DDUUDDUDUUUD";

        int result = countingValleys(steps, path);
        System.out.println(result);
    }
}
