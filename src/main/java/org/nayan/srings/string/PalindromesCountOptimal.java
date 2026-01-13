package org.nayan.srings.string;

public class PalindromesCountOptimal {

    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(countPalindromes(str));
    }

    public static int countPalindromes(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            // odd-length palindromes
            count += expand(str, i, i);

            // even-length palindromes
            count += expand(str, i, i + 1);
        }
        return count;
    }

    private static int expand(String str, int left, int right) {
        int cnt = 0;

        while (left >= 0 && right < str.length()
                && str.charAt(left) == str.charAt(right)) {
            cnt++;
            left--;
            right++;
        }
        return cnt;
    }
}
/*| Approach                 | Time      | Space    |
| ------------------------ | --------- | -------- |
| Brute force + recursion  | O(n³)     | O(n)     |
| **Expand Around Center** | **O(n²)** | **O(1)** | above approach
| Manacher’s Algorithm     | O(n)      | O(n)     |
*/