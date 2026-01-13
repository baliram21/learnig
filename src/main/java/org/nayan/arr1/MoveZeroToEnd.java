package org.nayan.arr1;

import java.util.Arrays;

public class MoveZeroToEnd {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 3, 0, 4, 5, 0, 6, 7};

        int[] temp = new int[arr.length];

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                temp[count] = arr[i];
                count++;
            }
        }
        System.out.println(Arrays.toString(temp));
    }
}
