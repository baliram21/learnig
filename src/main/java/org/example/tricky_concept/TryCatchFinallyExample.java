package org.example.tricky_concept;

public class TryCatchFinallyExample {
    public static void main(String[] args) {
        int num = 0; // initial value

        try {
            num = 1;
            // no exception thrown, so catch won't execute
        } catch (Exception e) {
            num = 2; // executed only if an exception occurs in try
        } finally {
            num = 3; // executed always (after try or catch), even if try returns or throws
        }

        System.out.println(num); // prints 3
    }
}

/*
Explanation:
- try sets num = 1.
- No exception occurs, so catch is skipped.
- finally always executes, and sets num = 3.
- After the try/catch/finally block, num is 3, so System.out.println prints 3.
*/
