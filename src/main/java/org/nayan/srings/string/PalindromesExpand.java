package org.nayan.srings.string;

import java.util.ArrayList;
import java.util.List;

public class PalindromesExpand {

    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(getAllPalindromes(str));
    }

    public static List<String> getAllPalindromes(String s) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            // odd-length palindromes
            expand(s, i, i, result);

            // even-length palindromes
            expand(s, i, i + 1, result);
        }
        return result;
    }

    private static void expand(String s, int left, int right, List<String> result) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            result.add(s.substring(left, right + 1));
            left--;
            right++;
        }
    }
}
/*| Metric | Value                            |
| ------ | -------------------------------- |
| Time   | **O(n²)**                        |
| Space  | **O(1)** (excluding output list) |
Return unique palindromic substrings → use Set
*/