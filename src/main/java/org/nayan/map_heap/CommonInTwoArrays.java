package org.nayan.map_heap;

import java.util.HashMap;
import java.util.Map;

public class CommonInTwoArrays {
    public static void main(String[] args) {

        // Two sample input arrays
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {2,3,5,7,8,9,10};

        /* ---------------------------------------------------------
           STEP 1: Create a HashMap to store frequencies of elements
                   from arr1.
           Why?
           - Using a map helps in O(1) lookup to check
             if an element exists in the first array.
        -------------------------------------------------------------*/
        Map<Integer, Integer> map = new HashMap<>();

        // Loop over arr1 and store counts in the Map
        for (int i = 0; i < arr1.length; i++) {

            int num = arr1[i];  // current element

            /* --------------------------------------------------------
               If element already in map → increase its frequency
               else → insert it with count = 1
            ------------------------------------------------------------*/
            if (map.containsKey(num)) {
                Integer val = map.get(num);  // get existing frequency
                map.put(num, val + 1);       // increment frequency
            } else {
                map.put(num, 1);             // first occurrence
            }
        }

        // Print frequency map (debugging purpose)
        System.out.println(map);

        /* ---------------------------------------------------------
           STEP 2: Iterate arr2 and check common elements

           Idea:
           - If an element of arr2 exists in the map → it is common
           - Print it
           - Remove from map → ensures no duplicate printing
        -------------------------------------------------------------*/
        for (int i = 0; i < arr2.length; i++) {

            int num = arr2[i];  // current element of arr2

            // If element also exists in arr1 (checking via map)
            if (map.containsKey(num)) {

                System.out.println(num);  // print common element

                /* ----------------------------------------------------
                   Remove the element from map so if arr2 contains
                   duplicate values, we do not print it multiple times.
                ------------------------------------------------------*/
                map.remove(num);
            }
        }
    }
}
