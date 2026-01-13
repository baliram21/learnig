package org.nayan.dsa.subtrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams1(s, p));
    }

    private static List<Integer> findAnagrams1(String s, String p) {
        int ns = s.length();
        int np = p.length();

        List<Integer> ans = new ArrayList<>();
        if (np > ns) {
            return ans; // ✅ return empty list
        }

        int[] pref = new int[26];
        int[] sliding = new int[26];

        // frequency of p
        for (char c : p.toCharArray()) {
            pref[c - 'a']++;
        }

        // first window
        for (char c : s.substring(0, np).toCharArray()) {
            sliding[c - 'a']++;
        }

        if (Arrays.equals(pref, sliding)) {
            ans.add(0);
        }

        // slide the window
        for (int i = 1; i <= ns - np; i++) { // ✅ fixed condition
            sliding[s.charAt(i - 1) - 'a']--;
            sliding[s.charAt(i + np - 1) - 'a']++;

            if (Arrays.equals(pref, sliding)) {
                ans.add(i);
            }
        }

        return ans;
    }
}
