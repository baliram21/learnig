package org.nayan.arrays;

import java.util.Arrays;

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5};

        int[] ints = prefixSum(arr);
        System.out.println(Arrays.toString(ints));

       // int[] arr1 = prefixSumOptimal(arr); // ❌ arr already used
        int[] res2 = prefixSumOptimal(arr.clone());
        System.out.println(Arrays.toString(res2));

    }

    public static int[] prefixSumOptimal(int[] nums){
        for(int i= 1; i<nums.length; i++){
            nums[i]= nums[i-1]+nums[i];
        }
        return nums;
    }

    public static int[] prefixSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i]= res[i-1]+ nums[i];
        }
        return res;
    }
}
