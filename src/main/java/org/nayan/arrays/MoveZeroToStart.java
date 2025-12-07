package org.nayan.arrays;

public class MoveZeroToStart {

    public static void main(String[] args) {
        int[] arr = {2,-1,4,2,-4,0,0,0, -3, 5};

        for (int i : reArrangeArray(arr)) {
            System.out.print(i+" ");
        }

    }
    public static int[] reArrangeArray(int[] arr){
        int[] newArr= new int[arr.length];
        int j=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<0){
                newArr[j]=arr[i];
                j++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0){
                newArr[j]= arr[i];
                j++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>0){
                newArr[j]= arr[i];
                j++;
            }
        }
        return newArr;
    }
}
