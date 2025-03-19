package org.example.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CharCountInArray {
    public static void main(String[] args) {
        String str = "aabbzzzzhhbccdeffggggg"; // Count each character
        Map<Character, Integer> map = new HashMap<>();

        // Count occurrences of each character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Create a list from the entries of the map
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());

        // Sort the list based on keys (characters) in ascending order
        Collections.sort(entryList, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });

        // Print the sorted entries
        for (Map.Entry<Character, Integer> entry : entryList) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
