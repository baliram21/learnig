package org.nayan.dsa.subtrings;

import java.util.*;

public class GroupAnagramsOptimized {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            int[] freq = new int[26];

            // Count character frequency
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            // Build key from frequency array
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : freq) {
                keyBuilder.append('#').append(count);
            }

            String key = keyBuilder.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>())
               .add(word);
        }

        return new ArrayList<>(map.values());
    }
}
