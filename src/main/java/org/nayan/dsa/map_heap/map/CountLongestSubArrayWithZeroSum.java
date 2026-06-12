package org.nayan.dsa.map_heap.map;

import java.util.HashMap;
import java.util.Map;

public class CountLongestSubArrayWithZeroSum {

    public static int longestZeroSumSubarray(int[] arr) {

        Map<Integer, Integer> prefixIndexMap = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            // Case 1: prefix sum becomes 0
            if (prefixSum == 0) {
                maxLen = i + 1;
            }

            // Case 2: prefix sum seen before
            if (prefixIndexMap.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - prefixIndexMap.get(prefixSum));
            } 
            // Store first occurrence only
            else {
                prefixIndexMap.put(prefixSum, i);
            }
        }

        return maxLen;
    }

    // Driver
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        System.out.println(longestZeroSumSubarray(arr)); // 5
    }
    /*
    | Type  | Complexity |
| ----- | ---------- |
| Time  | **O(n)**   |
| Space | **O(n)**   |

    */
}