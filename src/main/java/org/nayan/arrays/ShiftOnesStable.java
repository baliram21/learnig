package org.nayan.arrays;

import java.util.Arrays;

public class ShiftOnesStable {
    public static void main(String[] args) {
        int[] arr = {5, 6, 4, 1, 4, 1, 4, 5, 1};

        int[] result = shiftOnesStable(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] shiftOnesStable(int[] arr) {
        int[] res = new int[arr.length];
        int index = 0;

        // put all 1s first
        for (int num : arr) {
            if (num == 1) {
                res[index++] = 1;
            }
        }

        // put remaining elements
        for (int num : arr) {
            if (num != 1) {
                res[index++] = num;
            }
        }
        return res;
    }
}
