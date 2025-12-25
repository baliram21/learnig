package org.nayan.srings.string;

import java.util.Arrays;
import java.util.Comparator;

public class LongestString {
    public static void main(String[] args) {
        String str = "My name is bk Kumar";

        String s = method1(str);  //System.out.println(s);
        String s1 = method2(str); // System.out.println(s1);
        String s3 = method3(str);  System.out.println(s3);

    }

    private static String method3(String str) {
       return Arrays.stream(str.split(" ")).reduce((s1,s2)->s1.length()>s2.length()?s1:s2).get();
    }

    private static String method2(String str) {
        String s = Arrays.stream(str.split(" ")).max(Comparator.comparing(String::length)).get();
        return s;
    }

    private static String method1(String str) {
        int maxLengthStr=0;
        String maxlenStr="";
        for (String s : str.split(" ")) {
            if (s.length()>maxLengthStr){
                maxLengthStr=s.length();
                maxlenStr=s;
            }
        }
        return maxlenStr;
    }
}
