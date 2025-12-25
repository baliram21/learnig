package org.nayan.oops.inheritance;

// Parent class
public class Parent {

    // Method in Parent class
    public void m1(){
        System.out.println("Parent Class");
    }
}

// Child class extending Parent
class Child extends Parent {

    // Method in Child class
    public void m2(){
        System.out.println("Child");
    }
}

// Test class to demonstrate inheritance
class Test {
    public static void main(String[] args) {

        // Creating Parent object
        Parent parent = new Parent();
        parent.m1(); // This will print "Parent Class"
        // parent.m2(); // Uncommenting this line will cause a compile-time error because
                            // Parent class doesn't have m2() method

        // Trying to create a Child object with Parent reference
        // Child child = new Parent(); // This line will cause a compile-time error because
                                        // a Parent object cannot be assigned to a Child reference

        // Creating Child object
        Child child = new Child();
        child.m2(); // This will print "Child"
        child.m1(); // This will print "Parent Class" because Child inherits m1() from Parent

        // Creating a Child object with a Parent reference
        Parent parent1 = new Child();
        parent1.m1(); // This will print "Parent Class" because parent1 refers to an instance of
                        // Child and m1() is inherited from Parent
        // parent1.m2(); // Uncommenting this line will cause a compile-time error because
        //                  Parent reference type cannot access m2() method in Child

      //  Child ch2 = new Parent(); // not possible
    }
}
