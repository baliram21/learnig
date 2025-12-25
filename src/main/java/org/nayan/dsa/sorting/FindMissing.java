package org.nayan.dsa.sorting;

import java.util.Arrays;

public class FindMissing {

    public static void main(String[] args) {

        // int[] arr = {3, 0, 1};

        int[] arr = {0,1};

        int missing = findMissingNumber(arr);
        System.out.println("Missing number is: " + missing);
    }

    private static int findMissingNumber(int[] arr) {

        int i = 0;

        // Step 1: Cyclic sort
        while (i < arr.length) {

            int correctIndex = arr[i];

            if (arr[i] < arr.length && arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }

        // Step 2: Find missing index
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index) {
                return index;
            }
        }

        // If no mismatch, missing number is n
        return arr.length;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
