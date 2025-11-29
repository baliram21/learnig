package org.example.tricky_concept;

public class OverloadNullFix {
    public static void main(String[] args) {
        Test2 t = new Test2();

        t.print(null);             // calls print(String)
        t.print((Object) null);    // forces call to print(Object)
    }
}

class Test2 {
    public void print(Object obj) {
        System.out.println("Object: " + obj);
    }

    public void print(String obj) {
        System.out.println("String: " + obj);
    }
}

/*
Output:
String: null       <-- because String is more specific
Object: null       <-- forced by casting null to Object

Explanation:
- Without a cast, null matches both print(Object) and print(String).
- Java chooses the MOST SPECIFIC overload: String.
- Casting null to (Object) makes the Object version selected.
*/
