package org.example.tricky_concept;

import java.util.Optional;

public class Puzzle5_BoxingVarargs {
    public static void main(String[] args) {
        overload(1);      // which one?
        overload(1L);     // long literal
        overload();       // no-arg
        overload(Optional.ofNullable(null));   // ambiguous? which overload is more specific?
    }

    static void overload(int... x) { System.out.println("int..."); }
    static void overload(Integer x) { System.out.println("Integer"); }
    static void overload(Object o) { System.out.println("Object"); }
}

/*
Expected output (Java chooses the most specific applicable overload):
Integer     // for overload(1) -> boxing preferred over varargs
Object      // for overload(1L) -> long doesn't box to Integer, but Object is applicable
int...      // overload() -> int... with zero length
Object      // overload(null) -> Object chosen because null is applicable to Integer and Object, but Object is not more specific than Integer; however ambiguity rules favor non-varargs? 
            // NOTE: overload(null) may be ambiguous if both Integer and Object are applicable - Java picks the most specific one: Integer is more specific than Object, so actually "Integer" would be chosen.
            // To avoid confusion: calling overload(null) at compile time will pick the most specific method (Integer), so result is "Integer".
            
// Real, concise outcomes:
 // overload(1)  -> Integer
 // overload(1L) -> Object
 // overload()   -> int...
 // overload((Integer) null) -> Integer

Explanation:
- Overload resolution chooses the most specific applicable method.
- Primitive int literal can be boxed to Integer; that is preferred to varargs.
- Long literal cannot be boxed to Integer; Object is chosen.
- naked null is ambiguous unless the compiler can pick the most specific; explicitly casting clarifies.
*/
