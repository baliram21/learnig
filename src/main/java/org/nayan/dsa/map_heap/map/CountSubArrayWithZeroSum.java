package org.nayan.dsa.map_heap.map;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithZeroSum {

    public static void main(String[] args) {

        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        int sum = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        // Initial prefix sum = 0 occurs once
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            // If prefix sum already exists,
            // then subarrays with sum 0 are found
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }

            // Update frequency of current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println(count);
    }
}

/*
===============================
EXPLANATION
===============================

Problem:
---------
Count the TOTAL number of subarrays whose sum is 0.

Approach Used:
--------------
Prefix Sum + HashMap (Frequency Map)

Key Concept:
------------
If the same prefix sum appears multiple times,
then every pair of those occurrences forms a zero-sum subarray.

Mathematical Reason:
--------------------
Let:
prefixSum[i] = sum of elements from index 0 to i

If:
prefixSum[j] == prefixSum[i]  (j < i)

Then:
sum(j+1 ... i) = 0

Why HashMap?
------------
HashMap stores:
    key   -> prefix sum
    value -> number of times this sum has appeared so far

Why initialize map with (0,1)?
------------------------------
This handles subarrays that start from index 0.

Example:
---------
Array: [1, -1]

prefixSum at index 1 = 0
map already contains 0 → count should increase

Logic Flow:
-----------
1. Traverse array once.
2. Add current element to prefix sum.
3. If prefix sum already exists:
      add its frequency to count.
4. Increment frequency of prefix sum in map.

Example Walkthrough:
--------------------
Array:
    [15, -2, 2, -8, 1, 7, 10, 23]

Prefix sums:
    15, 13, 15, 7, 8, 15, 25, 48

Prefix sum 15 appears 3 times:
    indices 0, 2, 5

Number of zero-sum subarrays:
    C(3,2) = 3

Result:
-------
Total zero-sum subarrays = 3

Time Complexity:
----------------
O(n) → single pass

Space Complexity:
-----------------
O(n) → HashMap storage

Difference from "Longest Zero Sum Subarray":
--------------------------------------------
• This problem COUNTS all zero-sum subarrays
• Longest problem tracks maximum length
• Here we track FREQUENCY, not indices

Interview Tip:
--------------
If interviewer asks:
"Longest?" → store index
"Count?"   → store frequency
*/