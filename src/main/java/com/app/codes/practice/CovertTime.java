package com.app.codes.practice;
/*

You are given two strings current and correct representing two 24-hour times.

24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.

In one operation you can increase the time current by 1, 5, 15, or 60 minutes. You can perform this operation any number of times.

Return the minimum number of operations needed to convert current to correct.



Example 1:

Input: current = "02:30", correct = "04:35"
Output: 3
Explanation:
We can convert current to correct in 3 operations as follows:
- Add 60 minutes to current. current becomes "03:30".
- Add 60 minutes to current. current becomes "04:30".
- Add 5 minutes to current. current becomes "04:35".
It can be proven that it is not possible to convert current to correct in fewer than 3 operations.
Example 2:

Input: current = "11:00", correct = "11:01"
Output: 1
Explanation: We only have to add one minute to current, so the minimum number of operations needed is 1.


Constraints:

current and correct are in the format "HH:MM"
current <= correct

 */
public class CovertTime {

    public static int convertTime(String current, String correct) {

        // Convert current time to minutes
        int currentMinutes = convertToMinutes(current);

        // Convert correct time to minutes
        int correctMinutes = convertToMinutes(correct);

        // Calculate the absolute difference in minutes between correct and current time
        int absoluteDifference = Math.abs(correctMinutes - currentMinutes);

        // Define the operation increments
        int[] operations = {60, 15, 5, 1};

        // Initialize the count of operations
        int count = 0;

        // Iterate through the operations and perform them greedily
        for (int operation : operations) {
            count += absoluteDifference / operation;
            absoluteDifference %= operation;
        }

        return count;

    }

    // Helper method to convert time to minutes
    private static int convertToMinutes(String time) {
        String[] timeParts = time.split(":");
        int hour = Integer.parseInt(timeParts[0]);
        int minute = Integer.parseInt(timeParts[1]);
        return hour * 60 + minute;
    }

    public static void main(String[] args) {
        String current = "00:00", correct = "23:59";
        String current1 = "02:30", correct1 = "04:35";
        System.out.println(convertTime(current,correct)); //32
        System.out.println(convertTime(current1,correct1)); //3
    }
}
