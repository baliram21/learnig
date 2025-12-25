package org.nayan.dsa.binarysearch;

public class CountArrayRotations {
    public static void main(String[] args) {
        int[] arr1 = {15, 18, 2, 3, 6, 12};
        int[] arr2 = {7, 9, 11, 12, 5};
        int[] arr3 = {1, 2, 3, 4, 5};

        System.out.println("Rotations = " + countRotations(arr1)); // 2
        System.out.println("Rotations = " + countRotations(arr2)); // 4
        System.out.println("Rotations = " + countRotations(arr3)); // 0
    }

    public static int countRotations(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            // if already sorted (no rotation)
            if (arr[start] <= arr[end]) {
                return start;
            }

            int mid = start + (end - start) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            // check if mid is minimum
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid; // index of min element
            }

            // if left half is sorted, min must be in right half
            if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } 
            // else right half is sorted, min must be in left half
            else {
                end = mid - 1;
            }
        }
        return 0;
    }
}
