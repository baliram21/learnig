package org.nayan.srings;

public class SubstringsRecursive {

    public static void main(String[] args) {
        String str = "abcd";
        printSubstrings(str, 0);
    }

    // Controls starting index
    private static void printSubstrings(String str, int start) {
        if (start == str.length()) {
            return;
        }
        printFromStart(str, start, start + 1);
        printSubstrings(str, start + 1);
    }

    // Prints substrings for a fixed start index
    private static void printFromStart(String str, int start, int end) {
        if (end > str.length()) {
            return;
        }
        System.out.println(str.substring(start, end));
        printFromStart(str, start, end + 1);
    }
}
