package org.nayan.map_heap.heap;

import java.util.PriorityQueue;

public class ThreeHighestNumbers {
    public static void main(String[] args) {

        int[] ranks = {55, 11, 99, 33, 77, 22, 16, 13};
        int k = 3;

        /*
            Using a PriorityQueue as a Min-Heap (default behavior in Java)

            WHY MIN-HEAP?
            → We only need to keep the top K largest numbers.
            → Keep smallest among them on top so we can remove it easily when a larger element comes.

            TIME COMPLEXITY
            ------------------------------------------------
            - Inserting in heap = O(log K)
            - We process N numbers
            - For first K insertions: K * O(log K)
            - For remaining (N-K) items: Each check is O(1) and possible insertion+deletion is O(log K)

            Total Time Complexity = O(N log K)

            SPACE COMPLEXITY
            ------------------------------------------------
            PriorityQueue holds at most K elements → O(K) space
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Traverse all numbers
        for (int i = 0; i < ranks.length; i++) {

            // For first K elements: directly insert
            if (i < k) {
                pq.add(ranks[i]);  // O(log K)
            } else {

                /*
                    If current number is bigger than the smallest number in heap
                    → Remove smallest and insert current.
                    pq.peek() gives the smallest.

                    Why?
                    Because we maintain only the top K largest numbers.
                */
                if (ranks[i] > pq.peek()) {
                    pq.remove();       // Remove smallest → O(log K)
                    pq.add(ranks[i]);  // Insert new number → O(log K)
                }
            }
        }

        /*
            Now heap contains the top K (3) largest numbers.
            Removing them prints in ascending order.

            Removing K elements → O(K log K)
        */
        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }
}
