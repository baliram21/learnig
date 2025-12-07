package org.nayan.binarysearch;

public class CountArrayRotationsOrderAgnostic {
    public static void main(String[] args) {
        int[] asc1 = {15, 18, 2, 3, 6, 12};   // ascending rotated
        int[] asc2 = {7, 9, 11, 12, 5};       // ascending rotated
        int[] asc3 = {1, 2, 3, 4, 5};         // not rotated

        int[] desc1 = {9, 7, 5, 3, 1, 11};    // descending rotated
        int[] desc2 = {20, 15, 10, 5, 30};    // descending rotated
        int[] desc3 = {50, 40, 30, 20, 10};   // not rotated

        System.out.println("Rotations (asc1) = " + countRotations(asc1));
        System.out.println("Rotations (asc2) = " + countRotations(asc2));
        System.out.println("Rotations (asc3) = " + countRotations(asc3));

        System.out.println("Rotations (desc1) = " + countRotations(desc1));
        System.out.println("Rotations (desc2) = " + countRotations(desc2));
        System.out.println("Rotations (desc3) = " + countRotations(desc3));
    }

    public static int countRotations(int[] arr) {
        int n = arr.length;
        int start = 0, end = n - 1;

        // check order
        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {
            if (isAscending) {
                // case: already sorted ascending
                if (arr[start] <= arr[end]) return start;

                int mid = start + (end - start) / 2;
                int next = (mid + 1) % n;
                int prev = (mid + n - 1) % n;

                if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                    return mid; // index of min element
                }

                if (arr[start] <= arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                // case: already sorted descending
                if (arr[start] >= arr[end]) return start;

                int mid = start + (end - start) / 2;
                int next = (mid + 1) % n;
                int prev = (mid + n - 1) % n;

                if (arr[mid] >= arr[next] && arr[mid] >= arr[prev]) {
                    return mid; // index of max element
                }

                if (arr[start] >= arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return 0;
    }
}
