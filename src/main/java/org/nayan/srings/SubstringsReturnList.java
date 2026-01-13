package org.nayan.srings;

import java.util.ArrayList;
import java.util.List;

public class SubstringsReturnList {

    public static void main(String[] args) {
        List<String> result = getSubstrings("abcd", 0, 0, new ArrayList<>());
        System.out.println(result);
    }

    private static List<String> getSubstrings(
            String str,
            int start,
            int end,
            List<String> result) {

        // base condition
        if (start == str.length()) {
            return result;
        }

        // move to next start index
        if (end == str.length()) {
            return getSubstrings(str, start + 1, start + 1, result);
        }

        // add current substring
        result.add(str.substring(start, end + 1));

        // extend end
        return getSubstrings(str, start, end + 1, result);
    }
}
