package org.nayan.twopointer;

import java.util.HashMap;
import java.util.Map;

public class CountAnagramOccurrences {

    public static int countAnagrams(String txt, String pat) {
        if (txt == null || pat == null || txt.length() < pat.length()) return 0;

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : pat.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int k = pat.length();  // window size
        int count = 0;         // number of valid anagrams found
        int distinct = freqMap.size(); // number of unique chars we must balance

        int left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>();

        while (right < txt.length()) {
            // Add current character to window
            char ch = txt.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // If this char's count matches frequency in pattern, decrease distinct
            if (freqMap.containsKey(ch) && window.get(ch).intValue() == freqMap.get(ch).intValue()) {
                distinct--;
            }

            // If window size is less than k, keep expanding
            if (right - left + 1 < k) {
                right++;
            } 
            else if (right - left + 1 == k) {
                // If all characters matched, it's an anagram
                if (distinct == 0) {
                    count++;
                }

                // Before sliding, remove the leftmost char
                char leftChar = txt.charAt(left);
                if (freqMap.containsKey(leftChar) && 
                    window.get(leftChar).intValue() == freqMap.get(leftChar).intValue()) {
                    distinct++;
                }

                window.put(leftChar, window.get(leftChar) - 1);
                if (window.get(leftChar) == 0) {
                    window.remove(leftChar);
                }

                left++;
                right++;
            }
        }

        return count;
    }

    // ---- Quick tests ----
    public static void main(String[] args) {
        System.out.println(countAnagrams("forxxorfxdofr", "for")); // 3
        System.out.println(countAnagrams("aabaabaa", "aaba"));     // 4
        System.out.println(countAnagrams("abcd", "xyz"));          // 0
        System.out.println(countAnagrams("kkkkkkk", "kkk"));       // 5
    }
}
/*🧠 Step-by-step Logic

Prepare frequency map of pattern characters.
Example for "for" → {f=1, o=1, r=1}

Use a sliding window of size k = pat.length() over txt.

Maintain a count of how many unique characters (distinct) still need to be matched.

Move the window:

Add character at right.

When window size == k, check if distinct == 0 → an anagram found.

Before sliding, remove character at left.

Continue until the end of txt.

⏱️ Time & Space Complexity

Time: O(n) → each character enters and leaves the window once.

Space: O(1) or O(26) if only lowercase letters (or O(charset) for general case).*/