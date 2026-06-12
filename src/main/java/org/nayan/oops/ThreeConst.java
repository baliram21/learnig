package org.nayan.oops;

public class ThreeConst {
    public static void main(String[] args) {
        new ThreeConst(4L);  
        // Starts with the constructor that accepts a long (4L)
    }

    public ThreeConst(int x) {
        this();  // Calls the no-arg constructor first
        System.out.println(" " + (x * 2));  // Then prints the result of x * 2
    }

    public ThreeConst(long x) {
        this((int) x);  // Calls the int constructor with x cast to int (4)
        System.out.println(" " + x);  // Then prints the long value x
    }

    public ThreeConst() {
        System.out.println("no-arg ");  // This runs first in the constructor chain
    }
}

/*
===== Constructor Execution Flow =====

Step-by-step:

1. new ThreeConst(4L);
   → calls the long constructor

2. long constructor:
   → calls int constructor: this((int)x) → this(4)

3. int constructor:
   → calls no-arg constructor: this()

4. no-arg constructor:
   → prints "no-arg "

5. back to int constructor:
   → prints " 8"  (4 * 2)

6. back to long constructor:
   → prints " 4"  (original long value)

===== Final Output =====
no-arg 8 4
*/
