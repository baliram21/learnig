package org.nayan.twopointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

    public static String longestUniqueSubstring(String s) {
        if (s == null || s.isEmpty()) return "";

        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;           // Start of current window
        int maxLen = 0;         // Best window length so far
        int start = 0;          // Start index of best window

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If character is already seen and is within current window,
            // move left pointer to one position after last seen index
            if (lastSeen.containsKey(ch) && lastSeen.get(ch) >= left) {
                left = lastSeen.get(ch) + 1;
            }

            // Update last seen position of this character
            lastSeen.put(ch, right);

            // Update max length window if current is longer
            int windowLen = right - left + 1;
            if (windowLen > maxLen) {
                maxLen = windowLen;
                start = left;
            }
        }

        // Return the longest substring
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String[] inputs = {"abcabcbb", "bbbbb", "pwwkew", "", "abcdef", "abba"};
        
        for (String s : inputs) {
            String res = longestUniqueSubstring(s);
            System.out.println("Input: " + s + " -> " + res + " (len=" + res.length() + ")");
        }
    }
}

/*🧠 Explanation
Sliding Window:
Use two pointers — left (start of window) and right (end of window).
HashMap<Character, Integer>:
Stores the last index where each character was seen.
        Logic:
If the current character ch has appeared after or at the left boundary,
that means we have a duplicate — so we move left to lastSeen[ch] + 1.
Always update lastSeen[ch] = right.
Compute the current window length and update the max if larger.
Return longest substring.
⏱️ Complexity
Time: O(n) — each character is processed once.
        Space: O(min(n, alphabet)) — HashMap holds at most one entry per unique character.*/
