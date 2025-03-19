package org.example.java8;

import java.util.Arrays;
import java.util.Comparator;

public class LongestWord {
    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog";

        // Find the longest word
        String longestWord = Arrays.stream(sentence.split("\\s+"))
                .max(Comparator.comparingInt(String::length))
                .orElse("");

        System.out.println("Longest word: " + longestWord);
    }
}
