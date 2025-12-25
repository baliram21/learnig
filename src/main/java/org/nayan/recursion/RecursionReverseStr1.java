package org.nayan.recursion;

public class RecursionReverseStr1 {

    public static String reverse(String str) {
        return reverseHelper(str, str.length() - 1);
    }

    private static String reverseHelper(String str, int index) {
        if (index == 0) {
            return String.valueOf(str.charAt(0));
        }
        return str.charAt(index) + reverseHelper(str, index - 1);
    }

    public static void main(String[] args) {
        System.out.println(reverse("baliram"));  // marilab
    }
}
