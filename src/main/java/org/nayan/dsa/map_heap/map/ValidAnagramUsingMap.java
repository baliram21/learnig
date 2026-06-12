package org.nayan.dsa.map_heap.map;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagramUsingMap {

    public static void main(String[] args) {

        String s1 = "listen";
        String s2 = "silent";

        System.out.println(isAnagram(s1, s2));
    }

    public static boolean isAnagram(String s1, String s2) {

        // If lengths differ → not anagram
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        // Count frequency of characters in s1
        for (char ch : s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Reduce frequency using s2
        for (char ch : s2.toCharArray()) {

            if (!map.containsKey(ch)) {
                return false;
            }

            map.put(ch, map.get(ch) - 1);

            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }

        // If map is empty → valid anagram
        return map.isEmpty();
    }
}

/*
===============================
EXPLANATION
===============================

Problem:
---------
Check whether two strings are anagrams.

Definition:
-----------
Two strings are anagrams if:
• They contain the same characters
• With the same frequency
• Order does NOT matter

Approach:
---------
1. If lengths are different → immediately return false.
2. Use HashMap to count frequency of characters in first string.
3. Traverse second string:
   - Reduce frequency
   - If character not found → return false
4. If map becomes empty → valid anagram

Why map.isEmpty()?
------------------
If all frequencies cancel out,
the map will have no entries left.

Example:
---------
s1 = "listen"
s2 = "silent"

Map after s1:
l=1, i=1, s=1, t=1, e=1, n=1

After processing s2:
All become 0 and removed.

Result:
-------
true

Time Complexity:
----------------
O(n)

Space Complexity:
-----------------
O(1)  (At most 26 letters for lowercase English)

Interview Tip:
--------------
If only lowercase letters are allowed,
you can use int[26] instead of HashMap
for faster performance.
*/