package org.nayan.arrays;

import java.util.Arrays;

public class ShiftOnes {
    public static void main(String[] args) {
        int[] arr = {5, 6, 4, 1, 4, 1, 4, 5, 1};

        shiftOnesToStart(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shiftOnesToStart(int[] arr) {
        int pos = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                int temp = arr[pos];
                arr[pos] = arr[i];
                arr[i] = temp;
                pos++;
            }
        }
    }
}
