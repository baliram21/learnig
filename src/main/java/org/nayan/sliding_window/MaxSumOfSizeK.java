package org.nayan.sliding_window;

public class MaxSumOfSizeK {
    public static void main(String[] args) {
        int[] arr = {8, 5, 6, 7, 3, 9, 1, 4};
        int k = 3;
        int n = arr.length;   // ✅ Use full length

        int sum = 0;          // current window sum
        int maxSum = 0;       // store max sum found
        int index = 0;        // pointer to initialize first window

        // ✅ Step 1: Calculate sum of first window of size k
        while (index < n && index < k) {
            sum += arr[index];
            index++;
        }
        maxSum = sum;  // first window sum becomes initial max

        // ✅ Step 2: Slide the window
        for (int i = 1; i <= n - k; i++) {
            int prev = arr[i - 1];     // element going out of window
            int next = arr[i + k - 1]; // new element coming into window
            sum = sum - prev + next;   // update window sum
            maxSum = Math.max(maxSum, sum);
        }

        // ✅ Step 3: Print result
        System.out.println("Maximum sum of subarray of size " + k + " = " + maxSum);
    }
}
