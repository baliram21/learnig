package org.nayan.java8.common;

import java.util.List;
import java.util.stream.Collectors;

public class FilterPalindromes {
    public static void main(String[] args) {
        List<String> words = List.of("racecar", "apple", "radar", "banana", "level");

        // Filter palindromic words
        List<String> palindromes = words.stream()
                .filter(word -> new StringBuilder(word).reverse().toString().equals(word))
                .collect(Collectors.toList());

        System.out.println("Palindromes: " + palindromes);
    }
}
