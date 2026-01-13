package other.baliram.map;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        int count = 0;
        int sum = 0;
        int i = -1;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(sum, 1);

        while (i < arr.length - 1) {
            i++;
            sum += arr[i];

            if (map.containsKey(sum)) {
                count += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
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

Key Insight:
------------
If the same prefix sum appears more than once,
then every pair of those occurrences forms a subarray with sum = 0.

Why Prefix Sum?
---------------
Prefix sum at index i = sum of elements from index 0 to i.
If:
    prefixSum(j) == prefixSum(i)   (j < i)
Then:
    sum(j+1 ... i) = 0

Why HashMap?
------------
The HashMap stores:
    key   -> prefix sum
    value -> number of times this prefix sum has occurred

Why map.put(0, 1)?
------------------
This handles subarrays that start from index 0.

Example:
---------
Array: [1, -1]
prefix sum becomes 0 at index 1
map already contains 0 → count increases by 1

Role of Variables:
------------------
count → stores total number of zero-sum subarrays
sum   → running prefix sum
i     → index pointer (starts from -1 for clean loop logic)
map   → tracks frequency of each prefix sum

Logic Flow:
-----------
1. Traverse array once.
2. Keep adding elements to prefix sum.
3. If prefix sum already exists:
      add its frequency to count.
4. Increase frequency of prefix sum in map.

Example Walkthrough:
--------------------
Array:
    [15, -2, 2, -8, 1, 7, 10, 23]

Prefix sums:
    15, 13, 15, 7, 8, 15, 25, 48

Prefix sum = 15 appears 3 times:
    indices 0, 2, 5

Number of zero-sum subarrays:
    C(3,2) = 3

Output:
-------
3

Time Complexity:
----------------
O(n) → single traversal

Space Complexity:
-----------------
O(n) → HashMap storage

Interview Tip:
--------------
For:
• Longest zero-sum subarray → store first index
• Count zero-sum subarrays → store frequency
*/
