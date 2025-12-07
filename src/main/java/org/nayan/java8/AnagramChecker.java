package org.nayan.java8;

import java.util.stream.Collectors;

public class AnagramChecker {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        // Check if the strings are anagrams
        boolean areAnagrams = str1.chars().sorted().boxed().collect(Collectors.toList())
                .equals(str2.chars().sorted().boxed().collect(Collectors.toList()));

        System.out.println("Are the strings anagrams? " + areAnagrams);
    }
}
