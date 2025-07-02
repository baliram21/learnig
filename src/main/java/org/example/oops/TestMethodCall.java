package org.example.oops;

class Parent {
    void run() {
        walk();  // This will call Child's walk() due to dynamic method dispatch
    }

    void walk() {
        System.out.println("Parent is walking");
    }
}

class Child extends Parent {
    @Override
    void run() {
        super.run();  // Calls Parent's run(), which internally calls walk()
                      // But due to polymorphism, Child's walk() will be invoked
    }

    @Override
    void walk() {
        System.out.println("Child is walking");
        super.walk();  // Calls Parent's walk() explicitly
    }

    void talk() {
        super.walk();  // Not used in this example, but would call Parent's walk()
    }
}

public class TestMethodCall {
    public static void main(String[] args) {
        Parent p = new Child();  // Upcasting: reference is Parent, object is Child
        p.run();  // Starts method execution
    }
}

/*
===== Execution Flow =====
1. p.run() is called.
   - Since run() is overridden in Child, Child.run() is executed.
2. Child.run() calls super.run() → Parent.run()
3. Parent.run() calls walk()
   - Due to dynamic dispatch, this actually calls Child.walk()
4. Child.walk() prints "Child is walking"
5. Then Child.walk() calls super.walk() → Parent.walk(), which prints "Parent is walking"

===== Output =====
Child is walking
Parent is walking
*/
