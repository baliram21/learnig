package org.nayan.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapExample {
    public static void main(String[] args) {

        String str = "aaabbzzckkzzkkykkcdeee";

        // just examples — these streams are not used later but left for illustration
        IntStream chars = str.chars();
        Stream<Character> characterStream = str.chars().mapToObj(c -> (char) c);
        Stream<String> stringStream = str.chars().mapToObj(s -> String.valueOf(s));
        Stream<String> stringStream1 = str.chars().mapToObj(String::valueOf);

        // Count occurrences of each character
        Map<Character, Long> map = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("counts: " + map);

        // safer max: use Optional to avoid NoSuchElementException for empty inputs
        Optional<Map.Entry<Character, Long>> maxEntry = map.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        if (maxEntry.isPresent()) {
            Character maxChar = maxEntry.get().getKey();
            System.out.println("Maximum occurring Character - " + maxChar);
            System.out.println("Entry: " + maxEntry.get());
        } else {
            System.out.println("Input string is empty or no characters found.");
        }

        // Sort by value ascending and collect into LinkedHashMap to preserve the sorted order
        Map<Character, Long> sortedByValueAsc = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new // preserve insertion order which equals sorted order
                ));
        System.out.println("Sorted by value (asc): " + sortedByValueAsc);

        // Get entries sorted by value descending as a List
        List<Map.Entry<Character, Long>> descChar = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println("Sorted by value (desc) as list: " + descChar);

        // Sort by key (character) and collect into LinkedHashMap to preserve key order
        Map<Character, Long> sortedByKey = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println("Sorted by key: " + sortedByKey);
    }
}
