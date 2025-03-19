package org.example.arr1;// Java program to Rearrange array such that even positioned are greater than odd

import java.util.ArrayList;
import java.util.Collections;

class A {

    static ArrayList<Integer>
    rearrangeArray(ArrayList<Integer> arr) {
        int n = arr.size();

        // Traverse the array and make adjustments to
        // satisfy the condition
        for (int i = 1; i < n; i++) {

            // Check if the index is even (1-based), i.e.,
            // i+1 is even
            if ((i + 1) % 2 == 0) {
                // Ensure that the current element is
                // greater than or equal to the previous
                // element
                if (arr.get(i) < arr.get(i - 1)) {
                    Collections.swap(arr, i, i - 1);
                }
            }
            else {
                // Ensure that the current element is less
                // than or equal to the previous element
                if (arr.get(i) > arr.get(i - 1)) {
                    Collections.swap(arr, i, i - 1);
                }
            }
        }
 
        return arr;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(1);

        ArrayList<Integer> res = rearrangeArray(arr);

        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}