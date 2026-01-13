package org.nayan.arr1;

import java.util.Arrays;

public class RotateArrayByDPlaces {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        int d = 3;
        int[] temp = new int[3];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        for (int i = d; i < arr.length; i++) {
            arr[i-d]  = arr[i];
        }
        int j = 0;
        for (int i = arr.length-d; i < arr.length; i++) {
            arr[i] = temp[j++];

        }
        System.out.println(Arrays.toString(arr));

    }
}
