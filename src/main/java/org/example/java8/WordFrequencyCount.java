package org.example.java8;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Arrays;

public class WordFrequencyCount {
    public static void main(String[] args) {
        String sentence = "the quick brown fox jumps over the lazy dog the fox is quick";

        // Count occurrences of each word
        Map<String, Long> wordCount = Arrays.stream(sentence.split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        wordCount.forEach((word, count) -> System.out.println(word + " - " + count));
    }
}
