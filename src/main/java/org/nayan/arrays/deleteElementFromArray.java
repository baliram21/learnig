package org.nayan.arrays;

import java.util.Arrays;

public class deleteElementFromArray {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6};

        int pos =2;

        System.out.println(Arrays.toString(deleteElement(arr,pos)));

    }

    public static int[] deleteElement(int[] arr, int pos){
        int[] newArr = new int[arr.length-1];

        for (int i = 0; i < pos; i++) {
            newArr[i]=arr[i];
        }
        for (int i = pos; i < newArr.length; i++) {
            newArr[i]= arr[i+1];
        }
        return newArr;
    }
}
