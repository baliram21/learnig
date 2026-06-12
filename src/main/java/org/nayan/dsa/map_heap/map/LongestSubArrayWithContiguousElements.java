package org.nayan.dsa.map_heap.map;

import java.util.HashSet;
import java.util.Set;

public class LongestSubArrayWithContiguousElements {

    public static void main(String[] args) {

        int[] arr = {10, 12, 11, 14, 13, 15};

        int n = arr.length;
        int maxLength = 1;

        for (int i = 0; i < n; i++) {

            int min = arr[i];
            int max = arr[i];

            Set<Integer> set = new HashSet<>();
            set.add(arr[i]);

            for (int j = i + 1; j < n; j++) {

                // If duplicate found, break (cannot be contiguous)
                if (set.contains(arr[j])) {
                    break;
                }

                set.add(arr[j]);

                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

                // Check contiguous condition
                if (max - min == j - i) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        System.out.println("Longest contiguous subarray length = " + maxLength);
    }
}

/*
===============================
EXPLANATION
===============================

Problem:
---------
Find the length of the LONGEST subarray whose elements
can be rearranged to form a contiguous sequence.

Contiguous Elements:
--------------------
Elements that differ by exactly 1.
Example:
    {4,5,6,7} → contiguous
    {10,11,12} → contiguous

Order does NOT matter:
----------------------
{10,12,11} → contiguous (after sorting)

Key Condition:
--------------
For a subarray from index i to j:
    max - min == j - i
AND
    no duplicate elements

Why this works?
---------------
If elements are contiguous and unique,
their count must match the range size.

Example:
---------
Subarray: {10,12,11}
min = 10
max = 12
length = 3

max - min = 2
j - i = 2  → valid contiguous subarray

Why HashSet?
------------
To detect duplicates.
Duplicate elements break contiguity.

Logic Flow:
-----------
1. Fix starting index i.
2. Track min and max while expanding j.
3. Use HashSet to detect duplicates.
4. If (max - min == j - i), update maxLength.

Example Walkthrough:
--------------------
Array:
    {10, 12, 11, 14, 13, 15}

Subarray:
    {10,12,11}
min = 10, max = 12
length = 3 → valid

Subarray:
    {12,11,14,13}
min = 11, max = 14
length = 4 → valid

Longest Length:
---------------
4

Time Complexity:
----------------
O(n²)

Space Complexity:
-----------------
O(n) for HashSet

Interview Tip:
--------------
This is NOT the same as "longest consecutive sequence".
That problem ignores subarrays.
This problem requires CONTIGUOUS SUBARRAY.
*/