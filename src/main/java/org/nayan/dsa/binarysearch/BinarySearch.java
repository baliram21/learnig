package org.nayan.dsa.binarysearch;

public class BinarySearch {
    //find index of target using binary search
    public static void main(String[] args) {
        int[] arr = {2,4,5,7,9,11,13,17,19};
        int target = 5;
        int index = binarySearch(arr, target);
        System.out.println(index);

    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;

        while (start<=end){

            int mid = start+ (end-start)/2;

            if(target< arr[mid]){
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static int binarySearchRecursive(int[] arr, int start, int end, int target) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;

        if (target < arr[mid]) {
            return binarySearchRecursive(arr, start, mid - 1, target);
        } else if (target > arr[mid]) {
            return binarySearchRecursive(arr, mid + 1, end, target);
        } else {
            return mid;
        }
    }
    // call by :-  int index1 = binarysearchRecursive(arr, 0, arr.length - 1, target);

}
