package org.nayan.common;

import java.util.stream.IntStream;

public class PalindromeAllWays {

    public static void main(String[] args) {

        String str = "madam";

        System.out.println("Two Pointer: " + isPalindromeTwoPointer(str));
        System.out.println("Reverse: " + isPalindromeReverse(str));
        System.out.println("Recursion: " + isPalindromeRec(str, 0, str.length() - 1));
        System.out.println("Stream: " + isPalindromeStream(str));
        System.out.println("Clean + Palindrome: " + isPalindromeClean("A man, a plan, a canal: Panama"));
    }

    // 1. Two Pointer
    private static boolean isPalindromeTwoPointer(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }

    // 2. Reverse
    private static boolean isPalindromeReverse(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        return str.equals(rev);
    }

    // 3. Recursion
    private static boolean isPalindromeRec(String str, int left, int right) {
        if (left >= right) return true;
        if (str.charAt(left) != str.charAt(right)) return false;
        return isPalindromeRec(str, left + 1, right - 1);
    }

    // 4. Stream
    private static boolean isPalindromeStream(String str) {
        return IntStream.range(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));
    }

    // 5. Clean + Palindrome
    private static boolean isPalindromeClean(String str) {
        str = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }
}
