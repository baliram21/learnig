package org.nayan.arr1;

import java.util.Arrays;

public class SortZeroAndOnes {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1, 0, 1, 1, 0};
        sortBrute(arr);
        System.out.println(Arrays.toString(sortBrute(arr)));

        sortOptimal(arr);
        System.out.println(Arrays.toString(sortOptimal(arr)));
    }

    private static int[] sortOptimal(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (arr[left] == 1 && arr[right] == 1) {
                swapArray(arr, left, right);
                left++;
                right--;
            }
            if (arr[left] == 0){
            left++;
            }
            if (arr[right] == 1){
            right--;
            }
        }
        return arr;
    }

    private static void swapArray(int[] arr, int left, int right) {

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static int[] sortBrute(int[] arr) {

        int count = 0;
        for (int num : arr) {
            if (num == 0) {
                count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i < count) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        return arr;
    }
}
