package org.nayan.dsa.map_heap.map;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int arr[] = {100, 4, 200, 1, 3, 2};

        int solution = solution(arr);
        System.out.println("max len "+solution);

    }

    private static int solution(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int max = arr[i];

            Set<Integer> seen = new HashSet<>();
            seen.add(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                if (seen.contains(arr[j])) {
                    break;
                }
                seen.add(arr[j]);
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

                if (max - min == j - i) {
                    int len = j - i + 1;
                    if (len > ans) {
                        ans = len;
                    }
                }
            }
        }
        return ans;
    }
}
