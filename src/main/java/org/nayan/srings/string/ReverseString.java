package org.nayan.srings.string;

public class ReverseString {
    public static void main(String[] args) {
        String str = "baliram";
        System.out.println(reverse(str));

        String reversed = str.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (a, b) -> b + a, (a, b) -> b + a);

        System.out.println(reversed);
    }

    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }


}
