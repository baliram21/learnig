package org.nayan.dsa.kadanealgo_array;

import java.util.Arrays;

public class MaximumSubarrayWithIndices {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int[] result = maxSubArray(arr);
        System.out.println("Maximum sum subarray: " + Arrays.toString(result));
    }

    public static int[] maxSubArray(int[] arr) {

        // Edge case
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int currentSum = arr[0];   // Current running sum
        int maxSum = arr[0];       // Best sum so far

        int start = 0;             // Start index of best subarray
        int end = 0;               // End index of best subarray
        int tempStart = 0;         // Temporary start index

        for (int i = 1; i < arr.length; i++) {

            // Decide whether to start new subarray
            if (arr[i] > currentSum + arr[i]) {
                currentSum = arr[i];
                tempStart = i;     // New subarray starts here
            } else {
                currentSum += arr[i];
            }

            // Update best subarray
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        // Copy and return the actual subarray
        return Arrays.copyOfRange(arr, start, end + 1);
    }
}
