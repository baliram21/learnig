package org.nayan.arr1;

import java.util.ArrayList;
import java.util.List;

public class MissingElements {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7};

        List<Integer> missingElements = findMissingElements(arr);
        System.out.println(missingElements);
    }

    public static List<Integer> findMissingElements(int[] arr) {

        List<Integer> missing = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            int current = arr[i];
            int next = arr[i + 1];

            // add all missing numbers between current and next
            for (int num = current + 1; num < next; num++) {
                missing.add(num);
            }
        }

        return missing;
    }
}
