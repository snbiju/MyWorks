package com.app.codes.JP;
/*

Here is about to introduce a new kind of number system. Where instead of 10 digits there is 20, from a to t, all in small. Now a means 1, b means 2 and t means 20, thenn aa means 21. Now for  a new number you have to print the decimal form it.

Note that the letters in the input string will be lower case and from a to t.

Input Format:

Single line containing the string of new number system’s number

Output Format:

Single line denoting the integer with the same decimal value as the input string

Sample input 1: e

Sample Output: 5

Sample  Input 2: ac

Sample Output: 23

 */
public class NewNumberSystem {
    public static void main(String[] args) {
        String input = "ab"; // Sample input string

        int decimalValue = convertToDecimal(input);

        System.out.println(decimalValue);
        System.out.println(func(input,input.length()-1,0));
    }

    public static int convertToDecimal(String input) {
        int decimalValue = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch < 'a' || ch > 't') {
                throw new IllegalArgumentException("Invalid character: " + ch);
            }
            int charValue = ch - 'a' + 1; // Calculate decimal value of the character

            decimalValue = decimalValue * 20 + charValue; // Update the total decimal value
        }
        return decimalValue;
    }
    public static int func(String s, int n, int i) {
        if (n < 0)
            return 0;
        return (s.charAt(n) - 'a' + 1) * (int) Math.pow(20, i) + func(s, n - 1, i + 1);
    }
}