package com.app.test;

/**
 * Run a loop from i = 0 till N – 1 and consider a visited array.
 * Run a nested loop from j = i + 1 to N – 1 and check whether the current character S[j] has already been visited.
 * If true, break from the loop and consider the next window.
 * Else, mark the current character as visited and maximize the length as j – i + 1.
 * Remove the first character of the previous window and continue.
 */
public class LogestUniqueSubstring {

    public static int longestUniqueSubsttr(String str)
    {
        int n = str.length();

        // Result
        int res = 0;

        for(int i = 0; i < n; i++)
        {

            // Note : Default values in visited are false
            boolean[] visited = new boolean[256];

            for(int j = i; j < n; j++)
            {

                // If current character is visited
                // Break the loop
                if (visited[str.charAt(j)])
                    break;

                    // Else update the result if
                    // this window is larger, and mark
                    // current character as visited.
                else
                {
                    res = Math.max(res, j - i + 1);
                    visited[str.charAt(j)] = true;
                }
            }

            // Remove the first character of previous
            // window
            visited[str.charAt(i)] = false;
        }
        return res;
    }

    // Driver code
    public static void main(String[] args)
    {
        String str = "geeksforgeeks";
        System.out.println("The input string is " + str);

        int len = longestUniqueSubsttr(str);
        System.out.println("The length of the longest " +
                "non-repeating character " +
                "substring is " + len);
    }
}
