package org.nayan.tricky_concept;

public class Puzzle6_FieldHiding {
    public static void main(String[] args) {
        Parent6 p = new Child6();
        System.out.println("p.x = " + p.x); // field access uses compile-time type
        p.printX();                         // method dispatch is dynamic -> Child6.printX()
    }
}

class Parent6 {
    public int x = 1;
    public void printX() { System.out.println("Parent6.printX: x=" + x); }
}

class Child6 extends Parent6 {
    public int x = 2; // hides parent field
    @Override
    public void printX() { System.out.println("Child6.printX: x=" + x); }
}

/*
Output:
p.x = 1
Child6.printX: x=2

Explanation:
- Field access is not polymorphic: p.x resolves using compile-time type Parent6.
- Methods are polymorphic: printX() dispatches to Child6, and inside Child6.printX 'x' refers to Child6.x.
*/
