package other.baliram.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Abc {
    public static void main(String[] args) {
        String str = "zzzzhhhabacccde";

        Map<Character, Integer> collect = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, v -> 1, Integer::sum))
                .entrySet().stream().filter(e->e.getValue()>1)
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(e -> e.getKey(), e->e.getValue()));
                //.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        String sent= "aa bbb cc aa dd eee dd";

        Map<String, Integer> collect1 = Arrays.stream(sent.split(" "))
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        System.out.println(collect1);


        Map<Character, Integer> countMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, v -> 1, (e1,e2)->e1));



        System.out.println(countMap);
/*------------------------------------------------------------------------------------*/
        System.out.println(collect);  List<Integer> list = List.of(4,5,6,5,6,3,4,9);
        /*Map<Integer, Integer> integerMap = list.stream().collect(Collectors.toMap(e -> e, e -> e));
        System.out.println(integerMap);*/

        Map<Integer, Integer> map =
                list.stream()
                        .collect(Collectors.toMap(
                                e -> e,
                                e -> 1,
                                Integer::sum
                        ));

        System.out.println(map);

    }
}
