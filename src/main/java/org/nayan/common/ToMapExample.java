package org.nayan.common;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class ToMapExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "date");

        // Parallel stream + toMap (non-concurrent)
        Map<Character, String> map = list
                .parallelStream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0),     // key mapper
                        s -> s.toUpperCase(), // value mapper
                        (v1, v2) -> v1        // merge function on duplicate keys
                ));

        System.out.println("toMap result class: " + map.getClass().getName());
        System.out.println("toMap result: " + map);
    }
}
