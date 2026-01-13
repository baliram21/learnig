package org.nayan.dsa.subtrings;

import java.util.HashMap;
import java.util.Map;

public class CountSubstringExactlyKUnique {

    public static void main(String[] args) {
        String s = "pqpqs";
        int k = 2;

        System.out.println("Count: " + countExactlyK(s, k));
    }

    public static int countExactlyK(String s, int k) {

        // Exactly K = AtMost(K) - AtMost(K - 1)
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }

    private static int countAtMostK(String s, int k) {

        if (k == 0) return 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);

            // Add character to map
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);

            // Shrink window if unique characters exceed k
            while (freqMap.size() > k) {

                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);

                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }

                left++;
            }

            // All substrings ending at 'right' are valid
            count += (right - left + 1);
        }

        return count;
    }
}
