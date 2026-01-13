package org.nayan.java8.common;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReverseWords {
    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog";

        // Reverse words
        String reversedSentence = Arrays.stream(sentence.split("\\s+"))
                .sorted((a, b) -> b.length() - a.length())
                .collect(Collectors.joining(" "));

        System.out.println(reversedSentence);

        Optional<String> reduce = Arrays.stream(sentence.split("\\s"))
                .reduce((a, b) -> b + " " + a);
        System.out.println(reduce.get());

        String str = "baliram";

        String s1 = str.chars().mapToObj(String::valueOf)
                .reduce((a, b) -> b + a).get();
        System.out.println(s1);

    }
}
