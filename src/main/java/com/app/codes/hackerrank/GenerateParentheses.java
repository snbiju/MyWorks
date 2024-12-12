package com.app.codes.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, 0, 0, "", result);
        return result;
    }

    private static void generateParenthesisHelper(int n, int open, int close, String current, List<String> result) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        if (open < n) {
            generateParenthesisHelper(n, open + 1, close, current + "(", result);
        }

        if (close < open) {
            generateParenthesisHelper(n, open, close + 1, current + ")", result);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        System.out.println(result);

        result.stream().forEach(System.out::println);

        System.out.println("Generated Parentheses for n = " + n + ":");
        for (String parentheses : result) {
            System.out.println(parentheses);
        }
    }
}
