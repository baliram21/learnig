package org.nayan.java8.common;

import java.util.List;

public class MaxMinValues {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 3, 8, 1, 9, 7, 2, 6);

        // Find maximum value
        int maxValue = numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("List is empty"));

        // Find minimum value
        int minValue = numbers.stream()
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("List is empty"));

        System.out.println("Maximum value: " + maxValue); // Output: 9
        System.out.println("Minimum value: " + minValue); // Output: 1
    }
}
