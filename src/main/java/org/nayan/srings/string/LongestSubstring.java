package org.nayan.srings.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {
        String str = "abcabcdbb";

        String s = longestSubstring(str);
        System.out.println(s);
    }

    private static String longestSubstring(String str) {
        int left = 0;
        int maxLen = 0;
        int start = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }
            map.put(ch, right);

            int currentLent = right - left + 1;

            if (currentLent > maxLen) {
                maxLen = currentLent;
                start = left;
            }
        }

        return str.substring(start, start + maxLen);

    }

  /*  private static  void longestSubstring2(String str, int left, int right) {

        while (left < right) {
            if ()
        }

    }*/
}
