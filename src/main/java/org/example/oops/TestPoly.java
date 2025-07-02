package org.example.oops;

public class TestPoly {
    public static void main(String[] args) {
        Parent p = new Child();  
        // This creates an object of Child but referenced by Parent type.
        // Due to constructor chaining, Parent constructor will run first, then Child constructor.
    }
}

class Parent {
    public Parent() {
        super();  // Calls the constructor of java.lang.Object (implicit if not written)
        System.out.println("instantiate a parent");
    }
}

class Child extends Parent {
    public Child() {
        // Before executing this constructor body, it implicitly calls super()
        // which means Parent's constructor is called first
        System.out.println("instantiate a child");
    }
}

/*
Output:
instantiate a parent
instantiate a child

Explanation:
- When new Child() is called, it first calls Parent's constructor (due to super())
- Then after Parent constructor completes, Child's constructor runs
- This shows constructor execution order in inheritance
*/
