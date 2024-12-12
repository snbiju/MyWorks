package com.app.test.ubs;

import java.util.ArrayList;
import java.util.List;

public class KeyboadMapping {
    public String[] solution(int[] A) {
        if (A == null || A.length != 2) {
            return new String[0]; // Invalid input, return an empty array.
        }

        // Define the mapping of digits to letters on the keyboard.
        String[] keyboardMapping = {
                "None",
                "None",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        String digit1Letters = keyboardMapping[A[0]];
        String digit2Letters = keyboardMapping[A[1]];

        if (digit1Letters.equals("None") || digit2Letters.equals("None")) {
            return new String[0]; // One of the digits is '0' (None), return an empty array.
        }

        // Create a list to store the combinations of letters.
        List<String> combinations = new ArrayList<>();

        for (int i = 0; i < digit1Letters.length(); i++) {
            for (int j = 0; j < digit2Letters.length(); j++) {
                combinations.add("" + digit1Letters.charAt(i) + digit2Letters.charAt(j));
            }
        }

        // Convert the list to an array.
        return combinations.toArray(new String[0]);
    }

    public static void main(String[] args) {
        KeyboadMapping solution = new KeyboadMapping();

        int[] input1 = {0, 2};
        String[] output1 = solution.solution(input1);
        for (String combination : output1) {
            System.out.print(combination + " ");
        }
        System.out.println();

        int[] input2 = {3, 4};
        String[] output2 = solution.solution(input2);
        for (String combination : output2) {
            System.out.print(combination + " ");
        }
       // System.out.println();
    }
}
