package org.nayan.srings;

import java.util.stream.Collectors;

public class RemoveSpecialChar {
    public static void main(String[] args) {
        String name = "@j&a*v$a";  // Expected output: java

        rmoveSpecialChar(name);
        rmoveSpecialChar_java8(name);


    }

    private static void rmoveSpecialChar_java8(String name) {

        // Using Java 8 Streams to filter out special characters
        String cleanedStr = name.chars()  // Convert string to IntStream
                .filter(Character::isLetterOrDigit) // Keep only letters and digits
                .mapToObj(c -> String.valueOf((char) c)) // Convert back to String
                .collect(Collectors.joining()); // Join characters to form final string

        System.out.println(cleanedStr);
    }

    private static void rmoveSpecialChar(String name) {

        // Removing all special characters except alphanumeric
        String cleanedStr = name.replaceAll("[^a-zA-Z0-9]", "");

        System.out.println(cleanedStr);  // Output: java
    }
}
