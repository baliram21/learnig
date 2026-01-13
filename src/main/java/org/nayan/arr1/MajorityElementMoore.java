package org.nayan.arr1;

public class MajorityElementMoore {

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};

        int candidate = findCandidate(arr);
        System.out.println(candidate);

        if (isMajority(arr, candidate)) {
            System.out.println("Majority Element: " + candidate);
        } else {
            System.out.println("No Majority Element");
        }
    }

    private static int findCandidate(int[] arr) {
        int count = 0;
        int candidate = -1;

        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;

            } else {
                count--;
            }
        }
        return candidate;
    }
    private static boolean isMajority(int[] arr, int candidate) {
        int freq = 0;
        for (int num : arr) {
            if (num == candidate) freq++;

        }
        return freq > arr.length/2;
    }
}