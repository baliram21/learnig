package org.nayan.dsa.subtrings;

public class MaxConsecutiveOnesWithKFlips {

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        System.out.println("Max consecutive 1s: " + longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {

        int left = 0;          // Start of sliding window
        int zeroCount = 0;     // Number of zeros in window
        int maxLength = 0;     // Best result

        // Expand window using right pointer
        for (int right = 0; right < nums.length; right++) {

            // If current element is zero, we "use" one flip
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If zero count exceeds k, shrink window
            while (zeroCount > k) {

                if (nums[left] == 0) {
                    zeroCount--;   // Release a flip
                }
                left++;            // Shrink from left
            }

            // Update maximum window size
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
