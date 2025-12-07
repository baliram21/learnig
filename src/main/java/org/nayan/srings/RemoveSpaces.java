package org.nayan.srings;

import java.util.stream.Collectors;

public class RemoveSpaces {
    public static void main(String[] args) {
        String name= " j  av  a  ";

        removeSpaces(name);
        removeSpaces_java8(name);
       
    }
    private static void removeSpaces_java8(String name) {
        // Using Java 8 Stream to remove spaces
        String str = name.trim() //.trim(): Removes leading and trailing spaces.
                .chars()  // Convert to IntStream
                .filter(ch -> ch != ' ')  // Remove spaces
                .mapToObj(c -> String.valueOf((char) c)) // Convert back to String
                .collect(Collectors.joining()); // Join characters into a string

        System.out.println("String after removing spaces - " + str);
    }
    private static void removeSpaces(String name) {
        String str = name.trim().replaceAll("\\s", "");

        System.out.println("String after removing space - "+str);
    }
}
