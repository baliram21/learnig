package org.nayan.arr1;

import java.util.Arrays;

public class  MergeSortedArray{
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 4, 6, 8, 9};

        int[] arr = mergeArray(arr1, arr2);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] mergeArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] arr3 = new int[n + m];

        int left = 0, right = 0, index = 0;

        // Merge the arrays
        while (left < n && right < m) {
            if (arr1[left] <= arr2[right]) {
                arr3[index++] = arr1[left++];
            } else {
                arr3[index++] = arr2[right++];
            }
        }

        // Copy remaining elements
        while (left < n) {
            arr3[index++] = arr1[left++];
        }

        while (right < m) {
            arr3[index++] = arr2[right++];
        }

        return arr3;
    }
}
