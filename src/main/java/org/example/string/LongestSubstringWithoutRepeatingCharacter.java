package org.example.string;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String str = "abbabccd";

        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!map.containsKey(ch)){
                map.put(ch,i);
            }else {
                i = map.get(ch);
                map.clear();
            }
        }
        // List<Character> collect = map.keySet().stream().collect(Collectors.toList());
         List<Character> collect = new ArrayList<>(map.keySet());

        System.out.println(collect);
    }
}
