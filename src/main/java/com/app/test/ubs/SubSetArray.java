package com.app.test.ubs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*

Given an integer array, divide the array into 2 subsets A and B representing the following conditions:

- The intersection of A and B is null.
- The union A and B is equal to the original array.
- The number of elements in subset A is minimal.
- The sum of A's elements is greater than the sum of B's elements.

Return the subset A in increasing order where the sum of A's elements is greater than the sum of B's elements. if more than one subset
exists, return the one with the maximal sum.

example
n=5
arr = [3,7,5,6,2]

The 2 subsets in arr that satisfy the conditions for A are [5,7] and [6,7]

A is minimal size 2
Sum(A)= (5+7)=12>sum(B) = (2 + 3+ 6) =11
sum(A) = (6+7) = 13 > sum(B)= (2+3+5) =10
The intersection of A and B is null and their  union is equal to arr.
The subset A where the sum of its element is maximal is [6,7]

Functional Description
Complete the subsetA  function in the editor below

subsetA has the following parameters

int arr[]:an integer array
returns:
int[] and integer array with value of subset A.

Constrains:

1<=n<=10^5
1<=arr[i]<=10^5 (where 0<=i<=n)

[2,5,5,9] => [9,2]
[2,2,4,5,5,11] => [11,4]
[5,5,5,10,10,10,11] => [10,10,10]
[3,7,5,6,2] => [7,6]
[2,3,4,4,5,9,7,8,6,10,4,5,10,10,8,4,6,4,10,1] => [10, 10, 10, 10,9,8,8] .

Time Complexity: O(nlogn)
Space complexity: O(n)


 */
public class SubSetArray {


    public static int[] subsetA(int[] arr) {
        // Sort the array in ascending order
        Arrays.sort(arr);
        int n= arr.length-1;
        List<Integer> elements = new ArrayList<>();
        for (int i:arr
             ) {
            elements.add(i);
        }
        List<Integer> A = new ArrayList<>();

        // Initialize sums of subsets A and B
        long sumA = 0;

        int total = Arrays.stream(arr).sum();

        for (int i = n; i > 0; i--) {
            if (sumA <= total - sumA) {
                A.add(elements.get(i));
                elements.remove(i);

                sumA = A.stream().mapToLong(Integer::longValue).sum();
            } else {
                break;
            }
        }
        Collections.sort(A);
        return A.stream().mapToInt(Integer::intValue).toArray();
        }
/*/
The 2 subsets in arr that satisfy the conditions for A are [5,7] and [6,7]

A is minimal size 2
Sum(A)= (5+7)=12>sum(B) = (2 + 3+ 6) =11
sum(A) = (6+7) = 13 > sum(B)= (2+3+5) =10
The intersection of A and B is null and their  union is equal to arr.
The subset A where the sum of its element is maximal is [6,7]

 */
        // If no valid subset A is found, return an empty array



    public static List<Integer> subsetA(List<Integer> arr) {
        Collections.sort(arr);

        List<Integer> A = new ArrayList<>();
        int n = arr.size() - 1;
        long total = arr.stream().mapToLong(Integer::longValue).sum();
        long sumA = 0;

        for (int i = n; i > 0; i--) {
            if (sumA <= total - sumA) {
                A.add(arr.get(i));
                arr.remove(i);

                sumA = A.stream().mapToLong(Integer::longValue).sum();
            } else {
                break;
            }
        }

        Collections.sort(A);

        return A;
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 5, 6, 2};
        int[] subsetA = subsetA(arr);
        System.out.println("Subset A: " + Arrays.toString(subsetA));

        List<Integer> aa = new ArrayList();
        aa.add(2);
        aa.add(3);
        aa.add(5);
        aa.add(9);

        System.out.println(subsetA(aa));
        List<Integer> aa1 =new ArrayList<>() ;
        for (int i:arr
             ) {
            aa1.add(i);
        }
        System.out.println(subsetA(aa1));

        int [] arr1 ={2,5,5,9};

        List<Integer> aa2 =new ArrayList<>() ;
        for (int i:arr1
        ) {
            aa2.add(i);
        }
        System.out.println(subsetA(aa2));

        int [] arr2 = {2,2,4,5,5,11};
        List<Integer> aa3 =new ArrayList<>() ;
        for (int i:arr2
        ) {
            aa3.add(i);
        }
        System.out.println(subsetA(aa3));

    }
}
