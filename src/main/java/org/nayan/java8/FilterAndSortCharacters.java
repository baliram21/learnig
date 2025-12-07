package org.nayan.java8;

import java.util.stream.Collectors;

public class FilterAndSortCharacters {
    public static void main(String[] args) {
        String str = "a1b2c3d4e5";

        // Filter and sort characters
        String result = str.chars()
                .filter(Character::isAlphabetic)
                .mapToObj(c -> (char) c)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(result); // Output: abcde
    }
}
