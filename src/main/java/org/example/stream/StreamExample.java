package org.example.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {

        List<Integer> list = List.of(5, 6, 2, 7, 3, 4, 1, 9);

        List<Integer> sortedAsc = list.stream().sorted().collect(Collectors.toList());
       // System.out.println(sortedAsc); // [1, 2, 3, 4, 5, 6, 7, 9]
        List<Integer> sortedAsc1 = list.stream().sorted(Integer::compareTo).toList();
                // sorted(Integer::compareTo)=sorted( (i1,i2)->i1.compareTo(i2) )

        List<Integer> sortedDesc1 = list.stream().sorted((e1,e2)->e2.compareTo(e1)).toList();

        List<Integer> sortedDesc2 = list.stream().sorted(Comparator.reverseOrder()).toList();
      //  System.out.println(sortedDesc1);

        Optional<Integer> max = list.stream().max(Integer::compareTo);

        Optional<Integer> max1 = list.stream().max(Integer::compareTo);
        System.out.println(max.get());

        Optional<Integer> min = list.stream().min((e1, e2) -> e1.compareTo(e2));

        Optional<Integer> min1 = list.stream().min(Integer::compareTo);
        System.out.println(min.get());
    }
}
