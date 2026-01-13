package other.baliram.twopointer;

public class MaxSumOfSizeK {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 6, 1, 0, 8, 2, 5, 1, 0, 1};
        int size = 3;

        System.out.println(maxSum(arr, size));
    }

    private static int maxSum(int[] arr, int size) {

        // Edge case
        if (arr == null || arr.length < size) {
            return -1;
        }

        int currentSum = 0;

        // Step 1: Calculate sum of first window
        for (int i = 0; i < size; i++) {
            currentSum += arr[i];
        }

        int maxSum = currentSum;

        // Step 2: Slide the window
        for (int i = size; i < arr.length; i++) {
            currentSum = currentSum - arr[i - size] + arr[i];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
