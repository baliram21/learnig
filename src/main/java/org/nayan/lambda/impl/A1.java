package org.nayan.lambda.impl;

// Functional interface for m1() method
public interface A1 {
    void m1();
}

// Functional interface for sum() method
interface B1 {
    int sum(int x, int y);
}

// Functional interface for greet() method
interface C1 {
    String greet(String s);
}

class AImpl {
    public static void main(String[] args) {
        // Lambda expression for m1()
        A1 a1 = () -> System.out.println("m1() method");
        a1.m1(); // This will print "m1() method"

        // Lambda expression for sum()
        B1 b1 = (x, y) -> x + y;
        int sum = b1.sum(2, 4); // This will correctly sum 2 and 4
        System.out.println(sum); // This will print 6

        // Lambda expression for greet()
        C1 c1 = (s) -> "Hello " + s;
        System.out.println(c1.greet("nayan")); // This will print "Hello nayan"
    }
}
