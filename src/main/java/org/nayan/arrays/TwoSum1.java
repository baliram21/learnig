package org.nayan.arrays;

import java.util.Arrays;

public class TwoSum1 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int target1 = 9;

        int[] pinterAns = twoSumByTwoPointer(arr1, 0, arr1.length - 1, target1);
        System.out.println(Arrays.toString(pinterAns));
    }

    private static int[] twoSumByTwoPointer(int[] arr, int start, int end, int target) {

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (target == sum) {
                return new int[]{start, end};
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return arr;
    }
}
