package com.app.test.amz;

import java.util.*;

/*

Problem Description

Given a string A denoting a stream of lowercase alphabets. You have to make new string B.

B is formed such that we have to find first non-repeating character each time a character is inserted to the stream and append
it at the end to B. If no non-repeating character is found then append '#' at the end of B.



Problem Constraints
1 <= length of the string <= 100000



Input Format
The only argument given is string A.



Output Format
Return a string B after processing the stream of lowercase alphabets A.



Example Input 1:

 A = "abadbc"
Input 2:

 A = "abcabc"


Example Output 1:

 "aabbdd"
Output 2:

 "aaabc#"


Example Explanation 1:

    "a"      -   first non repeating character 'a'
    "ab"     -   first non repeating character 'a'
    "aba"    -   first non repeating character 'b'
    "abad"   -   first non repeating character 'b'
    "abadb"  -   first non repeating character 'd'
    "abadbc" -   first non repeating character 'd'
Explanation 2:

    "a"      -   first non repeating character 'a'
    "ab"     -   first non repeating character 'a'
    "abc"    -   first non repeating character 'a'
    "abca"   -   first non repeating character 'b'
    "abcab"  -   first non repeating character 'c'
    "abcabc" -   no non repeating character so '#'


The time complexity of the provided code is O(N), where N is the length of the input string A.
This is because the code iterates through each character in the input string exactly once.

The space complexity is O(1), or more precisely, O(26) since the size of the array charCount is fixed at 26
(assuming only lowercase alphabets). The size of the queue is also limited to the number of distinct characters encountered,
which can be at most 26.
Therefore, the space used by the algorithm is constant with respect to the input size.
 */
public class NonRepeatingCharInStream {

    public static String solve(String A) {

        char [] charArray = A.toCharArray();
        int[] charCount = new int[26]; // Assuming lowercase alphabets only
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (char c : charArray) {
            charCount[c - 'a']++;
            queue.add(c);

            while (!queue.isEmpty() && charCount[queue.peek() - 'a'] > 1) {
                queue.poll();
            }

            if (!queue.isEmpty()) {
                result.append(queue.peek());
            } else {
                result.append('#');
            }
        }

        return result.toString();
    }

    public static String solves(String str) {
        // verify the input
        if (null == str || str.isEmpty()) {
            return str;
        }

        Set<Character> previous = new LinkedHashSet<>();
        Queue<Character> nonRepeated = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        // use the first character
        char curr = str.charAt(0);
        previous.add(curr);
        nonRepeated.add(curr);
        sb.append(curr);

        for (int i = 1, n = str.length(); i < n; i++) {
            char c = str.charAt(i);

            if (!previous.add(c)) { // duplicate character found
                nonRepeated.remove(c);
                if (nonRepeated.isEmpty()) {
                    curr = '#';
                } else { // get the next non-repeated character
                    curr = nonRepeated.peek();
                }
            } else { // unique element is detected
                if (curr == '#') {
                    curr = c;
                }
                nonRepeated.add(c);
            }

            sb.append(curr);
        }

        return sb.toString();
    }

    static String firstNonRepeating(String A)
    {
        // Arraylist to keep track of current unique characters
        // Hashmap to keep track of character encountered at least once
        ArrayList<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : A.toCharArray()) {
            if (!map.containsKey(ch)) { // any new character encountered first time
                list.add(ch);
                map.put(ch, 1);
            }
            else {
                //any repeated character encountered
                int index = list.indexOf(ch);

                // for any repeated character encountered more than twice the
                // index will be -1
                if (index != -1)
                    list.remove(index);
            }
            sb.append(list.isEmpty() ? '#' : list.get(0));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "abadbc";
        String str2= "abcabc";
        System.out.println(solves(str1));
        System.out.println(solve(str1));
        System.out.println(firstNonRepeating(str1));
        System.out.println(solve(str2));
        System.out.println(solves(str2));
        System.out.println(firstNonRepeating(str2));
    }
}
