package org.nayan.tricky_concept;

public class Puzzle2_IntegerCaching {
    public static void main(String[] args) {
        Integer a = 127;          // cached
        Integer b = 127;          // same cached object
        Integer c = 128;          // outside cache (usually)
        Integer d = 128;

        System.out.println(a == b);            // true (same cached object)
        System.out.println(c == d);            // usually false (different objects)
        System.out.println(a.equals(b));       // true
        System.out.println((a + 0) == (b + 0)); // true -> unboxed to int, value comparison

       /* Integer x = new Integer(5);  //Integer(n)-deprecated since java9
        int y = x + 0; // unboxing
        System.out.println("y = " + y);*/
    }
}

/*
Typical Output:
true
false
true
true
y = 5

Explanation:
- Integer values between -128 and 127 are cached (implementation detail but part of spec).
- == compares object identity for Integer references; equals compares numeric value.
- Arithmetic (a+0) forces unboxing, converting to primitive int, so == compares values.
*/
