package org.nayan.arr1;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};
        int end = arr.length - 1;
        int[] reverse1 = reverse1(arr, 0, end);
        System.out.println(Arrays.toString(reverse1));
    }

    private static int[] reverse1(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
    }
