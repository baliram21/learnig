package org.nayan.dsa.sorting;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 2,3};

        int duplicate = findDuplicate(arr);
        System.out.println("Duplicate is :- "+duplicate);
    }

    private static int findDuplicate(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j+1 ){
            return arr[j];
            }

        }
        return arr.length;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
