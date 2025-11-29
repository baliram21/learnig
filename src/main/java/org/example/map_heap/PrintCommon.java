package org.example.map_heap;

import java.util.HashMap;
import java.util.Map;

public class PrintCommon {
    public static void main(String[] args) {

        // Input arrays
        int[] arr1 = {1, 1, 1, 2, 2, 2, 2, 3, 3, 4};
        int[] arr2 = {2, 2, 1, 1, 3, 5, 6, 6, 9, 7};
        // Expected Output → 1, 1, 2, 2, 3

        /* -------------------------------------------------------------------
           STEP 1: Build frequency map of elements from arr1

           Example for arr1:
           1 → 3 times
           2 → 4 times
           3 → 2 times
           4 → 1 time
        ---------------------------------------------------------------------*/
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            int num = arr1[i];

            // If key exists → increase count
            if (map.containsKey(num)) {
                Integer val = map.get(num);
                map.put(num, val + 1);
            }
            // If key not exists → insert with count = 1
            else {
                map.put(num, 1);
            }
        }

        /* -------------------------------------------------------------------
           STEP 2: Loop through arr2 and check if the number exists in the map.

           - If exists → print the number (because it's common)
           - Decrease the count in map (frequency logic)
           - Remove key when count becomes 0 (important)
        ----------------------------------------------------------------------*/
        for (int i = 0; i < arr2.length; i++) {

            int num = arr2[i];

            // Only print when count is available in map
            if (map.containsKey(num)) {

                System.out.println(num);    // Print common value

                Integer val = map.get(num); // Get current frequency

                // Decrease frequency by 1
                map.put(num, val - 1);

                // If count becomes 0 → remove the key
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }
    }
}
