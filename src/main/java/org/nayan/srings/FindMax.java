package org.nayan.srings;

import java.util.*;
import java.util.stream.Collectors;

public class FindMax {
    public static void main(String[] args) {
        String string = "abc_33 xyz_55 pqr_55 abc_30"; // find max string

        String[] arrayStr = string.split(" ");

        Map<String, Integer> collect = Arrays.stream(arrayStr)
                .map(s -> s.split("_"))
                .collect(Collectors.toMap(e -> e[0], e -> Integer.parseInt(e[1]), Integer::sum));
        System.out.println(collect);

        Map<String, Integer> map = new HashMap<>();

        for (String str : arrayStr){
            String[] s = str.split("_");
            String s1 = s[0];
            int num = Integer.parseInt(s[1]);
            map.put(s1, map.getOrDefault(s1, 0)+num);
        }
        System.out.println(map);
        int maxCount = 0;
        String maxString = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if (entry.getValue() > maxCount){
            maxCount = entry.getValue();
            maxString = entry.getKey();
            }
        }
        System.out.println(maxCount);

        Map.Entry<String, Integer> stringIntegerEntry = map
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();


        System.out.println(stringIntegerEntry);


    }
}
