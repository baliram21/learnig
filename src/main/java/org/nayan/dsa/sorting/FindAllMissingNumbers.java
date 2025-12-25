package org.nayan.dsa.sorting;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumbers {

    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> list = missingNumbers(arr);
        System.out.println(list);
    }

    private static List<Integer> missingNumbers(int[] arr) {

        List<Integer> list = new ArrayList<>();
        int i = 0;

        // Step 1: Cyclic Sort
        while (i < arr.length) {

            int correctIdx = arr[i] - 1;

            if (arr[i] >= 1 && arr[i] <= arr.length
                    && arr[i] != arr[correctIdx]) {

                swap(arr, i, correctIdx);

            } else {
                i++;
            }
        }

        // Step 2: Collect missing numbers
        for (int j = 0; j < arr.length; j++) {
            int missing = j + 1;
            if (arr[j] != missing) {
                //list.add(j + 1);
                list.add(missing);
            }
        }

        return list;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
