package org.example.dsa;

import java.util.ArrayList;
import java.util.List;

public class FindMissingAndDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3, 2};
       /* List<Integer> result = findNumbers(arr);
        System.out.println("Duplicate Number: " + result.get(0));
        System.out.println("Missing Number: " + result.get(1));*/
        findNumbers(arr);

    }

    private static void findNumbers(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int i = 0;

        // Cyclic sort implementation
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        // Find the missing and duplicate numbers
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                list.add(arr[j]);  // Duplicate number
                list.add(j + 1);   // Missing number
                break;
            }
        }
        System.out.println(list);
        // return list;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
