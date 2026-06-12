package org.nayan.java8_1.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VowelFilter {
    public static void main(String[] args) {

        List<String> words = Arrays.asList(
                "apple", "banana", "orange", "umbrella",
                "grapes", "elephant", "ice", "mango"
        );

        List<String> vowelWords = words.stream()
                .filter(word -> word != null && !word.isEmpty())
                .filter(word -> {
                    char ch = Character.toLowerCase(word.charAt(0));
                    return ch == 'a' || ch == 'e' || ch == 'i'
                            || ch == 'o' || ch == 'u';
                })
                .toList();

        System.out.println("Words starting with vowels: " + vowelWords);


        System.out.println("_________________________________");
        List<String> result = words.stream()
                .filter(s -> s.matches("(?i)^[aeiou].*"))
                .collect(Collectors.toList());

        System.out.println(result);


        List<String> vowelWordsByMethodRef = words.stream()
                .filter(VowelFilter::startsWithVowel)
                .toList();

        System.out.println("Words starting with vowels: " + vowelWordsByMethodRef);

      //  .filter(word -> startsWithVowel(word))   // lambda



    }

    private static boolean startsWithVowel(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        char ch = Character.toLowerCase(word.charAt(0));
        return ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u';
    }

}
