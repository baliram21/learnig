package org.example.tricky_concept;

public class Puzzle1_StaticHiding {
    public static void main(String[] args) {
        Parent3 p = new Child3();
        p.instance();      // dynamic dispatch -> Child.instance()
        p.staticMethod();  // static methods are resolved by reference type -> Parent.staticMethod()
        Child3.staticMethod();// calling via class -> Child.staticMethod()
    }
}

class Parent3 {
    public static void staticMethod() { System.out.println("Parent3.staticMethod"); }
    public void instance() { System.out.println("Parent3.instance"); }
}

class Child3 extends Parent3 {
    // hides staticMethod (not overrides)
    public static void staticMethod() { System.out.println("Child3.staticMethod"); }
    @Override
    public void instance() { System.out.println("Child3.instance"); }
}

/*
Output:
Child.instance
Parent.staticMethod
Child.staticMethod

Explanation:
- instance() is virtual — runtime type (Child) wins.
- staticMethod() is *hidden*, not overridden — call resolved using compile-time type.
- p is declared Parent, so p.staticMethod() calls Parent.staticMethod.
*/
