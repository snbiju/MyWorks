package com.app.test.GS;
/*
To find the Excel column name from a given column number in Java
Time Complexity:

The while loop runs until columnNumber becomes zero, and in each iteration, it divides columnNumber by 26.
Therefore, the time complexity is O(log(columnNumber)) because the loop runs for the number of
times it takes to reduce columnNumber to zero.
Space Complexity:

The space complexity is O(log(columnNumber)) because the StringBuilder result grows in size with each iteration of the loop.
In summary, both the time and space complexity of the convertToTitle method are O(log(columnNumber)).
 */
public class ExcelColumnName {
    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            char ch = (char) (columnNumber % 26 + 'A');
            columnNumber /= 26;
            result.insert(0, ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int columnNumber =29; // Change this to the desired column number
        String columnName = convertToTitle(columnNumber);
        System.out.println("Excel column name for column number " + columnNumber + ": " + columnName);
    }
}

