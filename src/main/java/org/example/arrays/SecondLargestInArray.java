package org.example.arrays;

public class SecondLargestInArray {
    public static void main(String[] args) {

        int[] arr= {5,5,5,5};

        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i]>largest){
                secondLargest=largest;
                largest=arr[i];
            }else if (arr[i]>secondLargest && arr[i]!=largest){
                secondLargest=arr[i];
            }
        }

        if (secondLargest==Integer.MIN_VALUE){
            System.out.println("No Second Max Value present in array");
        }else {
            System.out.println("Second largest value - "+secondLargest);
        }
    }
}
