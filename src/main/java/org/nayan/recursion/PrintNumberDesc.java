package org.nayan.recursion;

public class PrintNumberDesc {
    public static void main(String[] args) {
        int n =10;
        printDesc(n);
    }

    public static void printDesc(int n){
        if (n==1){
            System.out.print(1);
            return;
        }

        System.out.print(n+" ");
        printDesc(n-1);
    }
}
