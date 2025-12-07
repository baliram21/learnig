package org.nayan.dsa;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {2, 6, 5, 8, 11};
        int target = 14;

        int[] result1 = twoSum(arr, target);
        int[] result = twoSum_Map(arr, target);

        if(result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found.");
        }
    }

    private static int[] twoSum_Map(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target-arr[i];

            if(map.containsKey(complement)){
                //return new int[]{map.get(complement),i};
                return new int[]{map.get(complement),i};
            }
            map.put(arr[i],i);

        }
        return null;
    }

    private static int[] twoSum(int[] arr, int target) {
        Arrays.sort(arr); // Now the two-pointer approach will work
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[]{arr[left], arr[right]}; // Returning values, not indices
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
