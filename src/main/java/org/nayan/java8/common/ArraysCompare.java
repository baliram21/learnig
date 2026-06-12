package org.nayan.java8.common;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArraysCompare {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 1, 3, 3, 4, 4, 4, 5};
        int[] arr2 = {1, 2, 1, 3, 3, 3, 4, 4, 5};

        // Convert arrays to Lists
        List<Integer> list1 = Arrays.stream(arr1).boxed().toList();
        List<Integer> list2 = Arrays.stream(arr2).boxed().toList();

        // Create frequency maps
        Map<Integer, Long> freqMap1 = list1.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Map<Integer, Long> freqMap2 = list2.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // Find differences
        freqMap1.forEach((key, value) -> {
            long count2 = freqMap2.getOrDefault(key, 0L);
            if (value != count2) {
                System.out.println(key + " appears " + value + " times in arr1 and " + count2 + " times in arr2.");
            }
        });

        freqMap2.forEach((key, value) -> {
            if (!freqMap1.containsKey(key)) {
                System.out.println(key + " appears " + value + " times in arr2 and 0 times in arr1.");
            }
        });
    }
}
