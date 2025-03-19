package org.example.arr1;

public class MissingElements {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7};

        System.out.println("Missing elements:");
        findMissingElements(arr);
    }

    public static void findMissingElements(int[] arr) {
        int start = arr[0];
        int end = arr[arr.length - 1];

        // Create a boolean array to mark presence of elements
        boolean[] present = new boolean[end - start + 1];

        // Mark the elements present in the input array
        for (int num : arr) {
            present[num - start] = true;
        }

        // Identify the missing elements
        for (int i = 0; i < present.length; i++) {
            if (!present[i]) {
                System.out.print((i + start) + " ");
            }
        }
    }
}
