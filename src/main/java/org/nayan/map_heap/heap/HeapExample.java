package org.nayan.map_heap.heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapExample {
    public static void main(String[] args) {

        int[] ranks = {55,11,99,33,77,22,16, 13};

        System.out.println("Min-heap output:");
        defaultPQ(ranks);

        System.out.println("Max-heap output:");
        costomizePQ(ranks);

    }

    private static void costomizePQ(int[] ranks) {

        // Creates a PriorityQueue that uses reverse order comparator
        // This turns it into a max-heap for integers
        PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder());

        // Adds all elements of ranks into the priority queue
        for (int val : ranks){
            pq.add(val);         // Internally arranged as a max-heap
        }

        // Repeatedly prints and removes the largest element
        while (pq.size() > 0){
            System.out.println(pq.peek());   // Shows current largest element (root of heap)
            pq.remove();                     // Removes that largest element, heap re-adjusts
        }
    }


    private static void defaultPQ(int[] ranks) {

        // Creates a PriorityQueue with natural ordering (min-heap for integers)
        PriorityQueue pq = new PriorityQueue<>();

        // Adds all elements of ranks into the priority queue
        for (int val : ranks){
            pq.add(val);         // Internally arranged as a min-heap
        }

        // Repeatedly prints and removes the smallest element
        while (pq.size() > 0){
            System.out.println(pq.peek());   // Shows current smallest element (root of heap)
            pq.remove();                     // Removes that smallest element, heap re-adjusts
        }
    }

}
