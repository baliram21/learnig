package org.nayan.tricky_concept;

public class ConfusingQ {

    public int anInt; // Instance variable (field). Default value for int = 0

    public ConfusingQ(int anInt) {
        /*
         * PROBLEM:
         * --------
         * The constructor parameter name `anInt` is the SAME as the instance variable name.
         * Inside this constructor, `anInt` refers to the LOCAL PARAMETER, not the field.
         *
         * So writing:
         *      anInt = anInt;
         * means:
         *      (parameter) = (parameter);
         * The instance variable NEVER gets updated → remains 0.
         *
         * FIX:
         * ----
         * Use `this.anInt` to refer to the instance variable of the class.
         * `this.anInt` = instance variable
         * `anInt`      = constructor parameter
         */

        this.anInt = anInt;  // Correct assignment to the field
    }

    public int getAnInt() {
        return anInt; // returns the instance variable
    }

    public static void main(String[] args) {

        // Creating object with constructor parameter 20
        ConfusingQ cq = new ConfusingQ(20);

        // Since we fixed the assignment, both print 20
        System.out.println(cq.anInt);      // prints instance variable → 20
        System.out.println(cq.getAnInt()); // also prints 20
    }
}
