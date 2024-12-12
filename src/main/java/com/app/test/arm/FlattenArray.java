package com.app.test.arm;

import java.util.ArrayList;
import java.util.List;

/*
ou are given an N-dimensional array (a nested list) and your task is to convert it into a 1D array.
The N-dimensional array can have any number of nested lists and each nested list can contain any number of elements.
The elements in the nested lists are integers. Write a function that takes an N-dimensional array as input and returns a 1D array.
Input:

array = [1, [2, 3], [4, [5, 6]], 7]
Output:

flatten_array(array) -> [1, 2, 3, 4, 5, 6, 7]

Input:

array = [[1, 2], [3, 4], [5, 6]]
Output:

flatten_array(array) -> [1, 2, 3, 4, 5, 6]
 */
public class FlattenArray {

    public static List<Integer> flattenArray(List<?> array) {
        List<Integer> result = new ArrayList<>();
        flatten(array, result);
        return result;
    }

    private static void flatten(List<?> array, List<Integer> result) {
        for (Object element : array) {
            if (element instanceof List) {
                flatten((List<?>) element, result);
            } else if (element instanceof Integer) {
                result.add((Integer) element);
            }
        }
    }

    public static void main(String[] args) {
        List<Object> array = new ArrayList<>();
        array.add(1);
        array.add(List.of(2, 3));
        array.add(List.of(4, List.of(5, 6)));
        array.add(7);

        List<Integer> flattened = flattenArray(array);
        System.out.println(flattened); // Output: [1, 2, 3, 4, 5, 6, 7]

       // Object [][] arrays = {1, {2, 3}, {4, {5, 6}}, 7};
    }
}
