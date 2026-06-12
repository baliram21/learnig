package org.nayan.arrays;

import java.util.Arrays;

public class OddEvenArrange {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};  //{all even first    ... and then all even}

        System.out.println(Arrays.toString(oddEvenArrange(arr)));
    }

    public static int[] oddEvenArrange(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] % 2 != 0 && arr[right] % 2 == 0) {
                swapArray(arr, left, right);
                left++;
                right--;
            }

            if (arr[left] % 2 == 0) {
                left++;
            }
            if (arr[right] % 2 != 0) {
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
}
