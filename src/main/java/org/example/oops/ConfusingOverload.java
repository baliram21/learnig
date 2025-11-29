package org.example.oops;

public class ConfusingOverload {
    public static void main(String[] args) {

        Printer p = new Printer();

        /*
            Here we call:
                p.print(null);

            Question:
                Which overload will be selected?
                void print(A a)
                void print(B b)

            Let's break it down:
            ---------------------------------------------
            1) `null` can match ANY reference type.
               So BOTH print(A) and print(B) are applicable.

            2) Overload resolution rule:
                  "Choose the MOST SPECIFIC type."

            3) Class relationship:
                     interface A
                         ↑
                         |
                         B  (implements A)

               → B is a subtype of A.
               → B is MORE SPECIFIC than A.

            4) Therefore:
                  p.print(null) calls print(B b)

            5) Output:
                 B version

            NOTE:
            Even though B has a constructor that prints something,
            `p.print(null)` does NOT create a B object.
            The constructor of B executes ONLY when we do new B().
        */

        p.print(null);     // prints: B version


        // Additional demonstration:
        B b = new B();     // creates B object -> prints constructor message
        b.hello();         // default method from A interface
    }
}

interface A {
    default void hello() {
        System.out.println("Hello Interface A");
    }
}

class B implements A {

    public B() {
        System.out.println("this is class B constructor");
    }
}

class Printer {

    void print(A a) {
        System.out.println("A version");
    }

    void print(B b) {
        System.out.println("B version");
    }
}
