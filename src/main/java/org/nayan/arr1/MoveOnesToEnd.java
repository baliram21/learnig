package org.nayan.arr1;

import java.util.Arrays;

public class MoveOnesToEnd {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 1, 6, 1, 7, 9};

        int[] temp = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1) {
                temp[index++] = arr[i];
            }
        }
        for (int num : arr) {
            if (num == 1) {
                temp[index++] = num;
            }
        }


        System.out.println(Arrays.toString(temp));
    }
}
