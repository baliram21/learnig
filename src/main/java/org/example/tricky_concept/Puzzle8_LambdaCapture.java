package org.example.tricky_concept;

import java.util.function.Supplier;

public class Puzzle8_LambdaCapture {
    public static void main(String[] args) {
        // This won't compile:
        // int counter = 0;
        // Supplier<Integer> s = () -> ++counter; // error: counter must be final or effectively final

        // Workaround: use a mutable holder (array or AtomicInteger)
        final int[] holder = new int[] {0};
        Supplier<Integer> s = () -> ++holder[0];
        System.out.println(s.get()); // 1
        System.out.println(s.get()); // 2

        // Another subtlety: captured object reference must not be reassigned
        final StringBuilder sb = new StringBuilder("a");
        Runnable r = () -> sb.append("b"); // allowed: mutating object is fine
        r.run();
        System.out.println(sb); // "ab"
    }
}

/*
Output:
1
2
ab

Explanation:
- Local variables captured by lambdas must be effectively final (cannot reassign).
- You can mutate the contents of a referenced object (like array or StringBuilder).
- Common interview trap: "You can modify captured variables" — you can modify state of referenced object, but not reassign the reference itself.
*/
