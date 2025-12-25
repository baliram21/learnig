package org.nayan.dsa.binarysearch;

public class BinarySearchDescending {
    // find index of target using binary search in descending sorted array
    public static void main(String[] args) {
        int[] arr = {20, 17, 15, 13, 10, 8, 6, 4, 1};
        int target = 10;
        int index = binarysearchDescending(arr, target);
        System.out.println(index);
    }

    private static int binarysearchDescending(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target > arr[mid]) {   // flip condition
                end = mid - 1;
            } else if (target < arr[mid]) { // flip condition
                start = mid + 1;
            } else {
                return mid; // target found
            }
        }
        return -1; // not found
    }
}
