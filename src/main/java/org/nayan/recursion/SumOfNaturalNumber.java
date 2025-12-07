package org.nayan.recursion;

public class SumOfNaturalNumber {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(findSum(n));
    }
    private static int findSum(int n) {
        if (n==1){
            return 1;
        }
        return n + findSum(n-1);
        /*
        sum of n natural number = n+(n-1)
         */
    }
}
