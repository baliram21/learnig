package org.nayan.arrays;

import java.util.Arrays;

public class SquireInAsc {
    public static void main(String[] args) {
       // int[] arr = {-10, -5, -2, 1, 3, 7};
        int[] arr = {-8, -5, -2, 1, 3, 4};

        int[] result = squareInAsc(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] squareInAsc(int[] arr) {

        int[] nums = new int[arr.length]; //create new array b/c in place swaping not possible keep in mind.

        int left = 0;
        int right = arr.length - 1;
        int k = arr.length - 1; // ✅ fill from end so that reversing is not required

        while (left <= right) { // ✅ include middle element
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                nums[k--] = arr[left] * arr[left];
                left++;
            } else {
                nums[k--] = arr[right] * arr[right];
                right--;
            }
        }
        return nums;
    }
}
