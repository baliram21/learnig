package org.nayan.srings.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharCountInArray_Java8 {
    public static void main(String[] args) {
        String str = "aabbbccdeffggggg";

        Stream<Character> characterStream = str.chars().mapToObj(c -> (char) c);

        Map<Character, List<Character>> collect = str.chars()
                .mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity()));
        System.out.println(collect);

        Map<Character, Long> charCount = str.chars()
                .mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(charCount);

        Stream<String> stringStream = str.chars().mapToObj(c -> String.valueOf((char) c));

        Character result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,   // 👈 preserves insertion order
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(result);

        String s = Arrays.stream(str.split(""))
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.joining());


//Cleaner + faster alternative 💡
        String ss = str.chars()
                .mapToObj(c -> (char) c)
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining());


        Map<String, Long> map1 = str.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        Map<String, Long> map = str.chars()
                .mapToObj(s1 -> String.valueOf((char) s1))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));




        Map.Entry<String, Long> max =
                map.entrySet().iterator().next();

        Map<String, Long> sortedMap1 = map.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
        /*❌ Problem

        Collectors.toMap() returns a HashMap
➡       ️ HashMap does NOT preserve sorting order
        So even though the stream is sorted, the result map may print in random order.*/
        Map<String, Long> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

       /* .sorted(
                Map.Entry.<Character, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry::getKey)
        )*/


        Map<Character, Integer> map2 = new LinkedHashMap<>();

        for (char c : str.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> e : map2.entrySet()) {
            if (e.getValue() == 1) {
                System.out.println(e.getKey());
                break;
            }
        }


        List<String> list = Arrays.asList("bk"," ", "ck", null, "dk", " ");

        list.stream()
                .filter(s2 -> s2 != null)
                //.filter(s -> s != " ")
                .forEach(System.out::print);
        list.stream()
                .filter(Objects::nonNull)
                .filter(s9 -> !s9.trim().isEmpty())
                .forEach(System.out::print);
        // ✅ Java 11+ BEST solution (cleanest) isBlank() removes " ", "\t", "\n" etc.
        list.stream()
                .filter(Objects::nonNull)
                .filter(k -> !k.isBlank())
                .forEach(System.out::print);

        List<String> result1 = list.stream()
                .filter(Objects::nonNull)
                .filter(s3 -> !s3.isBlank())
                .toList();

        System.out.println(result1);


/*| Case           | Correct way        |
| -------------- | ------------------ |
| Null check     | `Objects::nonNull` |
| Empty string   | `!s.isEmpty()`     |
| Blank string   | `!s.isBlank()`     |
| String compare | `equals()`         |
*/

    }
}
