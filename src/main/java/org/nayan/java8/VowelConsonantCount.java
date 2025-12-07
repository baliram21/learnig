package org.nayan.java8;

public class VowelConsonantCount {
    public static void main(String[] args) {
        String str = "hello world";

        // Count vowels
        long vowelCount = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> "aeiouAEIOU".indexOf(c) != -1)
                .count();

        // Count consonants
        long consonantCount = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> Character.isAlphabetic(c) && "aeiouAEIOU".indexOf(c) == -1)
                .count();

        System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonants: " + consonantCount);
    }
}
