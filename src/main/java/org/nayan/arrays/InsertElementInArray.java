package org.nayan.arrays;

import java.util.Arrays;

public class InsertElementInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int elementToInsert = 99;
        int position = 2; // Inserting at position 2 (0-based index)

        int[] newArr = insertElement(arr, elementToInsert, position);

        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Array after insertion: " + Arrays.toString(newArr));
    }

    public static int[] insertElement(int[] arr, int element, int position) {
        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < position; i++) {
            newArr[i] = arr[i];
        }

        newArr[position] = element;

        for (int i = position; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        return newArr;
    }
}
