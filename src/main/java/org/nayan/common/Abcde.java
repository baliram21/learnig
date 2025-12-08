package org.nayan.common;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Abcde {
    public static void main(String[] args) {
        String str = "aaabbckkkkkkcdeee";

       // countChar(str);
       // countCharJava8(str);
       // countCharAndArrangeJava8(str);
        maxOccurringChar(str);
       // removeDuplicate(str);
       // sorting(str);
    }

    private static void sorting(String str) {
        Map<String, Long> map = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    private static void removeDuplicate(String str) {
        //String str = "aaabbckkkkkkcdeee";
        Arrays.stream(str.split("")).distinct().forEach(System.out::print);
        StringBuilder sb = new StringBuilder();
        System.out.println();
        str.chars().mapToObj(e->(char)e).distinct().forEach(sb::append);
        //str.chars().boxed().distinct().forEach(sb::append);
        System.out.println(sb.toString());

        System.out.println("____________________________________________");
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = str.indexOf(c, i+1);

            if (index==-1){
                sb1.append(c);
            }
        }
        System.out.println(sb1);
    }

    private static void maxOccurringChar(String str) {

        //String str = "aaabbckkkkkkcdeee";
        Map.Entry<String, Long> stringLongEntry = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(stringLongEntry);
    }
    private static void maxOccurringChar1(String str) {

        Character result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)   // ✅ extract only the character
                .orElse(null);

        System.out.println(result);
    }


    private static void countCharAndArrangeJava8(String str) {

        Map<String, Long> map = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        List<Map.Entry<String, Long>> entryList = map.entrySet().stream()
                .sorted(Comparator.comparing(m -> m.getValue())).collect(Collectors.toList());
        System.out.println(entryList);
        System.out.println("------------------------------");

        StringBuilder sb = new StringBuilder();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e->sb.append(e.getKey()));

        System.out.println(sb.toString());
        System.out.println("++++++++++++++++++++++++++++++++");

        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(e-> System.out.print(e.getKey()));

        System.out.println("______________________________________");
        List<Map.Entry<String, Long>> entryList1 = map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toList());
        System.out.println(entryList1);

        System.out.println("______________________________________________");

        Map<String, Long> sortedByValue = map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        System.out.println(sortedByValue);
    }

    private static void countCharJava8(String str) {
        char[] charStr = str.toCharArray();
        String[] splitStr = str.split("");

       /* Arrays.stream(charStr);
        Arrays.stream(splitStr);*/

        Map<String, Long> map1 = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));

        System.out.println(map1);

        Map<String, Long> map2 = Arrays.stream(splitStr).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(map2);

        List<Map.Entry<String, Long>> collect = map2.entrySet().stream().filter(e -> e.getValue() > 1).collect(Collectors.toList());
        System.out.println(collect);

        List<String> dupStr = map2.entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(dupStr);

        List<String> stringList = map2.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue()))
                .map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(stringList);
    }

    private static void countChar(String str) {

        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            Integer count = map.get(c);
            if (count==null){
                map.put(c,1);
            }else {
                map.put(c,count+1);
            }
        }
        System.out.println(map);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+ " occurs "+ entry.getValue()+" times");
        }
        System.out.println("----------sorting according to occurannce-----------");

         List<Map.Entry<Character,Integer>> entryList = new ArrayList<>(map.entrySet());

        Collections.sort(entryList, ((o1, o2) -> o1.getValue()-o2.getValue()));

         /*Collections.sort(entryList, ((o1, o2) -> o2.getValue()-o1.getValue()));*/

        /*Collections.sort(entryList, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });*/
        System.out.println(entryList);


    }

}
