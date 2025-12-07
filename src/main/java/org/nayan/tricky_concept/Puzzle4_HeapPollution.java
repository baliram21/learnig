package org.nayan.tricky_concept;

import java.util.*;

public class Puzzle4_HeapPollution {
    public static void main(String[] args) {
        // generic arrays are not allowed; this compiles with warning:
        List<String>[] arr = (List<String>[]) new List[1]; // unchecked cast
        List<Integer> intList = new ArrayList<>();
        intList.add(42);

        Object[] objArr = arr;    // array is reified, element type is List (runtime)
        objArr[0] = intList;      // puts a List<Integer> into a List<String>[]

        try {
            String s = arr[0].get(0); // ClassCastException at runtime when retrieving element as String
            System.out.println("Got: " + s);
        } catch (ClassCastException e) {
            System.out.println("Runtime ClassCastException occurred: " + e);
        }
    }
}

/*
Output:
Runtime ClassCastException occurred: java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String

Explanation:
- Arrays are reified (runtime type known) but generics are erased.
- Casting List[] to List<String>[] is unsafe (heap pollution).
- We inserted a List<Integer> into the array, and retrieving as String causes CCE at runtime.
*/
