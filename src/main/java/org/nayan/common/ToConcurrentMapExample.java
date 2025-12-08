package org.nayan.common;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class ToConcurrentMapExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "apricot", "banana", "blueberry");

        // Parallel stream + toConcurrentMap (concurrent)
        ConcurrentMap<Character, String> concurrentMap = list
                .parallelStream()
                .collect(Collectors.toConcurrentMap(
                        s -> s.charAt(0),      // key mapper
                        String::toUpperCase,   // value mapper
                        (v1, v2) -> v1 + "|" + v2  // merge function on duplicate keys
                ));

        System.out.println("toConcurrentMap result class: " + concurrentMap.getClass().getName());
        System.out.println("toConcurrentMap result: " + concurrentMap);
    }
}
