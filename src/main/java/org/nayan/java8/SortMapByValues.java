package org.nayan.java8;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

public class SortMapByValues {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 2);
        map.put("b", 3);
        map.put("c", 2);
        map.put("d", 1);
        map.put("e", 1);
        map.put("f", 2);
        map.put("g", 5);

        // Sort map by values in descending order
        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        java.util.LinkedHashMap::new
                ));

        // Print the sorted entries
        sortedMap.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
