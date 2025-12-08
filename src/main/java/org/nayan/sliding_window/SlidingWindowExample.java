package org.nayan.sliding_window;

public class SlidingWindowExample {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int windowSum = 0; // sum of the current window
        int maxSum = 0;    // stores the maximum sum found
        int windowStart = 0; // left edge of the window

        // Step 1: expand the window with 'windowEnd'
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];  // add next element

            // Step 2: when we reach window size 'k', evaluate and slide
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);  // update max
                windowSum -= nums[windowStart];        // remove element going out
                windowStart++;                         // slide window forward
            }
        }

        System.out.println("Maximum sum of subarray of size " + k + " = " + maxSum);
    }
}
