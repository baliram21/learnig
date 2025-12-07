package org.nayan.tricky_concept;

public class ConfusingOverload {
    public static void main(String[] args) {
        Printer p = new Printer();

        // Question: Which method is called when passing null?
        p.print(null);

        /*
            Explanation:

            Both methods below can accept `null`:

                void print(A a)
                void print(B b)

            Because: null is compatible with ANY reference type.

            BUT Java must choose ONE overload at compile time.

            Rule:
                ✔ If multiple methods are applicable,
                ✔ Java selects the MOST SPECIFIC parameter type.

            Here:
                class B implements A
                → B is a SUBTYPE of A
                → B is MORE SPECIFIC than A

            Therefore:
                p.print(null) calls print(B b)

            Output:
                B version
        */
    }
}

interface A {}
class B implements A {}

class Printer {
    void print(A a) { System.out.println("A version"); }
    void print(B b) { System.out.println("B version"); }
}
