package org.nayan.dsa.subtrings;

import java.util.*;

public class ReturnSubstringsExactlyKUnique {

    public static void main(String[] args) {
        String s = "pqpqs";
        int k = 2;

        List<String> result = substringsExactlyK(s, k);
        System.out.println(result);
    }

    public static List<String> substringsExactlyK(String s, int k) {

        // Substrings with at most K unique
        List<String> atMostK = substringsAtMostK(s, k);

        // Substrings with at most (K-1) unique
        List<String> atMostKMinus1 = substringsAtMostK(s, k - 1);

        // Remove all (K-1) unique substrings
        Set<String> removeSet = new HashSet<>(atMostKMinus1);

        List<String> result = new ArrayList<>();
        for (String sub : atMostK) {
            if (!removeSet.contains(sub)) {
                result.add(sub);
            }
        }

        return result;
    }

    // Helper: return all substrings with at most K unique characters
    private static List<String> substringsAtMostK(String s, int k) {

        List<String> result = new ArrayList<>();
        if (k == 0) return result;

        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);

            // Shrink window if unique chars exceed k
            while (freqMap.size() > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);

                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }

            // Collect all substrings ending at 'right'
            for (int start = left; start <= right; start++) {
                result.add(s.substring(start, right + 1));
            }
        }

        return result;
    }
}
