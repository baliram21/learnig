package org.nayan.exception;

public class FinallyReturnFix {
    public static int test() {
        try {
            System.out.println("try-block");
            return 1;
        } finally {
            // do cleanup but don't return
            System.out.println("cleanup");
        }
    }

    public static void main(String[] args) {
        System.out.println(test()); // prints 1

        /*
        try-block
        cleanup
        1
        */
    }
}
