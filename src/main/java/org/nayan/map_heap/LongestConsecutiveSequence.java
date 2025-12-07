package org.nayan.map_heap;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        // Input array (may contain duplicates and unsorted)
        int[] arr = {1, 3, 4, 6, 2, 8, 3, 5,11,9};

        /*
         * Step 1: Put every number into a map with a boolean flag.
         * The boolean means "is this number a possible sequence start?"
         * We initialize every entry to true (optimistically assume it's a start).
         */
        Map<Integer, Boolean> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, true); // duplicates will overwrite but that's fine
        }

        /*
         * Step 2: If a number has a predecessor (val - 1) present,
         * then it cannot be the start of a sequence -> mark false.
         * After this loop map.get(x) == true iff x is a sequence start.
         */
        for (int val : arr) {
            if (map.containsKey(val - 1)) {
                map.put(val, false);
            }
        }

        /*
         * Step 3: For each value that is flagged true (a sequence start),
         * walk forward counting consecutive numbers (tsp + tl).
         * Track the maximum length (ml) and the starting point (msp).
         */
        int msp = 0; // max sequence starting point
        int ml = 0;  // max length

        for (int val : arr) {
            // Only consider numbers that are marked as starts
            // Use Boolean.TRUE to avoid NPE when map.get returns null (defensive).
            if (Boolean.TRUE.equals(map.get(val))) {
                int tl = 1;      // temporary length for current sequence
                int tsp = val;   // temporary starting point

                // Extend the sequence as long as the next number exists
                while (map.containsKey(tsp + tl)) {
                    tl++;
                }

                // If current sequence is longer, update global best
                if (tl > ml) {
                    msp = tsp;
                    ml = tl;
                }
            }
        }

        /*
         * Step 4: Print the longest consecutive sequence from msp with length ml.
         * If ml == 0 (empty array), nothing prints.
         */
        for (int i = 0; i < ml; i++) {
            System.out.println(msp + i);
        }
    }
}
