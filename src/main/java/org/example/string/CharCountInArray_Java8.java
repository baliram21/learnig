package org.example.string;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CharCountInArray_Java8 {
    public static void main(String[] args) {
        String str = "aabbbccdeffggggg";

        Stream<Character> characterStream = str.chars().mapToObj(c -> (char) c);

        Map<Character, List<Character>> collect = str.chars()
                .mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity()));
        System.out.println(collect);

        Map<Character, Long> charCount = str.chars()
                .mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(charCount);


    }
}
