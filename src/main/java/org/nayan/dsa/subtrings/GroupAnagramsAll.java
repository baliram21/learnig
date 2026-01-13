package org.nayan.dsa.subtrings;

import java.util.*;

public class GroupAnagramsAll {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        // Map: sorted string -> list of anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            // Convert word to char array and sort
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            // Use sorted string as key
            String key = new String(chars);

            // Add original word to its anagram group
            map.computeIfAbsent(key, k -> new ArrayList<>())
                    .add(word);
        }

        // Return grouped anagrams
        return new ArrayList<>(map.values());
    }
}
