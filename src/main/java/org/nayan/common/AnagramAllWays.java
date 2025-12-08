package org.nayan.common;

import java.util.*;

public class AnagramAllWays {

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        System.out.println("Sort : " + isAnagramSort(s1, s2));
        System.out.println("Count: " + isAnagramCount(s1, s2));
        System.out.println("Map  : " + isAnagramMap(s1, s2));
        System.out.println("Stream: " + isAnagramStream(s1, s2));
        System.out.println("One-Liner: " + isAnagramOneLiner(s1, s2));
    }

    // 1. Using Sorting
    private static boolean isAnagramSort(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    // 2. Count (Best)
    private static boolean isAnagramCount(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] count = new int[256];
        for (char c : s1.toCharArray()) count[c]++;
        for (char c : s2.toCharArray()) count[c]--;
        for (int x : count) if (x != 0) return false;
        return true;
    }

    // 3. HashMap
    private static boolean isAnagramMap(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : s2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) return false;
        }
        return map.values().stream().allMatch(v -> v == 0);
    }

    // 4. Stream
    private static boolean isAnagramStream(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return s1.chars().sorted().boxed().toList()
                .equals(s2.chars().sorted().boxed().toList());
    }

    // 5. One-Liner
    private static boolean isAnagramOneLiner(String s1, String s2) {
        return Arrays.equals(
                s1.chars().sorted().toArray(),
                s2.chars().sorted().toArray()
        );
    }
}
