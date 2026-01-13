package org.nayan.arr1;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {5, 6, 9, 2, 1, 11};
        int target = 10;

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int target1 = 9;

        int[] list = twoSum(arr, target);
        int[] mapAns = twoSumByMap(arr, target);
        System.out.println(Arrays.toString(mapAns));
        int[] pinterAns = twoSumByTwoPointer(arr1, target1);
        System.out.println(Arrays.toString(list));
        System.out.println(Arrays.toString(pinterAns));
    }

    private static int[] twoSumByTwoPointer(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        while (start < end) {
            if (target == (arr[start] + arr[end])) {
                return new int[]{start, end};
            } else {
                start++;
                end--;
            }
        }
        return arr;
    }

    private static int[] twoSumByMap(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int complement = target - num;

            if (map.containsKey(complement)) {

                return new int[]{map.get(complement), i};
            }
            map.put(num, i);
        }
        return new int[]{0};
    }

    private static int[] twoSum(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] a = new int[2];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            int complement = target - num;

            if (map.containsKey(complement)) {
                a[0] = map.get(complement);
                a[1] = i;
                list.add(map.get(complement));
                list.add(i);
            }
            map.put(num, i);
        }
        System.out.println(list);
        return a;
    }
}
