package org.example.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int n=5;
       // prinFib(n);
        System.out.println(prinFib(n));
    }

    private static int prinFib(int n) {

        if (n==0 || n==1){
            return n;
        }
        return prinFib(n-1)+prinFib(n-2);
    }
}
