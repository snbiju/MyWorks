package com.app.codes.JP;
/*
Replace the last word of a string with number
 */
public class ReplaceLastWordWithNumber {

    public static String replaceLastWordWithNumber(String inputString, int number) {
        // Remove trailing spaces
        inputString = inputString.trim();

        // Find the last space character
        int lastSpaceIndex = inputString.lastIndexOf(' ');

        // If there are no spaces, replace the entire string with the number
        if (lastSpaceIndex == -1) {
            return String.valueOf(number);
        }

        // Extract the substring before the last space
        String substringBeforeLastSpace = inputString.substring(0, lastSpaceIndex);

        // Return the substring before the last space with the number appended
        return substringBeforeLastSpace + " " + number;
    }

    public static void main(String[] args) {
        String inputString = "Hello world Java is awesome";
        int number = 123;

        String modifiedString = replaceLastWordWithNumber(inputString, number);
        System.out.println(modifiedString);  // Output: Hello world Java is 123
    }

}
