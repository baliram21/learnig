package org.nayan.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public class PangramChecker {

    // Fast and memory-efficient: use boolean[26]
    public static boolean isPangram(String input) {
        if (input == null) return false;

        boolean[] seen = new boolean[26]; // one slot per letter a..z
        int count = 0;

        // normalize to lower-case to treat 'A' and 'a' same
        for (char ch : input.toLowerCase(Locale.ROOT).toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                int idx = ch - 'a';
                if (!seen[idx]) {        // first time seeing this letter
                    seen[idx] = true;
                    count++;
                    if (count == 26) return true; // early exit when all found
                }
            }
        }
        return count == 26;
    }

    // Alternative: use a Set (clear and expressive, slightly higher overhead)
    public static boolean isPangramUsingSet(String input) {
        if (input == null) return false;

        Set<Character> letters = input.toLowerCase(Locale.ROOT).chars()
                .filter(ch -> ch >= 'a' && ch <= 'z')
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toCollection(HashSet::new));

        return letters.size() == 26;
    }

    // Quick test with sample sentences
    public static void main(String[] args) {
        String[] tests = {
                "The quick brown fox jumps over the lazy dog", // classic pangram
                "Sphinx of black quartz, judge my vow",         // another pangram
                "Hello World",                                  // not a pangram
                "Pack my box with five dozen liquor jugs",      // pangram
                null
        };

        for (String t : tests) {
            System.out.println("Input: " + t);
            System.out.println("isPangram (array method): " + isPangram(t));
            System.out.println("isPangram (set method):   " + isPangramUsingSet(t));
            System.out.println("----");
        }
    }
}
