package org.nayan.dsa.subtrings;

import java.util.HashMap;
import java.util.Map;

public class CountSubstringWithoutRepeat_Map {

    public static void main(String[] args) {
        String s = "aba";
        System.out.println("Count: " + countSubstrings(s));
    }

    public static int countSubstrings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        // Map to store last seen index of characters
        Map<Character, Integer> lastSeen = new HashMap<>();

        int left = 0;      // Start of sliding window
        int count = 0;     // Total valid substrings

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);

            // If character already seen and inside current window
            if (lastSeen.containsKey(current) && lastSeen.get(current) >= left) {
                // Move left pointer past the previous occurrence
                left = lastSeen.get(current) + 1;
            }

            // Update last seen index
            lastSeen.put(current, right);

            // Count substrings ending at 'right'
            count += (right - left + 1);
        }

        return count;
    }
}
