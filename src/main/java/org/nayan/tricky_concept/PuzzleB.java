package org.nayan.tricky_concept;

public class PuzzleB {
    public static void main(String[] args) {
        pick(1);         // which overload?
      //  pick(new Integer(1));
        pick();          // empty varargs
    }

    static void pick(Integer x) { System.out.println("Integer"); }
    static void pick(int... x)  { System.out.println("int..."); }
}

/*
Output:
Integer
Integer
int...

Explanation:
- call pick(1): int literal -> can match int... (no boxing) OR be boxed to Integer.
  Overload resolution prefers *boxing + exact match* to *varargs*, so Integer wins.
- pick(new Integer(1)): exact match Integer.
- pick(): only int... applicable (zero-length), so int...
*/
