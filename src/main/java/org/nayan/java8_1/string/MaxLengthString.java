package org.nayan.java8_1.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaxLengthString {
    public static void main(String[] args) {
        String[] str = {"lld", "abcde", "c", "av", "baaa"};

        Optional<String> max = Arrays.stream(str).max(String::compareTo);
        System.out.println(max.get());

        List<String> stringsAsc = Arrays.stream(str)
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());

        System.out.println(stringsAsc);

        String[] stringsDsc = Arrays.stream(str)
                .sorted(Comparator.comparing(String::length).reversed())
                .toArray(String[]::new);

        System.out.println(Arrays.toString(stringsDsc));

        String[] array = Arrays.stream(str).sorted(Comparator.reverseOrder()).toArray(String[]::new);
        System.out.println(Arrays.toString(array));

        String maxLenString = Arrays.stream(str).max(Comparator.comparing(String::length)).get();
        System.out.println(maxLenString);

        String maxLenStr = Arrays.stream(str)
                .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2).get();
        System.out.println(maxLenStr);


    }
}
