package org.nayan.recursion;

public class RecursionReverseStr {

    public static String reverse(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String name = "baliram";
        System.out.println(reverse(name));  // marilab
    }
}
