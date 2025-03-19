package org.example.java8;

import java.util.List;
import java.util.stream.Collectors;

public class TransformAndCollect {
    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "cherry");

        // Transform and collect to uppercase
        List<String> uppercaseStrings = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(uppercaseStrings); // Output: [APPLE, BANANA, CHERRY]
    }
}
