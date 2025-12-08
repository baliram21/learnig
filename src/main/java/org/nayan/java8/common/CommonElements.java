package org.nayan.java8.common;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonElements {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(3, 4, 5, 6, 7);

        // Find common elements
        Set<Integer> commonElements = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toSet());

        System.out.println(commonElements); // Output: [3, 4, 5]
    }
}
