package org.nayan.srings.java8;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStr {
    public static void main(String[] args) {
        String str = "aaa bbb cc dd eee f";
        /*String str1 = longestStr(str);
        System.out.println(str1);*/

        /*String s1 = longestStrAlgo(str);
        System.out.println(s1);*/

        String s2 = longestStrReduce(str);
        System.out.println(s2);

    }

    private static String longestStr(String str) {
        return Arrays.stream(str.split(" "))
                .max(Comparator.comparing(String::length)).orElse("");
    }

    private static String longestStrAlgo(String str) {

        String longestStr = "";
        for (String s : str.split(" ")) {
            if (s.length() > longestStr.length()) {
                longestStr = s;
            }
        }
        return longestStr;
    }
    private static String longestStrReduce(String str) {
        return Arrays.stream(str.split(" "))
                .reduce("", (a,b)-> a.length() > b.length() ? a : b);
    }

}
