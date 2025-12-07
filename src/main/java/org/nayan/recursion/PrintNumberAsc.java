package org.nayan.recursion;

public class PrintNumberAsc {
    public static void main(String[] args) {
        int n = 10;
        printAsc(n);
    }

    private static void printAsc(int n) {
        if (n==0){
           // System.out.print(n+ " "); if n==1
            return;
        }
        printAsc(n-1);
        System.out.print(n+" ");
    }
}
