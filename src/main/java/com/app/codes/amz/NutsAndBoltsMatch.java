package com.app.codes.amz;

import java.util.Arrays;
import java.util.HashMap;
/*

Given a set of N nuts of different sizes and N bolts of different sizes. There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently.

Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.
The elements should follow the following order ! # $ % & * @ ^ ~ .

Example 1:

Input:
N = 5
nuts[] = {@, %, $, #, ^}
bolts[] = {%, @, #, $ ^}
Output:
# $ % @ ^
# $ % @ ^
Example 2:

Input:
N = 9
nuts[] = {^, &, %, @, #, *, $, ~, !}
bolts[] = {~, #, @, %, &, *, $ ,^, !}
Output:
! # $ % & * @ ^ ~
! # $ % & * @ ^ ~
Your Task:
You don't need to read input or print anything. Your task is to complete the function matchPairs() which takes an array of characters nuts[], bolts[] and n as parameters and returns void. You need to change the array itself.

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 9
Array of Nuts/Bolts can only consist of the following elements:{'@', '#', '$', '%', '^', '&', '~', '*', '!'}.


 */
public class NutsAndBoltsMatch {

    public static void matchPairs(char[] nuts, char[] bolts, int n) {
        // Sort both nuts and bolts arrays
        Arrays.sort(nuts);
        Arrays.sort(bolts);


        // Create a mapping from bolts to their indices
        HashMap<Character, Integer> boltIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            boltIndices.put(bolts[i], i);
        }

        // Match each nut with its corresponding bolt
        for (int i = 0; i < n; i++) {
            // Find the index of the nut in the bolts array using the mapping
            int boltIndex = boltIndices.get(nuts[i]);
            // Swap the nut and its matching bolt
            char temp = bolts[i];
            bolts[i] = bolts[boltIndex];
            bolts[boltIndex] = temp;
        }
    }

    public static void main(String[] args) {
        // Example 1
        char[] nuts1 = {'@', '%', '$', '#', '^'};
        char[] bolts1 = {'%', '@', '#', '$', '^'};
        int n1 = 5;
        matchPairs(nuts1, bolts1, n1);
        System.out.println("Output for Example 1:");
        System.out.println("Nuts: " + Arrays.toString(nuts1));
        System.out.println("Bolts: " + Arrays.toString(bolts1));

        // Example 2
        char[] nuts2 = {'^', '&', '%', '@', '#', '*', '$', '~', '!'};
        char[] bolts2 = {'~', '#', '@', '%', '&', '*', '$', '^', '!'};
        int n2 = 9;
        matchPairs(nuts2, bolts2, n2);
        System.out.println("\nOutput for Example 2:");
        System.out.println("Nuts: " + Arrays.toString(nuts2));
        System.out.println("Bolts: " + Arrays.toString(bolts2));
    }

/*    void matchPairs(char nuts[], char bolts[], int n) {
        // code here
        List<Character> elements = List.of('!','#','$','%','&','@','^','~');
        char nutsSort [] = new char [n-1];
        char boltSort[] = new char[n-1];
        int i =0;
        List<String> nutsList= Stream.of( nuts).map( String::valueOf ).collect( Collectors.toList() );
        for(Character c: elements){
            if(nutsList.contains(c.toString())){

                nutsSort[i]=c;
                i++;
            }
        }

    }*/
}
