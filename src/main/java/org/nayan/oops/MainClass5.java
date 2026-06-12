package org.nayan.oops;

public class MainClass5 {
    public static void main(String[] args) {

        // ParentA reference holding ChildA object
        // Reference type decides accessible methods (compile time)
        // Object type decides which overridden method runs (runtime)
        ParentA p = new ChildA();

        // print() exists in ParentA and is overridden in ChildA
        // Runtime polymorphism → ChildA's print() will execute
        p.print();   // Output: Child method :- print()

        // hello() exists in ParentA and is overridden in ChildA
        // JVM calls ChildA's version at runtime
        p.hello();   // Output: hello from ChildA class

        // bye() exists only in ParentA
        // ChildA does not override it
        // ParentA's method executes
        p.bye();     // Output: Parent method :- bye()

        // ❌ Compile-time error
        // tata() does NOT exist in ParentA
        // Reference type is ParentA, so compiler rejects this call
        // p.tata();

        // ✅ Downcasting to access ChildA-specific method
        // Safe here because object is actually ChildA
        ((ChildA) p).tata();  // Output: Child method :- tata()
    }
}

class ParentA {

    // Method available to ParentA reference
    // Can be overridden by child
    void print() {
        System.out.println("Parent method :- print()");
    }

    // Overridable method
    void hello() {
        System.out.println("Parent method :- hello()");
    }

    // Not overridden → parent version will be used
    void bye() {
        System.out.println("Parent method :- bye()");
    }
}

class ChildA extends ParentA {

    // Overrides ParentA.print()
    // Runtime method selection happens here
    void print() {
        System.out.println("Child method :- print()");
    }

    // Overrides ParentA.hello()
    void hello() {
        System.out.println("hello from ChildA class");
    }

    // Child-specific method
    // NOT accessible using ParentA reference
    void tata() {
        System.out.println("Child method :- tata()");
    }
}
