package org.nayan.srings;

public class Palindromes {
    public static void main(String[] args) {
        // count all palindromic substrings
        String str = "aaa";
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {  // ✅ fix here
                if (isPalindrome(str, i, j)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }

    /*⏱ Complexity
Time: O(n³)
(n² substrings × O(n) palindrome check)
Space: O(n) recursion stack*/
}
