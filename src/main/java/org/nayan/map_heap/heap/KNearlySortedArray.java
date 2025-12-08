package org.nayan.map_heap.heap;

import java.util.PriorityQueue;

public class KNearlySortedArray {

    public static void main(String[] args) {

        int[] arr = {2,3,1,4,6,7,5,8,9};
        int k = 3;

        // Min-Heap to store K+1 elements at a time
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Step 1: Insert first K+1 elements into heap
        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        // Step 2: For each remaining element:
        // - Remove smallest element from heap (correct sorted order)
        // - Add current element into heap
        for (int i = k + 1; i < arr.length; i++) {
            System.out.println(pq.remove());  // prints smallest
            pq.add(arr[i]);
        }

        // Step 3: Empty remaining elements from heap
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}


/*
────────────────────────────────────────────────────────────
                    TIME COMPLEXITY
────────────────────────────────────────────────────────────

1. Building initial heap of size K+1
      → O(K)

2. Processing remaining (N - K - 1) elements
      Each iteration does:
         - remove() → O(log K)
         - add()    → O(log K)
      So total: (N - K - 1) * O(log K)
               = O(N log K)

3. Emptying final K elements
      → K * O(log K)
      → O(K log K)

✔ Total Time Complexity =  O(N log K)


────────────────────────────────────────────────────────────
                    SPACE COMPLEXITY
────────────────────────────────────────────────────────────

• Min-Heap stores at most K+1 elements
      → O(K)

✔ Space Complexity = O(K)

────────────────────────────────────────────────────────────
*/
