package other.baliram.map;

import java.util.HashSet;
import java.util.Set;

public class LongestSubArrayWithContiguousElements {

    public static void main(String[] args) {

        int[] arr = {10, 12, 11, 14, 13, 15};

        int ans = 1; // at least one element is contiguous

        for (int i = 0; i < arr.length - 1; i++) {

            int min = arr[i];
            int max = arr[i];

            Set<Integer> set = new HashSet<>();
            set.add(arr[i]); // add starting element

            for (int j = i + 1; j < arr.length; j++) {

                // duplicate breaks contiguous property
                if (set.contains(arr[j])) {
                    break;
                }

                set.add(arr[j]);

                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);

                // ✅ FIXED condition
                if (max - min == j - i) {
                    int len = j - i + 1;
                    ans = Math.max(ans, len);
                }
            }
        }

        System.out.println("Max length - " + ans);
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

What was WRONG in original code?
--------------------------------

❌ 1) Wrong contiguous condition:
    You wrote:
        max - min == i - j

    But:
        i - j is NEGATIVE
        j - i is POSITIVE length difference

    Correct condition:
        max - min == j - i

--------------------------------

❌ 2) Length calculation was wrong:
    You wrote:
        len = i - j + 1

    Correct length:
        len = j - i + 1

--------------------------------

❌ 3) Starting element not added to set:
    Duplicate detection fails without:
        set.add(arr[i])

--------------------------------

Why the condition works?
------------------------
For a subarray from index i to j:

If elements are contiguous and unique:
    count of elements = j - i + 1
    range of values   = max - min + 1

So:
    max - min == j - i

--------------------------------

Example:
---------
Subarray: {10, 12, 11}
min = 10
max = 12

max - min = 2
j - i     = 2
→ contiguous ✔

--------------------------------

Example Walkthrough:
--------------------
Array:
    {10, 12, 11, 14, 13, 15}

Valid contiguous subarrays:
    {10,12,11}        → length 3
    {12,11,14,13}    → length 4

Answer:
-------
4

--------------------------------

Time Complexity:
----------------
O(n²)

Space Complexity:
-----------------
O(n) due to HashSet

--------------------------------

Interview Tip:
--------------
This is NOT "Longest Consecutive Sequence".
That problem ignores subarray boundaries.
Here, elements MUST be in a CONTIGUOUS subarray.
*/
