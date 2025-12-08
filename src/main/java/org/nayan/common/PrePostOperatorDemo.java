package org.nayan.common;

public class PrePostOperatorDemo {

    public static void main(String[] args) {

        int count;

        System.out.println("=== BASIC INCREMENTS ===");

        count = 0;
        System.out.println("Start: " + count);

        count = count + 1;
        System.out.println("count = count + 1 → " + count);

        count += 1;
        System.out.println("count += 1 → " + count);

        count++;
        System.out.println("count++ (post) → " + count);

        ++count;
        System.out.println("++count (pre) → " + count);



        System.out.println("\n=== PRE-INCREMENT INSIDE ASSIGNMENT ===");

        count = 5;
        System.out.println("Start: " + count);

        count = ++count;
        System.out.println("count = ++count → " + count + " (valid but redundant)");



        System.out.println("\n=== POST-INCREMENT INSIDE ASSIGNMENT ===");

        count = 5;
        System.out.println("Start: " + count);

        count = count++;
        System.out.println("count = count++ → " + count + " (increment CANCELLED!)");



        System.out.println("\n=== USING IN EXPRESSIONS ===");

        count = 10;

        int a = count++;
        System.out.println("int a = count++ → a=" + a + ", count=" + count);

        count = 10;
        int b = ++count;
        System.out.println("int b = ++count → b=" + b + ", count=" + count);



        System.out.println("\n=== DECREMENT EXAMPLES ===");

        count = 3;

        count--;
        System.out.println("count-- (post) → " + count);

        --count;
        System.out.println("--count (pre) → " + count);

        count = 5;
        System.out.println("count = 5");

        int c = count--;
        System.out.println("int c = count-- → c=" + c + ", count=" + count);

        count = 5;
        int d = --count;
        System.out.println("int d = --count → d=" + d + ", count=" + count);



        System.out.println("\n=== SUMMARY OF BAD PRACTICES ===");

        System.out.println("count = ++count;  // Avoid: redundant");
        System.out.println("count = count++;  // Avoid: misleading & cancels increment");
    }
}
