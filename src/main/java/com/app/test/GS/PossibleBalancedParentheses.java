package com.app.test.GS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
All Possible Balanced Parentheses
You are given positive Integer N which denotes the number of pairs of parentheses ("()" is a pair).

The task is to determine all combination of well-formed  balanced parentheses.

For example (())() is a balanced parenthesis. But (() is not.
out put format
Print each well-formed balanced parenthesis in a new line. Follow lexicographical order while printing  the different possibilities.

Constraints
1<=N<=8

Time limit
1 second


Input
3

output
((()))
(()())
(())()
()()()

input
4
(((())))
((()()))
((())())
((()))()
(()(()))
(()()())
(()())()
(())(())
(())()()
()((()))
()(()())
()(())()
()()(())
()()()()


Time Complexity:
The time complexity of the given code can be analyzed based on the number of recursive calls made during the generation of parentheses.

Let N be the input parameter n.

The recursion tree has a branching factor of 2 (two recursive calls: one for opening parentheses and one for closing parentheses).
The maximum depth of the recursion tree is
2N (as each pair of parentheses contributes two levels).
Therefore, the total number of recursive calls is
O(2^2N), resulting in an exponential time complexity.

Space Complexity:
The space complexity is determined by the maximum depth of the recursion, which is 2N.
At any point in the recursion, the maximum number of function calls waiting to be resolved is
2N. Therefore, the space complexity is
O(2N), which simplifies to O(N).

Summary:
Time Complexity:
O(2^2N)
Space Complexity: O(N)
The code has an exponential time complexity due to the nature of generating all possible combinations of parentheses.
The space complexity is linear in terms of the maximum depth of the recursion.

 */
public class PossibleBalancedParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
      //  generateBalancedParentheses(N);
        generateParentheses1(N);
    }

    public static void generateBalancedParentheses(int N) {
        char[] parentheses = new char[2 * N];
        generateHelper(parentheses, 0, N, N, 0);
    }

    public static void generateHelper(char[] parentheses, int index, int openRemaining, int closeRemaining, int count) {
        if (index == parentheses.length) {
            System.out.println(new String(parentheses));
            return;
        }

        if (openRemaining > 0) {
            parentheses[index] = '(';
            generateHelper(parentheses, index + 1, openRemaining - 1, closeRemaining, count + 1);
        }

        if (closeRemaining > 0 && count > 0) {
            parentheses[index] = ')';
            generateHelper(parentheses, index + 1, openRemaining, closeRemaining - 1, count - 1);
        }
    }

    public static void generateParentheses(int n) {
        List<String> result = new ArrayList<>();

        generate("", n, n, result);

        for (String parenthesis : result) {
            System.out.println(parenthesis);
        }
    }

    private static void generate(String current, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }

        if (left > 0) {
            generate(current + "(", left - 1, right, result);
        }

        if (right > left) {
            generate(current + ")", left, right - 1, result);
        }
    }


    public static void generateParentheses1(int n) {
        generate("", n, n);
    }

    private static void generate(String current, int left, int right) {
        if (left == 0 && right == 0) {
            System.out.println(current);
            return;
        }

        if (left > 0) {
            generate(current + "(", left - 1, right);
        }

        if (right > left) {
            generate(current + ")", left, right - 1);
        }
    }



}
