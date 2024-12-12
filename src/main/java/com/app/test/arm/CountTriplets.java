package com.app.test.arm;

/*

Imagine you have been given an array of integers, and a query number k. Your task is to write a function that
finds all the triplets in the array that sum up to the query number k.

Let’s illustrate this with some examples:

Example 1:

Input:

nums = [1, 2, 3, 4, 5]
k = 6
Output:

count_triplets(nums, k) -> 1
In this case, there is only one triplet that sums up to 6: (1, 2, 3).

Example 2:

Input:

nums = [10, 10, 20, 30, 40]
k = 60
Output:

count_triplets(nums, k) -> 3
In this case, there are three triplets that sum up to 60: (10, 10, 40), (10, 20, 30), and (10, 20, 30).
The value 10 can be retrieved as nums[0] or nums[1], therefore resulting in two triplets with the same value.


Sort the Array: Sorting the array will help us efficiently find triplets using a two-pointer approach.

Iterate with a Fixed Element: Fix one element (let's call it nums[i]) and use two pointers to find the
other two elements that, along with nums[i], sum up to k.

Use Two Pointers: For each fixed element, use two pointers (left and right) to find the other two elements.
The left pointer starts just after the fixed element, and the right pointer starts from the end of the array.
Adjust the pointers based on whether the current sum is less than or greater than k.

Count Valid Triplets: Count triplets that meet the criteria and ensure no duplicates are counted by handling indices carefully.

Time Complexity:
𝑂(𝑛^2) due to the nested loops.
Space Complexity:
O(1) apart from the input storage.
 */
import java.util.*;

public class CountTriplets {


    public static int countTriplets1(List<Integer> numss, int k) {
        List<Integer> nums = new ArrayList<>(numss);
        if (nums == null || nums.size() < 3) {
            return 0;
        }

        Collections.sort(nums);
        int count = 0;
        int n = nums.size();

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums.get(i) + nums.get(left) + nums.get(right);
                if (sum == k) {
                    count++;
                    // Move both pointers after finding a valid triplet
                    left++;
                    right--;
                } else if (sum < k) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
    public static int countTriplets(List<Integer> nums, int k) {
        if (nums == null || nums.size() < 3) {
            return 0;
        }

        // Convert List to array for easier handling
        int[] arr = nums.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);  // Sort the array
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == k) {
                    count++;
                    // Move both pointers after finding a valid triplet
                    left++;
                    right--;
                } else if (sum < k) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }


    public static int countTriplets(int[] nums, int k) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);  // Sort the array
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == k) {
                    count++;
                    // Move both pointers after finding a valid triplet
                    left++;
                    right--;
                } else if (sum < k) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        List<Integer> nums1 = List.of(1, 2, 3, 4, 5);
        int k1 = 6;
        System.out.println("Count of triplets: " + countTriplets1(nums1, k1)); // Output: 1

        List<Integer> nums2 = List.of(10, 10, 20, 30, 40);
        int k2 = 60;
        System.out.println("Count of triplets: " + countTriplets1(nums2, k2)); // Output: 3


        int[] nums3 = {1, 2, 3, 4, 5};

        System.out.println("Count of triplets: " + countTriplets(nums3, k1)); // Output: 1

        int[] nums4 = {10, 10, 20, 30, 40};

        System.out.println("Count of triplets: " + countTriplets(nums4, k2)); // Output: 3

        Set<Integer> set = new HashSet<>();
        set.add(4);
        set.add(10);
        set.add(7);
        set.add(2);
        set.add(9);

      //  set.stream().forEach(System.out::println);

    }
}

