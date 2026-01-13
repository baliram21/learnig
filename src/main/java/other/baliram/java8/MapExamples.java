package other.baliram.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapExamples {

    public static void main(String[] args) {

        String str = "zzzzhhhabbbbbbacccde";

        Map<Character, Integer> countMap =
                str.chars()
                   .mapToObj(c -> (char) c)
                   .collect(Collectors.toMap(
                           c -> c,
                           v -> 1,
                           Integer::sum
                   ))
                   .entrySet()
                   .stream()
                   .filter(e -> e.getValue() > 1)
                   .sorted(
                           Map.Entry.<Character, Integer>comparingByValue(Comparator.reverseOrder())
                                    .thenComparing(
                                            Map.Entry.comparingByKey(Comparator.reverseOrder())
                                    )
                   )
                   .collect(Collectors.toMap(
                           Map.Entry::getKey,
                           Map.Entry::getValue,
                           (a, b) -> a,
                           LinkedHashMap::new   // 🔥 preserves order
                   ));

        System.out.println(countMap);

        Map<Character, Integer> freq = new HashMap<>();

        for (char c : str.toCharArray()) {
            freq.merge(c, 1, Integer::sum);
        }

    }
}
