package org.example.tricky_concept;

public class PuzzleD {
    public static void main(String[] args) {
        Childishh c = new Childishh();
      //  c.call(null);            // prints Child version
        c.call((Parentish1) null);            // prints Child version
        c.call((Parentish1)null); // forces Parentish version
    }
}

class Parentish1 {}
class Childish1 extends Parentish1 {
    public void call(Object o) {
    }
}

class ChildishOverloader {
    void call(Parentish1 p) { System.out.println("Parentish"); }
    void call(Childishh c)  { System.out.println("Childish"); }
}

// The class used above should be:
class Childishh {
    void call(Parentish1 p) { System.out.println("Parentish"); }
    void call(Childishh c)  { System.out.println("Childish"); }

    public static void main(String[] args) {
        Childishh ch = new Childishh();
        ch.call((Parentish1) null);                 // Childish (more specific parameter)
        ch.call((Parentish1) null);     // Parentish
    }
}

/*
Explanation:
- When one parameter type is a subtype of the other, the subtype overload is "more specific" and is chosen for null.
*/
