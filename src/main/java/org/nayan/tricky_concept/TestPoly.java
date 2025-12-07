package org.nayan.tricky_concept;

public class TestPoly {
    public static void main(String[] args) {
        Parent1 p = new Child1();
        // When creating Child:
        // - Child() implicitly calls super() first.
        // - Parent constructor runs before Child constructor body.
        // Expected output:
        // instantiate a parent
        // instantiate a child
    }
}

class Parent1 {
    public Parent1() {
       // super();
        System.out.println("instantiate a parent");
    }
}

class Child1 extends Parent1 {
    public Child1() {
        // implicit super() already executed
        System.out.println("instantiate a child");
    }
}
