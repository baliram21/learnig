package org.nayan.common;

public class PrintPrimeNumbers {
    public static void main(String[] args) {
        int start = 2, last = 100;

        for (int i = start; i <=last ; i++) {
            boolean isPrime = true;

            for (int div = 2 ; div*div <= i ; div++){
                if (i % div == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                System.out.print(i + " ");
            }
        }
    }
}
