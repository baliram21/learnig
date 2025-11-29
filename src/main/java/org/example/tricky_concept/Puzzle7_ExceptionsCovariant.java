package org.example.tricky_concept;

public class Puzzle7_ExceptionsCovariant {
    public static void main(String[] args) {
        try {
            Parent7 p = new Child7();
            p.process(); // compile-time type sees Parent7.process() declares Exception, but runtime uses Child7 implementation
        } catch (Exception e) {
            System.out.println("Caught: " + e);
        }
    }
}

class Parent7 {
    // declares checked exception
    public Parent7 process() throws Exception {
        System.out.println("Parent7.process");
        return this;
    }
}

class Child7 extends Parent7 {
    // covariant return type is allowed: Child7 extends Parent7
    // can also throw no checked exception (or narrower)
    @Override
    public Child7 process() {
        System.out.println("Child7.process");
        return this;
    }
}

/*
Output:
Child7.process

Explanation:
- Overriding method may declare fewer or no checked exceptions.
- Covariant return type (Child7) is allowed.
- Caller declared catches Exception because Parent7.process declared it — but here runtime method doesn't throw.
*/
