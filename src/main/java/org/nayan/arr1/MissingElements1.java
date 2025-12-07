package org.nayan.arr1;

public class MissingElements1 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5};  //

        System.out.println("Missing elements:");
        findMissingElements(arr);
    }
    // timecompexity= O(n*n)
    public static void findMissingElements(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {  // 1,3,5
            int current = arr[i];  // 1 -3 -5
            int next = arr[i + 1]; // 3 -5 -7

            // Check for missing elements between current and next
            for (int j = current + 1; j < next; j++) {   // j=1+1=2 - 3+1=4 - 5+1=6
                System.out.print(j + " ");
            }
        }
    }
}
