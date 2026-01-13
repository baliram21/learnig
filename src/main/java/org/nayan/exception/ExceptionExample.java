package org.nayan.exception;

public class ExceptionExample {
   static void m1() {
       System.out.println("m1 method {} -  int x = 10 / 0;");

        int x = 10 / 0; // Exception here
    }

   static void m2() {
       System.out.println("m2 method calling m1 ");
        m1();
    }

    public static void main(String[] args) {
        // m2(); -
        m1();
    }
 // ArithmeticException propagates m1 → m2 → main
}
