package com.app.test.amz;

import java.util.*;

/*

Amazon recently launched a new game , Fruit Crush! In this game, you are allowed to choose two dissimilar fruits and crush them. Each type
of fruit is represented as an integer in an array. Formally you can choose any two unequal integers in the array and delete them.


Given an array fruits of size n, return the minimum possible number of fruits left after the given operation is performed
any number of times.

Example
n=5
fruits= [3,3,1,1,2]

fruits 1(banana) and 2(pineapple) can be crushed first, followed by number s 1 (banana) and 3 (orange).
Only 3(orange) remains in the array.
hence the answer is 1

example :
n=5
fruits =[3,3,1,1,2]
output =1

Function Description

Complete the function getMinimumFruits in the editor below

test case -1
n=4
fruits =[1,2,5,6]
output =0

explanation
Fruits 1 and 2 can be taken and fruits 5 and 6 can be taken. Hence, no numbers are left.

test case -2
n=6
fruits =[2,2,2,5,1,2]
output =2

explanation
Fruits 2 and 5 can be taken and fruits 2 and 1 can be taken. Hence, 2 fruits numbers are left.

Java program
From this list fruits =[1,2,5,6]
Take distinct pair of elements, and it has to delete the chosen element from the list.
Count remaining pair
 */
public class MinimumFruitsLeft {

    /*

          In a list combine non-unique integer and return list of unused elements
          example input {3, 3, 1, 1, 2}
          process: [3,1][3,2]
          output [1]  not used
           */

    public static int countRemainingPairs(List<Integer> fruits) {
        int n = fruits.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (fruits.get(i) != fruits.get(j)) {
                        fruits.remove(i);
                        fruits.remove(j - 1);
                        n -= 2;
                        i--;
                        break;
                }
            }
        }
        return fruits.size();
    }

    public static void main(String[] args) {
        // Example 1
        List<Integer> fruitsList = Arrays.asList(3, 3, 1, 1, 2);
        System.out.println("Minimum fruits left for Example 1: " + countRemainingPairs(new ArrayList<>(fruitsList))); // Output: 1

      //  System.out.println(getUnusedElements(fruits1));

        // Example 2
        List<Integer> fruitsList1 = Arrays.asList(1, 2, 5, 6);
        System.out.println("Minimum fruits left for Example 2: " + countRemainingPairs(new ArrayList<>(fruitsList1))); // Output: 0

        // Example 3
        List<Integer> fruitsList2 = Arrays.asList(2, 2, 2, 5, 1, 2);
        System.out.println("Minimum fruits left for Example 3: " + countRemainingPairs(new ArrayList<>(fruitsList2))); // Output: 2

        List<Integer> fruitsList3 = Arrays.asList( 2, 2, 2, 5, 1, 2);
        System.out.println("Output: " + countRemainingPairs(new ArrayList<>(fruitsList3))); // Output: 2

        List<Integer> numbers = Arrays.asList(3, 3, 1, 1, 2);

        List<Integer> lists = Arrays.asList(1, 2, 5, 6);
        int remainingPairs = countRemainingPairs(new ArrayList<>(lists));
        System.out.println("Remaining pairs: " + remainingPairs);

    }
}
