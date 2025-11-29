package org.example.tricky_concept;

public class PuzzleF {
    public static void main(String[] args) {
        call((Integer[]) null); // calls varargs version with null array
        call((Object) null);    // calls object version
        // call(null); // ambiguous: null can match both Object and Integer[] (varargs), compile-time error
    }

    static void call(Object o)       { System.out.println("Object"); }
    static void call(Integer... a)   { System.out.println("Integer..."); }
}

/*
Explanation:
- Integer... is treated as Integer[] at compile time.
- A plain null is applicable to both Object and Integer[]; neither is more specific -> ambiguous.
- Casting resolves the call.
*/
