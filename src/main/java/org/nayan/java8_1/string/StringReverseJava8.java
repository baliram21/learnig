package org.nayan.java8_1.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class StringReverseJava8 {
    public static void main(String[] args) {
        String name = "baliram";

        String reversed = new StringBuilder(name).reverse().toString();
        System.out.println(reversed);   // marilab

        String reversed1 = name.chars()
                .mapToObj(c -> String.valueOf((char)c))
                .reduce((c1, c2) -> c2 + c1)
                .orElse(""); // marilab


        String reversed2 = Arrays.stream(name.split(""))
                .reduce((a, b) -> b + a)
                .orElse(""); // marilab

        String revName = name.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .reduce("", (a, b) -> b + a); // marilab

        System.out.println("===========================================================");

        String sentence = "I love Java";

        String reversedw = Arrays.stream(sentence.split(" "))
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return String.join(" ", list);
                }));

        System.out.println(reversedw);   // Java love I


        //If interview asks reverse each word, not the order:
        String sentence1 = "I love Java";

        String result = Arrays.stream(sentence1.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));

        System.out.println(result); // I evol avaJ



    }

}
