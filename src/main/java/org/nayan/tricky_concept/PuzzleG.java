package org.nayan.tricky_concept;

public class PuzzleG {
    public static void main(String[] args) {
        M m = new M();
        m.f(null);                // which overload? COMPILE-TIME ambiguity if both reference types exist
        m.f((Integer) null);      // calls f(Integer)
        m.f(5);                   // int literal -> prefers int primitive if available
    }
}

class M {
    void f(Integer i) { System.out.println("Integer"); }
    void f(Object o)  { System.out.println("Object"); }
    void f(int x)     { System.out.println("int"); }
}

/*
Expected:
- m.f(null) -> Compiler picks the most specific between Integer and Object -> Integer (since Integer is subtype of Object)
             => prints "Integer"
- m.f((Integer)null) -> "Integer"
- m.f(5) -> exact primitive int match -> "int" (primitive preferred over boxing)
*/
