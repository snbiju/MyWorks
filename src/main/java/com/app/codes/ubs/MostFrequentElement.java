package com.app.codes.ubs;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentElement {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 4, 2, 5, 3, 2}; // Example array

        int mostFrequentElement = findMostFrequentElement(array);

        System.out.println("The most frequently occurring element is: " + mostFrequentElement);
    }

    public static int findMostFrequentElement(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be empty or null.");
        }

        // Use a map to count the occurrences of each element
        Map<Integer, Integer> elementCountMap = new HashMap<>();

        for (int num : array) {
            elementCountMap.put(num, elementCountMap.getOrDefault(num, 0) + 1);
        }

        // Find the element with the maximum count
        int mostFrequentElement = array[0];
        int maxCount = elementCountMap.get(array[0]);

        for (int num : array) {
            int count = elementCountMap.get(num);
            if (count > maxCount) {
                mostFrequentElement = num;
                maxCount = count;
            }
        }

        return mostFrequentElement;
    }
}
