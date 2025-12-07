package org.nayan.oops;

public class Test {
    
    // Overloaded method: accepts Object
    public void print(Object obj) {
        System.out.println("Object " + obj);
    }

    // Overloaded method: accepts String
    public void print(String obj) {
        System.out.println("String " + obj);
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.print(null);  
        // This will call the print(String obj) method
        // Because null can match both Object and String,
        // but String is more specific, so it gets preference
    }
}

/*
===== Output =====
String null

===== Explanation =====
- Method overloading is resolved at **compile time**, based on reference types.
- `print(null)` matches both methods, but Java picks the **most specific** one.
- `String` is a subclass of `Object`, so `print(String)` is chosen.
*/
