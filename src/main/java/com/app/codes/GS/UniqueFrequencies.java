package com.app.codes.GS;
/*
Unique Frequencies

You are given an array A of N integers. The task is to determine if the value of frequency of each element in the array is unique.

Input Format
The first line of input contains a single integer T. denoting the number of test cases.
Each test case follows:
The first line of each test cases contains a single integer N
The second line contains N space-separated integers.

Output Format
Print Yes if all elements have unique frequency Else print No

Display out put for ach test cases in a new line

Constraints
1<= T <=100
1<=N<=2*10^4
1<=Ai<=10^4

Time limit
1 second

Example

input

5,6,7,7,6,6

1,2,3,4,2

output
Yes
No


Time Complexity:
Iterating over the array and updating the frequency map:
O(N), where N is the length of the array.
Constructing the frequency set using values from the map:
O(M), where M is the number of unique frequencies.
The dominant factor is the iteration over the array, so the overall time complexity is O(N).

Space Complexity:
frequencyMap: The space required for storing the frequency of each element. In the worst case, all elements are unique,
so the size of the map is O(N).
frequencySet: The space required for storing unique frequencies. In the worst case, all frequencies are unique,
so the size of the set is O(N).
The dominant factor is the space used by the frequencyMap, so the overall space complexity is
O(N).

Summary:
Time Complexity: O(N)
Space Complexity: O(N)
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueFrequencies {

    public static String findUniqueFrequencies(int [] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        String result = "Y";

        for(int element: array){
            frequencyMap.put(element,frequencyMap.getOrDefault(element,0)+1);
        }

      /*  for (int i = 0; i < array.length; i++) {
            if (frequencyMap.containsKey(array[i])) {
                frequencyMap.put(array[i], frequencyMap.getOrDefault(array[i], 0) + 1);
            }else{
                frequencyMap.put(array[i], 1);
            }
        }*/
        Set<Integer> verifySet = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (verifySet.contains(entry.getValue())) {
                result = "N";
            }else{
                verifySet.add(entry.getValue());
            }
        }
    return result;
    }
    public static void findFrequency(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int element : arr) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        // Print frequency of each element
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Element: " + entry.getKey() + ", Frequency: " + entry.getValue());
        }
    }

    /*

Let's analyze the time and space complexity of the provided code:

Time Complexity:

The loop that iterates through the array has a time complexity of O(N),
where N is the number of elements in the array.
Inside the loop, frequencyMap.put and frequencyMap.getOrDefault operations have
an average time complexity of O(1) for each element.
Creating the HashSet (new HashSet<>(frequencyMap.values())) also has a time complexity of O(N),
where N is the number of unique frequencies.
The overall time complexity is O(N).

Space Complexity:

The frequencyMap is used to store the frequency of each element, and in the worst case,
it can have at most N entries (when all elements are unique).
Therefore, the space complexity of the frequencyMap is O(N).
The frequencySet is used to store the unique frequencies, and in the worst case,
it can have at most N entries (when all frequencies are unique). Therefore, the space complexity
of the frequencySet is O(N).
The overall space complexity is O(N).

In summary, the time complexity is O(N), and the space complexity is O(N).
     */

    private static String checkUniqueFrequencies(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> frequencySet = new HashSet<>(frequencyMap.values());

        return frequencySet.size() == frequencyMap.size() ? "Yes" : "No";
    }

    public static void main(String[] args) {
        int [] array = {5,6,7,7,6,6};
        int[] array1= {1,2,3,4,2};
        System.out.println(checkUniqueFrequencies(array));//Y
        System.out.println(checkUniqueFrequencies(array1));//N

    }
}
