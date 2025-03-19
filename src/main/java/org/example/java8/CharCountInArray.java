package org.example.java8;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;

public class CharCountInArray {
    public static void main(String[] args) {
        String str = "aabbbccdeffggggg";

        // Count occurrences of each character using Java Streams
        Map<Character, Long> charCount = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Print the character counts
        charCount.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
