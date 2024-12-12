package com.app.test.arm;


import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*/
Given an array filled with random values, write a function rotate_matrix to rotate the array by 90 degrees in the clockwise direction.

array ( [[1, 2, 3, 4, 5], [2, 3, 4, 5, 6], [3, 4, 5, 6, 7], [4, 5, 6, 7, 8], [5, 6, 7, 8, 9]] )
 */
public class MatrixRotation {
   public static List<List<Integer>> matrixRotation(List<List<Integer>> arrays) {

    //  return arrays.stream().map(x->x.stream().sorted(Collections.reverseOrder()).toList()).collect(Collectors.toList());
       List<List<Integer>> result = new ArrayList<>();
       for (List<Integer>  list: arrays
            ) {
           List<Integer> childList = new ArrayList<>();

         for (int i=list.size()-1;i>=0;i--
                ) {
               childList.add(list.get(i));
           }
           result.add(childList);
       }

      return result;

   }

   public static List<List<Integer>> rotation2DList(List<List<Integer>> arrays){

       List<List<Integer>> result = new ArrayList<>();
       for (List<Integer> list : arrays) {
           List<Integer> reversedList = new ArrayList<>(list);
           Collections.reverse(reversedList);
           result.add(reversedList);
       }

       return result;
   }

    public static void main(String[] args) {
        List<List<Integer>>  arrays = List.of (List.of(1, 2, 3, 4, 5),List.of(2, 3, 4, 5, 6),List.of(3, 4, 5, 6, 7),List.of(4, 5, 6, 7, 8),List.of(5, 6, 7, 8, 9));
        for (List list: arrays
             ) {
            System.out.println(list);
        }

        System.out.println("-------------");

        List<List<Integer>>  result = matrixRotation(arrays);
        for (List list: result
        ) {
            System.out.println(list);
        }
    }
}
