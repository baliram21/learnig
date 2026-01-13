package other.baliram.java8;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        String str = "zzzzhhhabbbbbbacccde";

        Map<Character, Integer> countMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, v -> 1, Integer::sum))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1).sorted((e1,e2)->e2.getValue()-e1.getValue())
                //.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))

                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));


        System.out.println(countMap);

    }
}
