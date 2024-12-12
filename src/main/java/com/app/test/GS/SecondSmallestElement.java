package com.app.test.GS;

public class SecondSmallestElement {

    public static void main(String[] args) {
        int[] array = {10, 5, 8, 20, 15};

        int secondSmallest = findSecondSmallest(array);

        if (secondSmallest != Integer.MAX_VALUE) {
            System.out.println("The second smallest element is: " + secondSmallest);
        } else {
            System.out.println("Array doesn't have a second smallest element.");
        }
    }

    public static int findSecondSmallest(int[] arr) {
        if (arr.length < 2) {
            // Array doesn't have a second smallest element
            return Integer.MAX_VALUE;
        }

        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < firstSmallest) {
                secondSmallest = firstSmallest;
                firstSmallest = num;
            } else if (num < secondSmallest && num > firstSmallest) {
                secondSmallest = num;
            }
        }

        return secondSmallest;
    }
}
