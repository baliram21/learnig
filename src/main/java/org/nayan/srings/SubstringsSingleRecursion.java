package org.nayan.srings;

public class SubstringsSingleRecursion {

    public static void main(String[] args) {
        printSubstrings("abcd", 0, 0);
    }

    private static void printSubstrings(String str, int start, int end) {

        // base condition
        if (start == str.length()) {
            return;
        }

        // when end reaches beyond length, move start forward
        if (end == str.length()) {
            printSubstrings(str, start + 1, start + 1);
            return;
        }

        // print current substring
        System.out.println(str.substring(start, end + 1));

        // extend end
        printSubstrings(str, start, end + 1);
    }
}
