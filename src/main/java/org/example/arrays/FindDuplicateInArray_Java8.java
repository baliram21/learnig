package org.example.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateInArray_Java8 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 2, 4, 1, 1, 6, 7, 7, 4, 8, 9, 4, 4};

        // Step 1: Convert the int[] to a Stream<Integer>
        // Step 2: Group by each number and count the occurrences
        // Step 3: Filter out only the numbers with a count greater than 1 (duplicates)
        // Step 4: Collect and print the duplicate numbers

        List<Integer> duplicates = Arrays.stream(arr)
                .boxed()  // Convert from IntStream to Stream<Integer>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("Duplicate numbers in the array: " + duplicates);
    }
}
