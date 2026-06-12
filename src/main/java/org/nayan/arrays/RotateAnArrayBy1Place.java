package org.nayan.arrays;

import java.util.Arrays;

public class RotateAnArrayBy1Place {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        int n = arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }

        arr[arr.length-1] = n;

        System.out.println(Arrays.toString(arr));
    }
}
