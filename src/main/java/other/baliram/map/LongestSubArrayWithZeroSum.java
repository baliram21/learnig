package other.baliram.map;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithZeroSum {
    public static void main(String[] args) {

        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        int maxLength = 0;
        int sum = 0;
        int i = -1;

        Map<Integer, Integer> map = new HashMap<>();

        map.put(sum, i);

        while (i < arr.length - 1) {
            i++;
            sum += arr[i];

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                int length = i - map.get(sum);
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }

        System.out.println(maxLength);
    }
}

/*
===============================
EXPLANATION
===============================

Problem:
---------
Find the LENGTH of the longest subarray whose sum is 0.

Approach Used:
--------------
Prefix Sum + HashMap

Key Concept:
------------
If the same prefix sum appears more than once, then the elements
between those two indices form a subarray with sum = 0.

Why prefix sum?
---------------
Prefix sum at index i = sum of elements from index 0 to i.
If:
    prefixSum(i) == prefixSum(j)
Then:
    sum(i+1 ... j) = 0

Why HashMap?
------------
HashMap stores:
    key   -> prefix sum
    value -> first index where this sum appeared
This allows O(1) lookup to find previous occurrences.

Why initialize:
----------------
    sum = 0
    i = -1
    map.put(0, -1)

This handles cases where a zero-sum subarray starts from index 0.
Example:
    [1, -1] → prefix sum becomes 0 at index 1
    Length = 1 - (-1) = 2

Logic Flow:
-----------
1. Traverse array once.
2. Keep adding elements to prefix sum.
3. If prefix sum is new → store index.
4. If prefix sum repeats → calculate subarray length.
5. Track maximum length.

Example Walkthrough:
--------------------
Array:
    [15, -2, 2, -8, 1, 7, 10, 23]

Prefix sums:
    15, 13, 15, 7, 8, 15, 25, 48

Prefix sum 15 repeats:
    first at index 0
    again at index 5
Subarray length:
    5 - 0 = 5

Result:
-------
Longest zero-sum subarray length = 5

Time Complexity:
----------------
O(n) → single traversal

Space Complexity:
-----------------
O(n) → HashMap storage

Interview Tip:
--------------
Always store only the FIRST occurrence of a prefix sum.
This ensures the longest possible subarray is captured.
*/
