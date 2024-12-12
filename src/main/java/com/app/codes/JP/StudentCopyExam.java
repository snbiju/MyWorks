package com.app.codes.JP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*

Ashish was copying from Rahit in the exam. So, Rahit told him to change the answers a
little bit so that the examiner cannot find the fraud.
But silly Ashish in the way started to change all the answers that were needed.
He shuffled the letters in each word in a way where the maximum number of letters were misplaced.

For a given word, find the maximum difference that Ashish can generate between his answer and Rahit’s answer.

Suppose Rahit wrote “car” for an answer, Ashish can write “acr” with difference 2, or “arc” with differnece 3.

Note That: The letters are all in lowercase.

Input Format:

First line containing an integer n, number of words.

Then, n numbers of lines as the query words.

Output:

N number of lines with an integer each denoting possible maximum difference.

Sample Input:

4

abababa

bbj

kj

kk

Sample Output:

6

2

2

0
 */
public class StudentCopyExam {

   /* public static void main(String[] args) {

      List<String> words= List.of("abababa", "bbj", "kj", "kk");
      System.out.println(getMaxDiff(words));

    }

    public static String swapString(String s, int i, int j) {
        char[] b = s.toCharArray();
        char temp;
        temp = b[i];
        b[i] = b[j];
        b[j] = temp;
        return String.valueOf(b);
    }

    public static void generatePermutation(String s, int start, int end, HashSet< String > set) {

        if (start == end - 1)
            set.add(s + " ");
        else {
            for (int i = start; i < end; i++) {
                s = swapString(s, start, i);
                generatePermutation(s, start + 1, end, set);
                s = swapString(s, start, i);
            }
        }

    }
    public static int maxDiff(String str, String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == str.charAt(i));
            else
                c++;
        }
        return c;

    }
    public static List<Integer> getMaxDiff(List<String> words){

        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            HashSet < String > set = new HashSet < String > ();
            String s = words.get(i);
            generatePermutation(s, 0, s.length(), set);
            int max = 0;
            int k = 0;
            for (String str: set) {

                k = maxDiff(str, s);
                max = Math.max(max, k);

            }
            output.add(max);
        }
        return output;
    }
*/

    public static void main(String[] args) {
        List<String> words = List.of("abababa", "bbj", "kj", "kk");
        List<Integer> result = getMaxGeneratedDifference(words);
        System.out.println("Expected output: [6, 2, 2, 0]");
        System.out.println("Actual output: " + result);
    }

    public static List<Integer> getMaxGeneratedDifference(List<String> words) {
        List<Integer> output = new ArrayList<>();
        for (String word : words) {
            HashSet<String> permutations = generatePermutations(word);
            int maxDiff = 0;
            for (String permutation : permutations) {
                int diff = maxDiff(word, permutation);
                maxDiff = Math.max(maxDiff, diff);
            }
            output.add(maxDiff);
        }
        return output;
    }

    public static HashSet<String> generatePermutations(String s) {
        HashSet<String> set = new HashSet<>();
        generatePermutation(s.toCharArray(), 0, s.length() - 1, set);
        return set;
    }

    private static void generatePermutation(char[] chars, int start, int end, HashSet<String> set) {
        if (start == end) {
            set.add(new String(chars));
        } else {
            for (int i = start; i <= end; i++) {
                swap(chars, start, i);
                generatePermutation(chars, start + 1, end, set);
                swap(chars, start, i);
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static int maxDiff(String str1, String str2) {
        int diff = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}

