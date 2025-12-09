package org.nayan.srings;

import java.util.stream.Collectors;

public class RemoveSpaces {
    public static void main(String[] args) {
        String name= " j  av  a  ";

        removeSpaces(name);
        removeSpaces_java8(name);
        removeWithBlankOrisEmptyMethod(name);
       
    }
    private static String removeUsingRegex(String name) {
        // \s → matches ALL whitespace characters (space, tab, newline, etc.)
        return name.replaceAll("\\s+", "");  // replaces 1 or more whitespaces with nothing
    }

    private static String removeUsingReplaceAll(String name) {
        return name.replaceAll(" ", "");  // removes only normal spaces
    }


    private static void removeWithBlankOrisEmptyMethod(String name) {
        // Example: name = " j  av  a  ";

        String result = name.trim()                     // remove leading/trailing spaces
                .chars()                                // convert chars to IntStream
                .mapToObj(c -> (char) c)                // convert each int to char object
                .filter(ch -> !Character.isWhitespace(ch)) // remove blank/space characters
                .map(String::valueOf)                   // convert each char to string
                .collect(Collectors.joining());         // join as a single string

        System.out.println(result);                     // Output: "java"
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
