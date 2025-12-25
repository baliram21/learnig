package org.nayan.common;

public class PrintFibonacciInRange {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;

        // Print Fibonacci numbers between 50 and 100
        while (a <= 100) {
            if (a >= 0 && a <= 100) {
                System.out.print(a + " ");
            }
            int c = a + b;
            a = b;
            b = c;
        }
    }
}
