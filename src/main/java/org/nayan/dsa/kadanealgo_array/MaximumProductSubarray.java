package org.nayan.dsa.kadanealgo_array;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        System.out.println("Maximum product: " + maxProduct(arr));
    }

    public static int maxProduct(int[] arr) {

        // Edge case
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // max product ending at current index
        int maxProd = arr[0];

        // min product ending at current index
        int minProd = arr[0];

        // Global maximum product
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int current = arr[i];

            // If current number is negative,
            // swap max and min (sign will flip)
            if (current < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            // Either start fresh or extend previous product
            maxProd = Math.max(current, maxProd * current);
            minProd = Math.min(current, minProd * current);

            // Update global result
            result = Math.max(result, maxProd);
        }

        return result;
    }
}
