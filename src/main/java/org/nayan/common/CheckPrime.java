package org.nayan.common;

public class CheckPrime {
    public static void main(String[] args) {
        int n = 13;

        if (isPrime(n)) {
            System.out.println(n + " is prime");
        } else {
            System.out.println(n + " is not prime");
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false; // 0 and 1 are not prime

        for (int div = 2; div * div <= n; div++) {
            if (n % div == 0) {
                return false; // found a divisor → not prime
            }
        }
        return true; // no divisors found → prime
    }
}
