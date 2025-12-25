package org.nayan.common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountCharacter111 {
    public static void main(String[] args) {
        String str = "akabbcddeeem";



        String sb;
        StringBuilder sb1 = new StringBuilder();

        str.chars().distinct().forEach(s-> sb1.append((char) s));
        System.out.println(sb1.toString());

        sb = str.chars().distinct().mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println(sb);

        List<String> collect = Arrays.stream(str.split("")).distinct()
                .sorted().collect(Collectors.toList());
        System.out.println(collect);

       // StringBuilder sb1 = new StringBuilder();
        Arrays.stream(str.split("")).distinct().sorted(Comparator.reverseOrder()).toArray(String[]::new);
    }
}
