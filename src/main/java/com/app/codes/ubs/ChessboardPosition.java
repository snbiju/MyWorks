package com.app.codes.ubs;

import java.util.Scanner;
/*

The chessboard below has 64 squares, 8 rows and 8 columns . Each row is labelled from 1 to 8 and each column is labelled from a to h  .
A Square is located at the intersection if a row and of a column
 like square 2C it's the intersection of the row 2 and column C
input
string start position
number rows
number columns

output
String endposition

Example1
startpostion 2b, rows 3, columns 2
output 5d
startpostion 5h, rows 11, columns 25
output 8a

startpostion 4f, rows 88, columns 88
output 4f

startpostion 1a, rows 10, columns 10
output 3c
 */
public class ChessboardPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input start position, number of rows, and number of columns
        // System.out.print("Enter the start position (e.g., 2b): ");
        String startPosition = "2b";
        //System.out.print("Enter the number of rows: ");
        int numRows = 3;
        //   System.out.print("Enter the number of columns: ");
        int numColumns = 2;

        // Calculate the end position
        String endPosition = calculateEndPosition(startPosition, numRows, numColumns);

        System.out.println(calculateEndPosition("5h", 11, 25));
        System.out.println(calculateEndPosition("1a", 10, 10));
        System.out.println(calculateEndPosition("4f", 88, 88));

        // Output the end position
        System.out.println("End position: " + endPosition);
    }

    // Function to calculate the end position
/*    public static String calculateEndPosition(String startPosition, int numRows, int numColumns) {
        // Extract the row and column from the starting position
        int startRow = Character.getNumericValue(startPosition.charAt(0));
        char startColumn = startPosition.charAt(1);

        // Calculate the new row and column
        int endRow = startRow + numRows;
        char endColumn = (char) (startColumn + numColumns);

        // Ensure the row and column do not exceed the chessboard boundaries
        endRow = Math.min(endRow, 8);
        endColumn = (char) Math.min(endColumn, 'h');

        // Construct the end position string
        String endPosition = String.valueOf(endRow) + endColumn;

        return endPosition;
    }*/

   /* public static String calculateEndPosition(String startPosition, int numRows, int numColumns) {
        // Extract the row and column from the starting position
        int startRow = Integer.parseInt(startPosition.substring(0, startPosition.length() - 1));
        char startColumn = startPosition.charAt(startPosition.length() - 1);

        // Calculate the new row and column
        int endRow = startRow + numRows;
        int endColumn = startColumn + numColumns;

        // Handle column overflow
        while (endColumn > 'h') {
            endColumn -= 8;
            endRow++;
        }

        // Ensure the row does not exceed the chessboard boundaries
        endRow = Math.min(endRow, 8);

        // Construct the end position string
        String endPosition = String.valueOf(endRow) + (char) endColumn;

        return endPosition;
    }*/

    /* public static String calculateEndPosition(String startPosition, int numRows, int numColumns) {
         // Extract the row and column from the starting position
         int startRow = Integer.parseInt(startPosition.substring(0, startPosition.length() - 1));
         char startColumn = startPosition.charAt(startPosition.length() - 1);

         // Calculate the new row and column
         int endRow = startRow + numRows;
         int endColumn = startColumn + numColumns;

         // Handle column overflow
         while (endColumn > 'h') {
             endColumn -= 8;
             endRow++;
         }

         // Ensure the row and column do not exceed the chessboard boundaries
         endRow = Math.min(endRow, 8);
         endColumn = Math.min(endColumn, 'h');

         // Construct the end position string
         String endPosition = String.valueOf(endRow) + (char) endColumn;

         return endPosition;
     }*/
    public static String calculateEndPosition1(String startPosition, int numRows, int numColumns) {
        // Extract the row and column from the starting position
        int startRow = Integer.parseInt(startPosition.substring(0, 1));
        char startColumn = startPosition.charAt(1);

        // Calculate the new row and column
        int endRow = startRow + numRows;
        char endColumn = (char) (startColumn + numColumns);

        // Ensure the row and column do not exceed the chessboard boundaries
        endRow = Math.min(endRow, 8);
        endColumn = (char) Math.min(endColumn, 'h');

        // Construct the end position string
        String endPosition = String.valueOf(endRow) + endColumn;

        return endPosition;
    }

    private static String calculateEndPosition(String startPosition, int numRows, int numCols) {
        // Convert the start position to numerical values
        int startRow = Integer.parseInt(startPosition.substring(0, 1));
        int startCol = startPosition.charAt(1) - 'a' + 1;

        // Calculate the end position
        int endRow = (startRow + numRows - 1) % 8 + 1;
        int endCol = (startCol + numCols - 1) % 8 + 1;

        // Convert numerical values to chessboard notation
        String endPosition = String.valueOf(endRow) + (char) ('a' + endCol - 1);

        return endPosition;
    }



}


