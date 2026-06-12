package org.nayan.dsa.map_heap.map;

import java.util.HashMap;
import java.util.Map;

public class DistinctElementsInWindow {

    public static void countDistinct(int[] arr, int k) {

        // Edge case
        if (k > arr.length) {
            System.out.println("Window size is larger than array");
            return;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Process first window
        for (int i = 0; i < k; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(freqMap.size()); // distinct count for first window

        // Step 2: Slide the window
        for (int i = k; i < arr.length; i++) {

            // Remove outgoing element
            int out = arr[i - k];
            freqMap.put(out, freqMap.get(out) - 1);
            if (freqMap.get(out) == 0) {
                freqMap.remove(out);
            }

            // Add incoming element
            int in = arr[i];
            freqMap.put(in, freqMap.getOrDefault(in, 0) + 1);

            // Print distinct count
            System.out.println(freqMap.size());
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;

        countDistinct(arr, k);
    }
}