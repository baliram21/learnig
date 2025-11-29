package org.example.tricky_concept;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class PuzzleE {
    public static void main(String[] args) throws Exception {
        OverloadedSAM o = new OverloadedSAM();

        // Lambda that returns a value -> matches Callable<T> or Supplier<T>
        o.call((Supplier<String>) () -> "hello");           // picks the most specific applicable SAM
        // Lambda with no returned value -> matches Runnable only (if there is a Runnable overload)
        o.call((Supplier<String>) () -> { System.out.println("hi"); return null; }); // can match Callable<Void>

        // Explicit casts remove ambiguity:
        o.call((Supplier<String>) () -> "s");    // Supplier overload
        o.call((Callable<String>) () -> "c");    // Callable overload
    }
}

class OverloadedSAM {
    void call(Supplier<String> s) { System.out.println("Supplier"); }
    void call(Callable<String> c) { System.out.println("Callable"); }
}

/*
Notes & explanation:
- A lambda's target type is determined by context. Without a cast, if both Supplier and Callable are applicable,
  the compiler resolves based on the target inference rules — sometimes one wins, sometimes it's ambiguous.
- Explicit cast makes the intent clear.
- Using different return types or parameter shapes clarifies selection in puzzles.
*/
