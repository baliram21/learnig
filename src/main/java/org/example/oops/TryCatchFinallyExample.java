package org.example.oops;

public class TryCatchFinallyExample {
    public static void main(String[] args) {
        int num = 0;  // Initial value of num is 0

        try {
            num = 1;  // This executes successfully; no exception occurs
        } catch (Exception e) {
            num = 2;  // This block is skipped since no exception occurred
        } finally {
            num = 3;  // This block ALWAYS runs, regardless of exception
        }

        System.out.println(num);  // Output will be: 3
    }
}

/*
===== Execution Flow =====
1. num is initialized to 0
2. try block runs and sets num = 1
3. catch block is skipped because no exception occurred
4. finally block runs and sets num = 3
5. num is printed → Output: 3
*/
