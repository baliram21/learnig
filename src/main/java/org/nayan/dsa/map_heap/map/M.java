package org.nayan.dsa.map_heap.map;

import java.util.HashMap;
import java.util.Map;

public class M {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 2, 2, 2, 2, 3, 3, 4};
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : arr1){
        map.put(num, map.getOrDefault(num,0)+1);
        }
        System.out.println("map with getDefault "+map);

        for (int i = 0; i < arr1.length; i++) {
            int num = arr1[i];

            // If key exists → increase count
            if (map1.containsKey(num)) {
                Integer val = map1.get(num);
                map1.put(num, val + 1);
            }
            // If key not exists → insert with count = 1
            else {
                map1.put(num, 1);
            }
        }
        System.out.println("by loop "+map1);


    }
}
