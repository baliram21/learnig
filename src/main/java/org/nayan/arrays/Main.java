package org.nayan.arrays;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 5};
        
        // Find the missing number
        int n = arr.length + 1; // Since one number is missing, the length should be n+1
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int num : arr) {
            actualSum += num;
            
            // Count occurrences of each number
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        int missingNumber = expectedSum - actualSum;
        
        // Find the duplicate number
        int duplicateNumber = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicateNumber = entry.getKey();
                break;
            }
        }
        
        System.out.println("Missing number: " + missingNumber);
        System.out.println("Duplicate number " + duplicateNumber + " appears " + countMap.get(duplicateNumber) + " times.");
    }
}
