package org.example.tricky_concept;

public class OverloadNull {
    public static void main(String[] args) {
        Test t = new Test();
        t.print(null); // which overload is chosen?
    }
}

class Test {
    public void print(Object obj) {
        System.out.println("Object: " + obj);
    }

    public void print(String obj) {
        System.out.println("String: " + obj);
    }
}

/*
Explanation:
- The call t.print(null) is ambiguous at source level if there are two applicable methods equally specific.
- Here, print(String) is more specific than print(Object) (String is a subtype of Object).
- Java's overload resolution chooses the most specific method. So print(String) is selected.
- Output: "String: null"
*/
