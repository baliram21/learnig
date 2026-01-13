package org.nayan.dsa.subtrings;

import java.util.HashMap;
import java.util.Map;

public class CountSubstringAtMostKUnique {

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;

        System.out.println("Count: " + countAtMostK(s, k));
    }

    public static int countAtMostK(String s, int k) {

        // Edge case
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        // Map to store frequency of characters in window
        Map<Character, Integer> freqMap = new HashMap<>();

        int left = 0;     // Left pointer of window
        int count = 0;    // Total valid substrings

        // Expand window using right pointer
        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);

            // Add character to map
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);

            // Shrink window until unique characters <= k
            while (freqMap.size() > k) {

                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);

                // Remove character if frequency becomes zero
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }

                left++; // Move window start
            }

            // All substrings ending at 'right' are valid
            count += (right - left + 1);
        }

        return count;
    }
}
