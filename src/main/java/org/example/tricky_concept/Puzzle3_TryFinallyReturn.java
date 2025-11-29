package org.example.tricky_concept;

public class Puzzle3_TryFinallyReturn {
    public static void main(String[] args) {
        System.out.println("primitiveReturn() -> " + primitiveReturn());
        System.out.println("objectReturn() -> " + objectReturn());
    }

    static int primitiveReturn() {
        try {
            return 1;
        } finally {
            // finally's return will override the try's return
            return 2;
        }
    }

    static java.util.List<Integer> objectReturn() {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        try {
            list.add(1);
            return list; // returns reference to list
        } finally {
            // finally executes before method actually returns;
            // it can mutate the returned object's state.
            list.add(2);
            // NOT returning here -> so the original returned reference reflects this mutation
        }
    }
}

/*
Output:
primitiveReturn() -> 2
objectReturn() -> [1, 2]

Explanation:
- A return in finally overrides earlier return for primitives/values.
- When returning an object reference from try, finally executes before actual return and can mutate the object; the caller sees mutated object.
*/
