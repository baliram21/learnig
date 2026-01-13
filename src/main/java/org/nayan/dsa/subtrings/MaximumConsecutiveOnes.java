package org.nayan.dsa.subtrings;

public class MaximumConsecutiveOnes {

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1};
        System.out.println("Max consecutive 1s: " + findMaxConsecutiveOnes(arr));
    }

    public static int findMaxConsecutiveOnes(int[] arr) {

        int maxCount = 0;     // Stores maximum consecutive 1s
        int currentCount = 0; // Stores current streak of 1s

        for (int num : arr) {

            if (num == 1) {
                currentCount++;              // Extend streak
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;            // Reset streak
            }
        }

        return maxCount;
    }
}
