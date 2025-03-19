package org.example.arrays;

public class ArrayMaxValue {
    public static void main(String[] args) {
        int[] arr= {4,9,2,3,77,1};
        int maxValue = maxValueInArray(arr);

        System.out.println("Maximum value in array- "+maxValue);
        int index = maxValueIndexInArray(arr);
        System.out.println("Index of Max value in Array- "+index);

    }

    private static int maxValueIndexInArray(int[] arr) {

        int maxIndex=0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>arr[maxIndex]){
                maxIndex=i;
            }
        }
        return maxIndex;
    }

    public static int maxValueInArray(int[] arr){
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]> max){
                max=arr[i];
            }
        }
        return max;
    }
}
