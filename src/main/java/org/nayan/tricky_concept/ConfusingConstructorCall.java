package org.nayan.tricky_concept;

public class ConfusingConstructorCall {
    public static void main(String[] args) {
        Parent2 p = new Child2();
    }
}

class Parent2 {
    Parent2() {
        System.out.println("Parent2 constructor");
        show(); // calls overridden version!
    }

    void show() {
        System.out.println("Parent2 show");
    }
}

class Child2 extends Parent2 {
    int x = 10;

    Child2() {
        System.out.println("Child2 constructor");
    }

    @Override
    void show() {
        System.out.println("Child2 show, x = " + x);
    }
}
