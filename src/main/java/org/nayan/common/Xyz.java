package org.nayan.common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Xyz {
    public static void main(String[] args) {
        int[] nums = {5,2,6,2,8,9,16,11,1,15,16};

        Integer secondHighest = Arrays.stream(nums).boxed().distinct()
                .sorted(Comparator.reverseOrder()).skip(1)
                .findFirst().get();
       // System.out.println(secondHighest);

        List<String> stringList = Arrays.stream(nums).boxed().map(String::valueOf)
                .filter(e -> e.startsWith("1")).collect(Collectors.toList());
        System.out.println(stringList);

        List<Integer> intList = Arrays.stream(nums).boxed().map(String::valueOf)
                .filter(e -> e.startsWith("1")).map(Integer::valueOf)  //mapToInteger(Integer::valueOf)-> won't work here
                .collect(Collectors.toList());

        System.out.println(intList);
    }
}
