package org.nayan.dsa.kadanealgo_array;

import java.util.Arrays;

public class MaximumProductSubarrayWithIndices {

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};

        int[] result = maxProductSubarray(arr);
        System.out.println("Maximum product subarray: " + Arrays.toString(result));
    }

    public static int[] maxProductSubarray(int[] arr) {

        // Edge case
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int maxProd = arr[0];   // Max product ending here
        int minProd = arr[0];   // Min product ending here
        int globalMax = arr[0];

        // Indices for tracking subarrays
        int maxStart = 0;
        int minStart = 0;

        int bestStart = 0;
        int bestEnd = 0;

        for (int i = 1; i < arr.length; i++) {

            int current = arr[i];

            // If current element is negative, swap max & min
            if (current < 0) {
                int tempProd = maxProd;
                maxProd = minProd;
                minProd = tempProd;

                int tempIndex = maxStart;
                maxStart = minStart;
                minStart = tempIndex;
            }

            // Decide whether to start new max product subarray
            if (current > maxProd * current) {
                maxProd = current;
                maxStart = i;
            } else {
                maxProd *= current;
            }

            // Decide whether to start new min product subarray
            if (current < minProd * current) {
                minProd = current;
                minStart = i;
            } else {
                minProd *= current;
            }

            // Update global maximum and indices
            if (maxProd > globalMax) {
                globalMax = maxProd;
                bestStart = maxStart;
                bestEnd = i;
            }
        }

        // Return actual subarray
        return Arrays.copyOfRange(arr, bestStart, bestEnd + 1);
    }
}
