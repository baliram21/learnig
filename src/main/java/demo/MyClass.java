package demo;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MyClass {
    public static void main(String[] args) {

        String str = "accdeedf";
        Map.Entry<String, Long> stringLongEntry =
                Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(m -> m.getValue() > 1).findFirst().get();

        System.out.println(stringLongEntry.getKey());


    }
}
