package org.nayan.dsa.subtrings;

import java.util.*;

public class FindAllAnagramsUsingMap {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        // Frequency map for pattern
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int matched = 0;              // Number of characters fully matched
        int required = freqMap.size(); // Unique characters in pattern

        // Sliding window
        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);

            // If char is part of pattern, reduce frequency
            if (freqMap.containsKey(rightChar)) {
                freqMap.put(rightChar, freqMap.get(rightChar) - 1);

                // Character frequency matched exactly
                if (freqMap.get(rightChar) == 0) {
                    matched++;
                }
            }

            // When window size equals pattern length
            if (right - left + 1 == p.length()) {

                // If all characters matched, record index
                if (matched == required) {
                    result.add(left);
                }

                // Remove left character from window
                char leftChar = s.charAt(left);
                if (freqMap.containsKey(leftChar)) {

                    if (freqMap.get(leftChar) == 0) {
                        matched--;   // A matched character is now unmatched
                    }

                    freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                }
                left++;
            }
        }

        return result;
    }
}
