package org.nayan.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementLengthBy2 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2, 3,3,3,3,3};
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int len = arr.length;
        List<Integer> list = new ArrayList<>();
        System.out.println(map);

        int element = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() >= len / 2) {
                list.add(entry.getKey());
              //  element = entry.getKey();
            }
        }
        System.out.println(list);
        System.out.println(element);
    }
}
