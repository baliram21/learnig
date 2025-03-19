package org.example.java8;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;

public class DigitFrequency {
    public static void main(String[] args) {
        String str = "a1b2c3d4e5f1g2h3i4j5";

        // Count occurrences of each digit
        Map<Character, Long> digitCount = str.chars()
                .filter(Character::isDigit)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Print the digit counts
        digitCount.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
