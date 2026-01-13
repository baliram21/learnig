package org.nayan.arr1;

import java.util.Arrays;

public class MoveOnesToEndOptimal {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 1, 6, 1, 7, 9};

        int[] ints = moveOnesToEnd(arr);
        System.out.println(Arrays.toString(ints));


    }

    private static int[] moveOnesToEnd(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }

        return arr;
    }
}
