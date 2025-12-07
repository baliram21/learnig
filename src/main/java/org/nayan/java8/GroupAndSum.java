package org.nayan.java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAndSum {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        // Group and sum by parity
        Map<Boolean, Integer> paritySum = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0, Collectors.summingInt(Integer::intValue)));

        System.out.println("Even: " + paritySum.get(true));
        System.out.println("Odd: " + paritySum.get(false));
    }
}
