package org.example.java8;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Comparator;

public class CharCountInArray1 {
    public static void main(String[] args) {
        String str = "aabbbccdeffggggg";

        // Count occurrences of each character using Java Streams
        Map<Character, Long> charCount = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Print the counts in ascending order of characters
        charCount.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }
}
