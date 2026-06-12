package org.nayan.dsa.map_heap.map;

import java.util.HashMap;
import java.util.Map;

public class CountAndLongestZeroSumSubArray {

    public static void main(String[] args) {

        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        int sum = 0;
        int count = 0;
        int maxLength = 0;
        int i = -1;

        // Map for counting prefix sum frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Map for storing first occurrence index of prefix sum
        Map<Integer, Integer> indexMap = new HashMap<>();

        // Initialization to handle subarrays starting at index 0
        freqMap.put(0, 1);
        indexMap.put(0, -1);

        while (i < arr.length - 1) {
            i++;
            sum += arr[i];

            // -------- COUNT ZERO SUM SUBARRAYS --------
            if (freqMap.containsKey(sum)) {
                count += freqMap.get(sum);
                freqMap.put(sum, freqMap.get(sum) + 1);
            } else {
                freqMap.put(sum, 1);
            }

            // -------- LONGEST ZERO SUM SUBARRAY --------
            if (!indexMap.containsKey(sum)) {
                indexMap.put(sum, i);
            } else {
                int length = i - indexMap.get(sum);
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }

        System.out.println("Total zero-sum subarrays = " + count);
        System.out.println("Longest zero-sum subarray length = " + maxLength);
    }
}

/*
===============================
EXPLANATION
===============================

Problem:
---------
1) Count total number of subarrays with sum = 0
2) Find the length of the longest subarray with sum = 0

Approach Used:
--------------
Prefix Sum + HashMap (Single Pass)

Why Two Maps?
-------------
1) freqMap:
   - key   -> prefix sum
   - value -> frequency of that prefix sum
   - Used to COUNT zero-sum subarrays

2) indexMap:
   - key   -> prefix sum
   - value -> FIRST index where this sum appeared
   - Used to find LONGEST zero-sum subarray

Why prefix sum?
---------------
If the same prefix sum occurs at indices j and i:
    sum(j+1 ... i) = 0

Initialization:
---------------
freqMap.put(0,1)
indexMap.put(0,-1)

This handles subarrays that start from index 0.

Logic Flow:
-----------
1. Traverse array once.
2. Update prefix sum.
3. Use freqMap to count subarrays.
4. Use indexMap to compute longest length.

Example Walkthrough:
--------------------
Array:
    [15, -2, 2, -8, 1, 7, 10, 23]

Prefix sums:
    15, 13, 15, 7, 8, 15, 25, 48

Prefix sum 15:
    Appears at indices 0, 2, 5

Count:
------
C(3,2) = 3 zero-sum subarrays

Longest:
--------
Longest span = 5 (from index 1 to 5)

Output:
-------
Total zero-sum subarrays = 3
Longest zero-sum subarray length = 5

Time Complexity:
----------------
O(n)

Space Complexity:
-----------------
O(n)

Interview Tip:
--------------
Count  -> store FREQUENCY
Longest-> store FIRST INDEX
*/