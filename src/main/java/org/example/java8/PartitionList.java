package org.example.java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionList {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        // Partition list into even and odd numbers
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Even: " + partitioned.get(true)); // Output: [2, 4, 6, 8]
        System.out.println("Odd: " + partitioned.get(false)); // Output: [1, 3, 5, 7]
    }
}
