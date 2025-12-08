package org.nayan.java8.common;

import java.util.stream.Collectors;

public class UniqueCharacterExtraction {
    public static void main(String[] args) {
        String str = "aabbbcdd";

        // Extract unique characters
        String result = str.chars()
                .distinct()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(result); // Output: abcd
    }
}
