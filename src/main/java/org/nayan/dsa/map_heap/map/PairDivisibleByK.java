package org.nayan.dsa.map_heap.map;

import java.util.HashMap;
import java.util.Map;

public class PairDivisibleByK {

    public static boolean canArrange(int[] arr, int k) {

        // If array length is odd, pairing is impossible
        if (arr.length % 2 != 0) {
            return false;
        }

        Map<Integer, Integer> remainderFreq = new HashMap<>();

        // Step 1: Count remainders
        for (int num : arr) {
            int rem = ((num % k) + k) % k; // handles negative numbers
            remainderFreq.put(rem, remainderFreq.getOrDefault(rem, 0) + 1);
        }

        // Step 2: Validate pairing rules
        for (int rem : remainderFreq.keySet()) {

            // Case 1: remainder 0 → even count
            if (rem == 0) {
                if (remainderFreq.get(rem) % 2 != 0) {
                    return false;
                }
            }
            // Case 2: remainder k/2 when k is even → even count
            else if (k % 2 == 0 && rem == k / 2) {
                if (remainderFreq.get(rem) % 2 != 0) {
                    return false;
                }
            }
            // Case 3: rem pairs with k-rem
            else {
                int other = k - rem;
                if (remainderFreq.get(rem) != remainderFreq.getOrDefault(other, 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {9, 5, 7, 3};
        int k = 6;

        System.out.println(canArrange(arr, k)); // true
    }

    /*| Type  | Complexity |
| ----- | ---------- |
| Time  | **O(n)**   |
| Space | **O(k)**   |

arr = [9, 5, 7, 3]
k = 6
remainders = [3, 5, 1, 3]
Pairs:
3 + 3 = 6 ✔
5 + 1 = 6 ✔*/
}