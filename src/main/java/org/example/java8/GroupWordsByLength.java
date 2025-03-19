package org.example.java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupWordsByLength {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry", "date", "egg", "fig", "grape");

        // Group words by their length
        Map<Integer, List<String>> groupedByLength = words.stream()
                .collect(Collectors.groupingBy(String::length));

        // Print the groups
        groupedByLength.forEach((length, group) -> {
            System.out.println("Length " + length + ": " + group);
        });
    }
}
