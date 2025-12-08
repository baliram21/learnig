package org.nayan.extra;

public class PrintSubstrings {
    public static void main(String[] args) {
        String str = "abcd";

        for (int i = 1; i <= str.length(); i++) {
            System.out.println(str.substring(0, i));
        }
    }

}
