package org.nayan.dsa.kadanealgo_array;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Maximum sum: " + maxSubArraySum(arr));
    }

    public static int maxSubArraySum(int[] arr) {

        // Edge case: empty array
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int currentSum = arr[0];  // Max sum ending at current index
        int maxSum = arr[0];      // Global maximum sum

        // Start from second element
        for (int i = 1; i < arr.length; i++) {

            // Either extend existing subarray or start new subarray
            currentSum = Math.max(arr[i], currentSum + arr[i]);

            // Update global maximum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
