package org.nayan.twopointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKUnique {

    public static String longestSubstringWithKUnique(String s, int k) {
        // Edge cases
        if (s == null || s.isEmpty() || k == 0) return "";

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        int maxStart = 0;

        // Expand the window with right pointer
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // Add current char to map (increase count)
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // If we have more than k distinct characters, shrink window from left
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                // Remove from map if count becomes zero
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++; // shrink window
            }

            // If exactly k distinct characters, update max window length
            if (map.size() == k) {
                int currentLen = right - left + 1;
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    maxStart = left;
                }
            }
        }

        // Return the longest substring found
        return s.substring(maxStart, maxStart + maxLen);
    }

    // ---- Test the function ----
    public static void main(String[] args) {
        String[] inputs = {"araaci", "araaci", "cbbebi", "aa", "abcdef"};
        int[] ks = {2, 1, 3, 1, 10};

        for (int i = 0; i < inputs.length; i++) {
            String s = inputs[i];
            int k = ks[i];
            String result = longestSubstringWithKUnique(s, k);
            System.out.println("Input: " + s + ", k=" + k + " -> " + result + " (len=" + result.length() + ")");
        }
    }
}


/*💡 Explanation (step-by-step)
Sliding Window:
Use two pointers (left, right) to define a window that moves through the string.
HashMap<Character, Integer>:
Keeps track of each character’s count in the current window.
Expand window:
Move right forward, adding characters to the map.
Shrink window:
If the map has more than k unique chars, move left rightward and decrease counts until you return to k.
Track max window:
When the map has exactly k unique chars, calculate window length and update maxLen if it’s larger.
Return result:
Use substring(maxStart, maxStart + maxLen) to return the actual substring.
⏱️ Time & Space Complexity
Time: O(n) — each character is visited at most twice (enter + exit the window).
Space: O(k) — at most k characters stored in the map.*/
