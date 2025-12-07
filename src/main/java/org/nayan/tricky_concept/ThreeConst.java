package org.nayan.tricky_concept;

public class ThreeConst {
    public static void main(String[] args) {
        new ThreeConst(4L);
        // Expected output (on one line, with spaces exactly as printed):
        // no-arg 8 4
        // Explanation below.
    }

    public ThreeConst(int x) {
        this(); // calls the no-arg constructor first
        System.out.print(" " + (x * 2)); // prints int*2
    }

    public ThreeConst(long x) {
        this((int) x); // calls ThreeConst(int)
        System.out.print(" " + x); // then prints the long value
    }

    public ThreeConst() {
        System.out.print("no-arg");
    }
}

/*
Detailed flow for new ThreeConst(4L):
- ThreeConst(long x) invoked with x=4L
- That calls this((int)x) => ThreeConst(int x) with x=4
- ThreeConst(int) calls this() => ThreeConst() prints "no-arg"
- return to ThreeConst(int): prints " 8" (since 4 * 2 = 8)
- return to ThreeConst(long): prints " 4"
Combined printed output: no-arg 8 4
*/
