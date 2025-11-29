package org.example.tricky_concept;

public class PuzzleH {
    public static void main(String[] args) {
        Amb a = new Amb();
        // a.proc(null); // COMPILE ERROR: reference to proc is ambiguous
        a.proc((I1) null); // picks proc(I1)
    }
}

interface I1 {}
interface I2 {}
class Impl implements I1, I2 {}

class Amb {
    void proc(I1 i) { System.out.println("I1"); }
    void proc(I2 i) { System.out.println("I2"); }
}

/*
Explanation:
- Impl implements both I1 and I2, but a plain null is applicable to both proc(I1) and proc(I2).
- Since neither I1 nor I2 is more specific, calling proc(null) is ambiguous (compile-time error).
- Casting to choose the desired overload is required.
*/
