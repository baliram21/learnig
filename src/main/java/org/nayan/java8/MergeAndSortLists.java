package org.nayan.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeAndSortLists {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 3, 5, 7);
        List<Integer> list2 = List.of(2, 4, 6, 8);

        // Merge and sort lists
        List<Integer> mergedAndSorted = Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .collect(Collectors.toList());

        System.out.println(mergedAndSorted); // Output: [1, 2, 3, 4, 5, 6, 7, 8]
    }
}
