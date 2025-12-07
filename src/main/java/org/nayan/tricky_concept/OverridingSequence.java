package org.nayan.tricky_concept;

public class OverridingSequence {
    public static void main(String[] args) {
        Parent p = new Child();
        p.run(); // Dynamic dispatch: run() resolves to Child.run()
        // Expected printed sequence (explained below).
    }
}

class Parent {
    public void run() {
        System.out.println("Parent.run() - about to call walk()");
        walk(); // virtual call — resolved at runtime to the concrete object's walk()
        System.out.println("Parent.run() - after walk()");
    }

    public Parent() {
        System.out.println("Parent Constructor");
    }

    public void walk() {
        System.out.println("Parent.walk()");
    }
}

class Child extends Parent {
    @Override
    public void run() {
        System.out.println("Child.run() - calling super.run()");
        super.run(); // calls Parent.run()
        System.out.println("Child.run() - after super.run()");
    }

    public Child() {
        System.out.println("Child Constructor");
    }

    @Override
    public void walk() {
        System.out.println("Child.walk() - calling super.walk()");
        super.walk(); // explicitly call Parent.walk()
        System.out.println("Child.walk() - after super.walk()");
    }

    public void talk() {
        // This method is not invoked in main, but demonstrates calling superclass method:
        System.out.println("Child.talk() - calling super.walk()");
        super.walk();
    }
}

/*
Explanation of actual flow when p.run() executed:
1. p.run() dispatches to Child.run() (because run is overridden and object is Child).
2. Child.run() prints "Child.run() - calling super.run()" then calls super.run() (Parent.run()).
3. Parent.run() prints "Parent.run() - about to call walk()" then calls walk().
   - walk() is virtual and resolved to Child.walk() (dynamic binding).
4. Child.walk() runs: prints "Child.walk() - calling super.walk()", then calls super.walk() (Parent.walk()).
5. Parent.walk() prints "Parent.walk()", returns to Child.walk().
6. Child.walk() prints "Child.walk() - after super.walk()", returns to Parent.run().
7. Parent.run() prints "Parent.run() - after walk()", returns to Child.run().
8. Child.run() prints "Child.run() - after super.run()".
So the order: Child.run() -> Parent.run() -> Child.walk() -> Parent.walk() -> (back) Parent.run() -> Child.run() finish.
*/
