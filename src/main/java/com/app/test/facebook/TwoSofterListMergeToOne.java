package com.app.test.facebook;


import org.apache.logging.log4j.util.IndexedReadOnlyStringMap;

import java.util.ArrayList;
import java.util.List;

/*

Given two sorted lists, write a function to merge them into one sorted list.

Bonus: What’s the time complexity?

Example:

Input:

list1 = [1,2,5]
list2 = [2,4,6]
Output:

def merge_list(list1,list2) -> [1,2,2,4,5,6]
 */
public class TwoSofterListMergeToOne {

    static List<Integer> getSortedList(List<Integer> listOne, List<Integer> listTwo){
        List<Integer> mergedList = new ArrayList<>();

        int i = 0, j = 0;

        // Merge the two lists while both have elements
        while (i < listOne.size() && j < listTwo.size()) {
            if (listOne.get(i) < listTwo.get(j)) {
                mergedList.add(listOne.get(i));
                i++;
            } else {
                mergedList.add(listTwo.get(j));
                j++;
            }
        }
        // Add the remaining elements from list1 (if any)
        while (i < listOne.size()) {
            mergedList.add(listOne.get(i));
            i++;
        }

        // Add the remaining elements from list2 (if any)
        while (j < listTwo.size()) {
            mergedList.add(listTwo.get(j));
            j++;
        }

        return mergedList;
    }
    public static void main(String[] args) {
        List<Integer> listOne = new ArrayList<>();
        List<Integer> listTwo = new ArrayList<>();
        listOne.add(1);
        listOne.add(2);
        listOne.add(5);
        listTwo.add(2);
        listTwo.add(4);
        listTwo.add(6);
        listTwo.add(7);
        System.out.println(getSortedList(listOne,listTwo));
    }
}
