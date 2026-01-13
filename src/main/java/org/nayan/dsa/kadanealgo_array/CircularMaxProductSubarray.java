package org.nayan.dsa.kadanealgo_array;

public class CircularMaxProductSubarray {

    public static void main(String[] args) {
        int[] arr = {2, -3, 4};

        System.out.println("Circular Max Product: " + circularMaxProduct(arr));
    }

    public static int circularMaxProduct(int[] arr) {

        int n = arr.length;

        // Step 1: Normal max product subarray
        int normalMax = maxProduct(arr);

        // Step 2: Compute prefix max product
        int[] prefix = new int[n];
        int prod = 1;

        for (int i = 0; i < n; i++) {
            prod = (prod == 0 ? arr[i] : prod * arr[i]);
            prefix[i] = prod;
        }

        // Step 3: Compute suffix max product
        int[] suffix = new int[n];
        prod = 1;

        for (int i = n - 1; i >= 0; i--) {
            prod = (prod == 0 ? arr[i] : prod * arr[i]);
            suffix[i] = prod;
        }

        // Step 4: Find best circular product
        int circularMax = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            circularMax = Math.max(circularMax, prefix[i] * suffix[i + 1]);
        }

        return Math.max(normalMax, circularMax);
    }

    // Standard max product subarray
    private static int maxProduct(int[] arr) {

        int maxProd = arr[0];
        int minProd = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int current = arr[i];

            if (current < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(current, maxProd * current);
            minProd = Math.min(current, minProd * current);

            result = Math.max(result, maxProd);
        }

        return result;
    }
}
