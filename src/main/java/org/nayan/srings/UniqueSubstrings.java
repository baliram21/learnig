package org.nayan.srings;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubstrings {

    public static void main(String[] args) {
        printUniqueSubstrings("abcd", 0, 0, new HashSet<>());
    }

    private static void printUniqueSubstrings(
            String str,
            int start,
            int end,
            Set<String> seen) {

        // base case
        if (start == str.length()) {
            return;
        }

        // move to next start index
        if (end == str.length()) {
            printUniqueSubstrings(str, start + 1, start + 1, seen);
            return;
        }

        String sub = str.substring(start, end + 1);

        // print only if unique
        if (seen.add(sub)) {
            System.out.println(sub);
        }

        // extend end
        printUniqueSubstrings(str, start, end + 1, seen);
    }
}
