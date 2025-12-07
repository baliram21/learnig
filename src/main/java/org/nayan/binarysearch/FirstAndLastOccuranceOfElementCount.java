package org.nayan.binarysearch;

public class FirstAndLastOccuranceOfElementCount {
    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 9, 9, 9, 11, 13};
        int target = 9;

        int firstOccurance = firstOccurance(arr, target);
        int lastOccurance = lastOccurance(arr, target);

        if (firstOccurance == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("First Occurrence of " + target + " = " + firstOccurance);
            System.out.println("Last Occurrence of " + target + " = " + lastOccurance);

            int totalCount = lastOccurance - firstOccurance + 1;
            System.out.println("Total Occurrences of " + target + " = " + totalCount);
        }
    }

    // Find first occurrence
    private static int firstOccurance(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                res = mid;      // possible answer
                end = mid - 1;  // search left side
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    // Find last occurrence
    private static int lastOccurance(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                res = mid;       // possible answer
                start = mid + 1; // search right side
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}
