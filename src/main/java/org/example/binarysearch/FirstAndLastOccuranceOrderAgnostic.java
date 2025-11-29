package org.example.binarysearch;

public class FirstAndLastOccuranceOrderAgnostic {
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 7, 9, 9, 9, 11, 13};       // ascending
        int[] arr2 = {20, 17, 15, 15, 15, 13, 10, 5};  // descending

        int target = 15;

        printOccurrences(arr1, target);
        System.out.println("----------------------");
        printOccurrences(arr2, target);
    }

    private static void printOccurrences(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);

        if (first == -1 || last == -1) {
            System.out.println("Element " + target + " not found");
        } else {
            System.out.println("First Occurrence of " + target + " = " + first);
            System.out.println("Last Occurrence of " + target + " = " + last);
            System.out.println("Total Occurrences of " + target + " = " + (last - first + 1));
        }
    }

    // Find first occurrence (works for asc/desc)
    private static int firstOccurrence(int[] arr, int target) {
        int start = 0, end = arr.length - 1, res = -1;
        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                res = mid;
                // keep searching left side
                if (isAscending) {
                    end = mid - 1;
                } else {
                    end = mid - 1;
                }
            } else if ((isAscending && target < arr[mid]) || (!isAscending && target > arr[mid])) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    // Find last occurrence (works for asc/desc)
    private static int lastOccurrence(int[] arr, int target) {
        int start = 0, end = arr.length - 1, res = -1;
        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                res = mid;
                // keep searching right side
                if (isAscending) {
                    start = mid + 1;
                } else {
                    start = mid + 1;
                }
            } else if ((isAscending && target < arr[mid]) || (!isAscending && target > arr[mid])) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}
